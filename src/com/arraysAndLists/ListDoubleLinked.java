package com.arraysAndLists;

import java.util.NoSuchElementException;

public class ListDoubleLinked<E> implements List<E> {

    private static class Node<E>{
        Node<E> next;
        Node<E> previous;
        E element;
        public Node(E element) {
            this.next = null;
            this.previous = null;
            this.element = element;
        }
    }

    private Node<E> head;

    public int size() {
        if (isEmpty()) return 0;
        else {
            int i = 1;
            Node<E> n = head;
            while (n.next != null) {
                i++;
                n = n.next;
            } return i;
        }
    }
    public boolean isEmpty(){
        return head == null;
    }
    public void setLastElement(E element) {
        if (head == null) head = new Node<>(element);
        else {
            Node<E> n = head;
            while (n.next != null) n = n.next;
            n.next = new Node<>(element);
            n.next.previous = n;
        }
    }
    public void setElement(E element, int index) {
        if (element == null) throw new NullPointerException("Element is null.");
        if (size() <= index) throw new ArrayIndexOutOfBoundsException("Index out of bounds.");
        Node<E> n = head;
        for (int i = 0; i<index-1; i++) n = n.next;
        Node<E> tmp = n.next;
            n.next = new Node<>(element);
            n.next.previous = n;
            n.next.next = tmp;
            tmp.previous = n.next;
    }
    public E getLastElement(){
        if (isEmpty()) throw new NoSuchElementException("List is empty.");
        Node<E> n = head;
        while (n.next != null) n = n.next;
        return n.element;
    }
    public E getElement(int index) {
        if (isEmpty()) throw new NoSuchElementException("List is empty.");
        Node<E> n = head;
        if (size() <= index) throw new ArrayIndexOutOfBoundsException("Index out of bounds.");
        for (int i = 0; i < index; i++) {
            n = n.next;
        } return n.element;
    }
    public E deleteLastElement(){
        Node<E> n = head;
        while (n.next.next != null) n = n.next;
        E element = n.next.element;
        n.next = null;
        return element;
    }
    public E deleteElement(int index){
        Node<E> n = head;
        for (int i = 0; i<index-1; i++) {
            if (n.next == null) throw new ArrayIndexOutOfBoundsException("Index out of bounds.");
            n = n.next;
        }
        E element = n.next.element;
        Node<E> tmp = n.next.next;
        tmp.previous = n;
        n.next = tmp;
        return element;
    }
    public void displayList() {
        if (isEmpty()) throw new NoSuchElementException("List is empty.");
        Node<E> n = head;
        System.out.print("[");
        while (n != null){
            System.out.print(n.element + " , ");
            n = n.next;
        } System.out.println("\b\b\b]");
    }
}

