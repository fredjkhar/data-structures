package com.arraysAndLists;

public interface Deque<T> {
    void insertFirst(T element);
    void insertLast(T element);
    T removeFirst();
    T removeLast();
    T getFirst();
    T getLast();
    int size();
    boolean isEmpty();
}
