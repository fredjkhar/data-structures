package com.arraysAndLists;

public class QueueSinglyLinked<T> implements Queue<T> {

    private static class Node<T>{
        Node<T> next;
        T element;

        public Node(T element) {
            this.next = null;
            this.element = element;
        }
    }

    private int size = 0;
    private Node<T> head,tail;

    public void enqueue(T element) {
        if (isEmpty()) {
            head = new Node<>(element);
            tail = head;
        } else {
            tail.next = new Node<>(element);
            tail = tail.next;
        } size++;
    }

    public T dequeue() {
        if (isEmpty()) throw new NullPointerException("Queue is empty.");
        T element = head.element;
        head = head.next;
        size--;
        return element;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public T head() {
        if (isEmpty()) throw new NullPointerException("Queue is empty.");
        return head.element;
    }
    public T tail() {
        if (isEmpty()) throw new NullPointerException("Queue is empty.");
        return tail.element;
    }
}
