package com.zeelam.linearList;

public class ArrayList {

    /**
     * to count the number of elements in array
     */
    private int size;

    /**
     * the array to store the elements
     */
    private int[] elements;

    private static final int DEFAULT_CAPACITY = 10;

    private static final int ELEMENT_NOT_FOUND = -1;

    public ArrayList(){
        this(DEFAULT_CAPACITY);
    }

    public ArrayList(int capacity) {
        capacity = capacity < DEFAULT_CAPACITY ? DEFAULT_CAPACITY : capacity;
        elements = new int[capacity];
    }

    /**
     * remove all elements
     */
    public void clear() {
        size = 0;
    }

    /**
     * return the number of element in arraylist
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * judge whether the array list is empty
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * judge whether the array list contain the element
     * @return
     */
    public boolean contains(int element) {
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }

    /**
     * add the element to array
     * @param element
     */
    public void add(int element) {

    }

    /**
     * get the element by index in array
     * @param index
     * @return
     */
    public int get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        return elements[index];
    }

    /**
     * set the element to the position of array list by index and return the old element
     * @param index
     * @param element
     * @return
     */
    public int set(int index, int element) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        int old = elements[index];
        elements[index] = element;
        return old;
    }

    /**
     * add the element into the array list by index
     * @param index
     * @param element
     */
    public void add(int index, int element) {

    }

    /**
     * remove the element by index
     * @param index
     * @return
     */
    public int remove(int index) {
        return 0;
    }

    /**
     * return the index of element
     * @param element
     * @return
     */
    public int indexOf(int element) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == element) return i;
        }
        return ELEMENT_NOT_FOUND;
    }

}
