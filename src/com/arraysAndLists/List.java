package com.arraysAndLists;

public interface List<T> {
    int size();
    boolean isEmpty();
    void setLastElement(T element);
    void setElement(T element,int index);
    T getLastElement();
    T getElement(int index);
    T deleteLastElement();
    T deleteElement(int index);
    void displayList();

}
