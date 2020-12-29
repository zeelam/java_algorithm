package com.zeelam.linearList.circularLinkedList.single;

import com.zeelam.linearList.AbstractList;

public class LinkedList<T> extends AbstractList<T> {

    private Node<T> first;

    private static class Node<T> {
        T element;
        Node<T> next;

        public Node(T element, Node<T> next) {
            this.element = element;
            this.next = next;
        }

    }

    @Override
    public void clear() {
        first = null;
        size = 0;
    }

    @Override
    public T get(int index) {
        return node(index).element;
    }

    @Override
    public T set(int index, T element) {
        Node<T> node = node(index);
        T old = node.element;
        node.element = element;
        return old;
    }

    @Override
    public void add(int index, T element) {
        rangeCheckForAdd(index);
        if (index == 0){
            Node<T> newFirst = new Node<>(element, first);
            // get last node
            Node<T> last = (size == 0) ? newFirst : node(size - 1);
            last.next = first;
            first = newFirst;
        } else {
            Node<T> prev = node(index - 1);
            prev.next = new Node<>(element, prev.next);
        }
        size++;
    }

    @Override
    public T remove(int index) {
        rangeCheck(index);
        T element = null;
        if (index == 0){
            if (size == 1){
               first = null;
            } else {
                // get the last node at first
                Node<T> last = node(size - 1);

                element = first.element;
                first = first.next;

                last.next = first;
            }
        } else {
            Node<T> prev = node(index - 1);
            element = prev.next.element;
            prev.next = prev.next.next;
        }
        size--;
        return element;
    }

    @Override
    public int indexOf(T element) {
        Node<T> node = this.first;
        int index = 0;
        while(node != null) {
            if (element == null) {
                if (node.element == null) return index;
            } else {
                if (node.element.equals(element)) return index;
            }
            node = node.next;
            index++;
        }
        return ELEMENT_NOT_FOUND;

    }

    @Override
    public String toString() {
        Node<T> node = this.first;
        StringBuilder sb = new StringBuilder(20);
        sb.append("LinkedList{ size=").append(size).append(", elements=").append("[");
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                sb.append(", ");
            }
            sb.append(node.element);
            node = node.next;
        }
        return  sb.append("] }").toString();
    }


    private Node<T> node(int index) {
        rangeCheck(index);
        Node<T> node = this.first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }
}
