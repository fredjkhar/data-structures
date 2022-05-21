package com.arraysAndLists;

public interface Stack<T> {
    void push(T element);
    T pop();
    T peek();
    int size();
    boolean isEmpty();
}
