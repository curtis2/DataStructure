package com.simon.datastructure.javadatastructure;

public class LinearTest {
    public static void main(String[] args){
         LinearArrayList<Integer> list=new LinearArrayList<>();
 /*      list.add(1);
         list.add(2);
         list.add(3);
         list.add(5,2);
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
*/
        //测试自己实现的LinearList类和ArrayList类添加30000个数据所需要的时间
        LinearArrayList<String> ll = new LinearArrayList<>();
        Long aBeginTime=System.currentTimeMillis();//记录BeginTime
        for(int i=0;i<30000;i++){
            ll.add("now"+i,i);
        }
        Long aEndTime=System.currentTimeMillis();//记录EndTime
        System.out.println("LinearList  add time--->"+(aEndTime-aBeginTime));

    /*   ArrayList<String> al = new ArrayList<>();
        Long lBeginTime=System.currentTimeMillis();//记录BeginTime
        for(int i=0;i<3000000;i++){
            al.add(i,"now"+i);
        }
        Long lEndTime=System.currentTimeMillis();//记录EndTime
        System.out.println("ArrayList add time---->"+(lEndTime-lBeginTime));*/
    }
}
