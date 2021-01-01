package com.zeelam.linearList;

public class Queue<T> {

    private List<T> list = new LinkedList<>();

    public int size(){
        return list.size();
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public void enQueue(T element){
        list.add(element);
    }

    public T deQueue(){
        return list.remove(0);
    }

    public T front(){
        return list.get(0);
    }

    public void clear(){
        list.clear();
    }

}
