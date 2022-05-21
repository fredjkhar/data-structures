package com.arraysAndLists;

import java.util.NoSuchElementException;

public class ListSinglyLinked<T> implements List<T> {

    private static class Node<T>{
       Node<T> next;
       T element;
       Node(T element) {
           this.element = element;
           next = null;
       }
    }

    private Node<T> head;

    public int size(){
        if (isEmpty()) return 0;
        else {
            int i = 1;
            Node<T> n = head;
            while (n.next != null) {
                i++;
                n = n.next;
            } return i;
        }
    }
    public boolean isEmpty() { return head == null; }

    public void setLastElement(T element){
        if (element == null) throw new NullPointerException("Element is null.");
        if (isEmpty()) head = new Node<>(element);
        else {
            Node<T> n = head;
            while (n.next != null) n = n.next;
            n.next = new Node<>(element);
        }
    }
    public void setElement(T element,int index) {
        if (element == null) throw new NullPointerException("Element is null.");
        if (size() <= index) throw new ArrayIndexOutOfBoundsException("Index out of bounds.");
        Node<T> n = head;
        for (int i = 0; i < index-1; i++) {
            n = n.next;
        }
        Node<T> p = n.next;
        n.next = new Node<>(element);
        n.next.next = p;
    }
    public T getLastElement(){
        if (isEmpty()) throw new NoSuchElementException("List is empty.");
        Node<T> n = head;
        while (n.next != null) n = n.next;
        return n.element;
    }
    public T getElement(int index) {
        if (isEmpty()) throw new NoSuchElementException("List is empty.");
        Node<T> n = head;
        if (size() <= index) throw new ArrayIndexOutOfBoundsException("Index out of bounds.");
        for (int i = 0; i < index; i++) {
            n = n.next;
        } return n.element;
    }
    public T deleteLastElement(){
        Node<T> n = head;
        while (n.next.next != null) n = n.next;
        T element = n.next.element;
        n.next = null;
        return element;
    }
    public T deleteElement(int index){
        Node<T> n = head;
        for (int i = 0; i<index-1; i++) {
            if (n.next == null) throw new ArrayIndexOutOfBoundsException("Index out of bounds.");
            n = n.next;
        }
        T element = n.next.element;
        n.next = n.next.next;
        return element;
    }
    public void displayList() {
        if (isEmpty()) throw new NoSuchElementException("List is empty.");
        Node<T> n = head;
        System.out.print("[");
        while (n != null){
            System.out.print(n.element + " , ");
            n = n.next;
        } System.out.println("\b\b\b]");
    }
}
