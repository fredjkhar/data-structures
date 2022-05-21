package com.arraysAndLists;

public class StackArray<T> implements Stack<T> {
    private final T[] array;
    private int top;

    public StackArray() {
        this.array = (T[]) new Object[1000];
        this.top = -1;
    }

    public StackArray(int size) {
        this.array = (T[]) new Object[size];
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
        if (isFull()) throw new ArrayStoreException("Array is full.");
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
