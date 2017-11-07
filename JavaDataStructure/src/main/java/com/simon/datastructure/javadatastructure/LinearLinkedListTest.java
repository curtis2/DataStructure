package com.simon.datastructure.javadatastructure;

/**
 * auther: Simon zhang
 * Emaill:18292967668@163.com
 */

public class LinearLinkedListTest {
    public static void main(String[] args){
        LinearLinkedList<Integer> list=new LinearLinkedList<>();
        list.add(1);
         list.add(2);
         list.add(3);
         list.add(5,2);
         list.add(4);
         list.add(5);

/*        for (int i = 0; i <30000 ; i++) {
            list.add(i+1);
        }
        list.add(5,2)*/;
        System.out.println(list);
        System.out.println("list.get(3):"+list.get(3));
        System.out.println("size:"+list.size());
    }
}
