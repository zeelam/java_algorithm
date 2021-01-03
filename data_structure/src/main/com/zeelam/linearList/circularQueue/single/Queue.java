package com.zeelam.linearList.circularQueue.single;

public class Queue<T> {

    private T[] elements;
    private int size;
    private int front;

    private static final int DEFAULT_CAPACITY = 10;

    public Queue() { this(DEFAULT_CAPACITY);}

    public Queue(int capacity) {
        elements = (T[]) new Object[Math.max(capacity, DEFAULT_CAPACITY)];
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void enQueue(T element){
        ensureCapacity(size + 1);
        elements[index(size)] = element;
        size++;
    }

    public T deQueue(){
        T old = elements[front];
        elements[front] = null;
        front = index(1);
        size--;
        return old;
    }

    public T front(){
        return elements[front];
    }

    public void clear(){
        for (int i = 0; i < size; i++) {
            elements[index(i)] = null;
        }
        front = 0;
        size = 0;
    }

    private int index(int index){
        return (index + front) % elements.length;
    }

    private void ensureCapacity(int capacity) {
        if (elements.length < capacity) {
            T[] newElements = (T[]) new Object[elements.length + (elements.length >> 1)];
            for (int i = 0; i < size; i++) {
                newElements[i] = elements[index(i)];
            }
            elements = newElements;
            front = 0;
        }
    }

}
