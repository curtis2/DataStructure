package com.simon.datastructure.javadatastructure;

/**
 * auther: Simon zhang
 * Emaill:18292967668@163.com
 */

public class ArrayQueueTest{
    public static void main(String[] args){
        ArrayQueue<String>  queue=new ArrayQueue<>(20);

        System.out.println("queue.isEmpty():"+queue.isEmpty());
        queue.push("A");
        queue.push("B");
        queue.push("C");
        System.out.println("queue"+queue);

        for (int i = 0; i <20 ; i++) {
            queue.push("B"+i);
        }
        String pop = queue.pop();
        System.out.println("queue.pop():"+pop);
        System.out.println("queue after pop:"+queue);

        System.out.println("queue.isFull():"+queue.isFull());
        
    }
}