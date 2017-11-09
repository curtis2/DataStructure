package com.simon.datastructure.javadatastructure;

/**
 * auther: Simon zhang
 * Emaill:18292967668@163.com
 */

public class LinkedQueueTest {
    public static void main(String[] args){
        LinkedQueue<String>  queue=new LinkedQueue<>(10);

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

        queue.push("D");
        queue.push("E");
        queue.push("F");

        String pop2 = queue.pop();
        System.out.println("queue.pop():"+pop2);
        System.out.println("queue after pop:"+queue);

    }
}
