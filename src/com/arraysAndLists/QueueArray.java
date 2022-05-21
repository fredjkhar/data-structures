package com.arraysAndLists;

public class QueueArray<T> implements Queue<T>{
    private final T[] array;
    private int front,rear;
    private final int size;

    public QueueArray(int size) {
        this.array = (T[]) new Object[size];
        this.size = size;
        this.front = 0;
        this.rear = 0;
    }

    public void enqueue(T element) {
        if (isFull()) throw new ArrayStoreException("Queue is full");
        array[rear] = element;
        rear = ((rear + 1) % size);
    }

    public T dequeue() {
        if (isEmpty()) throw new ArrayStoreException("Queue is empty");
        T element = array[front];
        array[front] = null;
        front = ((front + 1) % size);
        return element;
    }

    public int size() {
        return (size - front + rear) % size;
    }
    public boolean isFull() {
        return size() == size - 1;
    }


    public boolean isEmpty() {
        return front == rear;
    }


    public T front() {
        if (isEmpty()) throw new NullPointerException("Queue is empty");
        return array[front];
    }
    public T rear() {
        if (isEmpty()) throw new NullPointerException("Queue is empty");
        return array[(size + rear - 1) % size];
    }
}
