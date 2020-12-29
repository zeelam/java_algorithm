package com.zeelam.linearList;

public class LinkedList<T> extends AbstractList<T> {

    private Node<T> first;
    private Node<T> last;

    private static class Node<T> {
        T element;
        Node<T> prev;
        Node<T> next;

        public Node(Node<T> prev, T element, Node<T> next) {
            this.prev = prev;
            this.element = element;
            this.next = next;
        }

    }

    @Override
    public void clear() {
        first = null;
        last = null;
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
        if (index == size){
            last = new Node<>(last, element, null);
            if (last.prev == null){
                first = last;
            } else {
                last.prev.next = last;
            }
        } else {
            Node<T> next = node(index);
            Node<T> prev = next.prev;
            Node<T> node = new Node<>(prev, element, next);
            next.prev = node;
            if (prev == null) {
                first = node;
            } else {
                prev.next = node;
            }
        }
        size++;
    }

    @Override
    public T remove(int index) {
        rangeCheck(index);

        Node<T> node = node(index);
        Node<T> prev = node.prev;
        Node<T> next = node.next;
        if (prev == null) first = next;
        else prev.next = next;
        if (next == null) last = prev;
        else next.prev = prev;

        size--;
        return node.element;
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
        if (index < (size >> 1)) {
            Node<T> node = this.first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        } else {
            Node<T> node = this.last;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
            return node;
        }
    }
}
