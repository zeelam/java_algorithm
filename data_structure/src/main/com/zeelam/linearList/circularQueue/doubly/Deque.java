package com.zeelam.linearList.circularQueue.doubly;

public class Deque<T> {
    private T[] elements;
    private int size;
    private int front;

    private static final int DEFAULT_CAPACITY = 10;

    public Deque() { this(DEFAULT_CAPACITY);}

    public Deque(int capacity) {
        elements = (T[]) new Object[Math.max(capacity, DEFAULT_CAPACITY)];
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void enQueueRear(T element){
        ensureCapacity(size + 1);
        elements[index(size)] = element;
        size++;
    }

    public T deQueueRear(){
        int rearIndex = index(size - 1);
        T old = elements[rearIndex];
        elements[rearIndex] = null;
        size--;
        return old;
    }

    public T rear(){
        return elements[index(size - 1)];
    }

    public void enQueueFront(T element){
        ensureCapacity(size + 1);
        front = index(-1);
        elements[front] = element;
        size++;
    }

    public T deQueueFront(){
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
        index += front;
        if (index < 0) return index + elements.length;
        return index % elements.length;
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
