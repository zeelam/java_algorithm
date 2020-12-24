package com.zeelam.linearList;

import java.util.Objects;

public class ArrayList<T> extends AbstractList<T>{

    /**
     * the array to store the elements
     */
    private T[] elements;

    private static final int DEFAULT_CAPACITY = 10;


    public ArrayList(){
        this(DEFAULT_CAPACITY);
    }

    public ArrayList(int capacity) {
        capacity = Math.max(capacity, DEFAULT_CAPACITY);
        elements = (T[]) new Object[capacity];
    }

    /**
     * remove all elements
     */
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
        if (elements != null && elements.length > DEFAULT_CAPACITY) {
            elements = (T[]) new Object[DEFAULT_CAPACITY];
        }
    }

    /**
     * get the element by index in array
     * @param index
     * @return
     */
    public T get(int index) {
        rangeCheck(index);
        return elements[index];
    }

    /**
     * set the element to the position of array list by index and return the old element
     * @param index
     * @param element
     * @return
     */
    public T set(int index, T element) {
        rangeCheck(index);
        T old = elements[index];
        elements[index] = element;
        return old;
    }

    /**
     * add the element into the array list by index
     * @param index
     * @param element
     */
    public void add(int index, T element) {
        rangeCheckForAdd(index);
        ensureCapacity(size + 1);
        for (int i = size; i > index ; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        size++;
    }

    /**
     * remove the element by index
     * @param index
     * @return
     */
    public T remove(int index) {
        rangeCheck(index);
        T old = elements[index];
        for (int i = index; i < size; i++) {
            elements[i] = elements[i + 1];
        }
        elements[--size] = null;

        trim();

        return old;
    }

    private void trim() {
        int capacity = elements.length;
        if (size >= (capacity >> 1) || capacity <= DEFAULT_CAPACITY) return;
        int newCapacity = capacity >> 1;
        T[] newElements = (T[])new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
    }

    /**
     * return the index of element
     * @param element
     * @return
     */
    public int indexOf(T element) {
        if (element == null){
            for (int i = 0; i < size; i++) if (elements[i] == null) return i;
        } else {
            for (int i = 0; i < size; i++) if (elements[i].equals(element)) return i;
        }
        return ELEMENT_NOT_FOUND;
    }

    private void ensureCapacity(int capacity) {
        if (elements.length < capacity) {
            T[] newElements = (T[]) new Object[elements.length + (elements.length >> 1)];
            for (int i = 0; i < size; i++) {
                newElements[i] = elements[i];
            }
            elements = newElements;
        }
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(20);
        sb.append("ArrayList{ size=").append(size).append(", elements=").append("[");
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                sb.append(", ");
            }
            sb.append(elements[i]);
        }
        return  sb.append("] }").toString();
    }
}
