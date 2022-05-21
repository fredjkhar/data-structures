package com.arraysAndLists;

import java.util.LinkedList;

public class StackExtensibleArray<T> implements Stack<T> {
    private T[] array;
    private int top;

    public StackExtensibleArray() {
        this.array = (T[]) new Object[1];
        this.top = -1;
    }

    public int size() {return top + 1;}

    public boolean isEmpty(){return top == -1;}

    public boolean isFull(){return top + 1 == array.length;}

    public T peek() {
        if (isEmpty()) throw new IllegalArgumentException("Array is empty.");
        return array[top];
    }

    public void push(T element){
        //phase
        if (isFull()) {
            T[] tmpArray = (T[])  new Object[array.length*2];
            for (int i = 0; i < array.length; i++) tmpArray[i] = array[i];
            array = tmpArray;
        }
        //simple push
        array[++top] = element;
    }

    public T pop(){
        if (isEmpty()) throw new IllegalArgumentException("Array is empty.");
        T element = array[top];
        array[--top] = null;
        return element;
        //or return array[top--];
    }
}
