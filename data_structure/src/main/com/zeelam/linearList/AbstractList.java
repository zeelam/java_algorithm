package com.zeelam.linearList;

public abstract class AbstractList<T> implements List<T> {

    protected int size;

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
    public boolean contains(T element) {
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }

    /**
     * add the element to array
     * @param element
     */
    public void add(T element) {
        add(size, element);
    }

    protected void outOfBounds(int index){
        throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    protected void rangeCheck(int index){
        if (index < 0 || index >= size) outOfBounds(index);
    }

    protected void rangeCheckForAdd(int index){
        if (index < 0 || index > size) outOfBounds(index);
    }

}
