package com.zeelam.linearList;

public class Main {

    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>();
//        list.add(0);
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
////        list.remove(2);
//        list.add(list.size(), 100);
//        System.out.println(list);

        List<Integer> linkedList = new LinkedList<>();
        linkedList.add(0);
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.remove(2);
        linkedList.add(linkedList.size(), 100);
        System.out.println(linkedList);
    }


}
