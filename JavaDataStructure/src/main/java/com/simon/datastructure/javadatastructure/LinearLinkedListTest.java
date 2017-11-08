package com.simon.datastructure.javadatastructure;

/**
 * auther: Simon zhang
 * Emaill:18292967668@163.com
 */

public class LinearLinkedListTest {
    public static void main(String[] args){
        LinearLinkedList<Integer> list=new LinearLinkedList<>();
   /*     list.add(1);
         list.add(2);
         list.add(3);
         list.add(11,3);
         list.add(4);
         list.add(5);
*/
/*
        for (int i = 0; i <30000 ; i++) {
            list.add(i+1);
        }
        list.add(5,2);
        System.out.println(list);
        System.out.println("list.get(3):"+list.get(3));
        System.out.println("size:"+list.size());
        System.out.println("list.remove:"+list.remove(3));
        System.out.println("list.indexOf(11):"+list.indexOf(11));
*/

 /*       //测试LinearLinkedList类和LinkedList类添加30000个数据所需要的Time
        LinearLinkedList<String>  linearLinkedList=new LinearLinkedList<>();
        Long saBeginTime=System.currentTimeMillis();//记录BeginTime
        for(int i=0;i<30000;i++){
            linearLinkedList.add("now"+i);
        }
        Long saEndTime=System.currentTimeMillis();//记录EndTime
        System.out.println("LinearLinkedList  add time--->"+(saEndTime-saBeginTime));*/

        java.util.LinkedList<String> linkedList=new java.util.LinkedList<>();
        Long slBeginTime=System.currentTimeMillis();//记录BeginTime
        for(int i=0;i<30000;i++){
            linkedList.add("now"+i);
        }
        Long slEndTime=System.currentTimeMillis();//记录EndTime
        System.out.println("JDK linkedList add time---->"+(slEndTime-slBeginTime));

        //测试结论：这个版本的LinearLinkedList被Jdk完爆了..  要继续优化...
    }
}
