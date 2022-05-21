package com.sequences;

public class NodeList<T> {

    private static class Node<T> {
        private T element;
        private Node<T> next;
        private Node<T> previous;

        public T getElement() {return element;}

        public void setElement(T element) {this.element = element;}

        public Node<T> getNext() {return next;}

        public void setNext(Node<T> next) {this.next = next;}

        public Node<T> getPrevious() {return previous;}

        public void setPrevious(Node<T> previous) {this.previous = previous;}
    }

    Node<T> header = new Node<>();
    Node<T> trailer = new Node<>();

    boolean isEmpty() {return header.next == null && trailer.previous == null;}

    Node<T> first(){
        if (isEmpty()) throw new IllegalArgumentException();
        return header.next;
    }

    Node<T> last(){
        if (isEmpty()) throw new IllegalArgumentException();
        return header.previous;
    }

    Node<T> prev(Node<T> p){
        if (p.getPrevious() == header || isEmpty()) throw new IllegalArgumentException();
        return p.previous;
    }

    Node<T> next(Node<T> p){
        if (p.getNext() == trailer || isEmpty()) throw new IllegalArgumentException();
        return p.next;
    }

    void set(Node<T> p,Node<T> e) {
        if (isEmpty()) throw new IllegalArgumentException();

    }


}
