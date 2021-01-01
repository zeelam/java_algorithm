package com.zeelam.linearList;

public class Stack<T> {

    private List<T> list = new LinkedList<>();

    public void clear(){
        list.clear();
    }

    public int size(){
        return list.size();
    }

    public boolean isEmpty(){
        return list.size() == 0;
    }

    public void push(T element){
        list.add(element);
    }

    public T pop(){
        return list.remove(list.size() - 1);
    }

    public T top(){
        return list.get(list.size() - 1);
    }

}
