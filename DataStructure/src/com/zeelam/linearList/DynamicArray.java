package com.zeelam.linearList;

public class DynamicArray {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
//        list.remove(2);
        list.add(list.size(), 100);
        System.out.println(list);
    }


}
