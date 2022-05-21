package com.arraysAndLists;

public class DequeDoubleLinked<T> implements Deque<T>{

    private static class Node<T> {
        private T element;
        private Node<T> next,previous;

        public Node(T element) {
            this.element = element;
            this.next = null;
            this.previous = null;
        }
    }
    Node<T> head = new Node<>(null);
    Node<T> tail = new Node<>(null);
    int size = 0;

    public void insertFirst(T element) {
        if (isEmpty()) {
            head.next = new Node<>(element);
            head.next.previous = head;
            tail.previous = head.next;
            head.next.next = tail;
        } else {
            Node<T> tmp = head.next;
            head.next = new Node<>(element);
            head.next.previous = head;
            tmp.previous = head.next;
            head.next.next = tmp;
        } size++;
    }

    public void insertLast(T element) {
        if (isEmpty()) {
            head.next = new Node<>(element);
            head.next.previous = head;
            tail.previous = head.next;
            head.next.next = tail;
        } else {
            Node<T> tmp = tail.previous;
            tail.previous = new Node<>(element);
            tail.previous.next = tail;
            tmp.next = tail.previous;
            tail.previous.previous = tmp;
        } size++;
    }

    public T removeFirst() {
        if (isEmpty()) throw new NullPointerException("Deque is empty.");
        T element = head.next.element;
        head.next = head.next.next;
        head.next.previous = head;
        size--;
        return element;
    }

    public T removeLast() {
        if (isEmpty()) throw new NullPointerException("Deque is empty.");
        T element = tail.previous.element;
        tail.previous = tail.previous.previous;
        tail.previous.next = tail;
        size--;
        return element;
    }


    public T getFirst() {
        if (isEmpty()) throw new NullPointerException("Deque is empty.");
        return head.next.element;
    }


    public T getLast() {
        if (isEmpty()) throw new NullPointerException("Deque is empty.");
        return tail.previous.element;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return head.next == null & tail.previous == null;
    }
}
