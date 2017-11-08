package com.simon.datastructure.javadatastructure;

/**
 * auther: Simon zhang
 * Emaill:18292967668@163.com
 */

public class LinkedStackTest {
    public static void main(String[] args){
        LinkedStack<String> stack=new LinkedStack(20);

        System.out.println("stack.isEmpty():"+stack.isEmpty());
        stack.push("A");
        stack.push("B");
        stack.push("C");
        System.out.println("stack"+stack);


        for (int i = 0; i <20 ; i++) {
            stack.push("B"+i);
        }
        String pop = stack.pop();
        System.out.println("stack.pop():"+pop);
        System.out.println("stack after pop:"+stack);

        System.out.println("stack.isFull():"+stack.isFull());


    }
}
