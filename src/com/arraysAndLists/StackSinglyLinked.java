package com.arraysAndLists;

public class StackSinglyLinked<T> implements Stack<T> {
    private static class Node<T> {
        Node<T> next;
        T element;

        public Node(T element) {
            this.next = null;
            this.element = element;
        }
    }

    Node<T> top;
    int size = 0;

    public int size() {return size;}

    public boolean isEmpty() {return top == null;}

    public void push(T element) {
        if (top == null) top = new Node<>(element);
        Node<T> tmp = top;
        top = new Node<>(element);
        top.next = tmp;
        size++;
    }

    public T pop() {
        if (isEmpty()) throw new IllegalArgumentException("Array is empty.");
        T element = top.element;
        top = top.next;
        size--;
        return element;
    }

    public T peek() {
        if (isEmpty()) throw new IllegalArgumentException("Array is empty.");
        return top.element;
    }
}
