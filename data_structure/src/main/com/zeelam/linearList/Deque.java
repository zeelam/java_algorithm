package com.zeelam.linearList;

public class Deque<T> {

    private List<T> list = new LinkedList<>();

    public int size(){
        return list.size();
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public void clear(){
        list.clear();
    }

    public void enQueueRear(T element) {
        list.add(element);
    }

    public T deQueueRear(){
        return list.remove(list.size() - 1);
    }

    public void enQueueFront(T element){
        list.add(0, element);
    }

    public T deQueueFront(){
        return list.remove(0);
    }


    public T front(){
        return list.get(0);
    }

    public T rear(){
        return list.get(list.size() - 1);
    }


}
