package com.zeelam.linearList;

public interface List<T> {

    int ELEMENT_NOT_FOUND = -1;

    /**
     * remove all elements
     */
    void clear();

    /**
     * return the number of element in arraylist
     * @return
     */
    int size();

    /**
     * judge whether the array list is empty
     * @return
     */
    boolean isEmpty();

    /**
     * judge whether the array list contain the element
     * @return
     */
    boolean contains(T element);
    /**
     * add the element to array
     * @param element
     */
    void add(T element);

    /**
     * get the element by index in array
     * @param index
     * @return
     */
    T get(int index);

    /**
     * set the element to the position of array list by index and return the old element
     * @param index
     * @param element
     * @return
     */
    T set(int index, T element);

    /**
     * add the element into the array list by index
     * @param index
     * @param element
     */
    void add(int index, T element);

    /**
     * remove the element by index
     * @param index
     * @return
     */
    T remove(int index);

    /**
     * return the index of element
     * @param element
     * @return
     */
    int indexOf(T element);

}
