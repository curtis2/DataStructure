package com.simon.datastructure.javadatastructure;

/**
 * auther: Simon zhang
 * Emaill:18292967668@163.com
 *
 *  队列 - 顺序表的实现
 */
public class ArrayQueue<E>{
    /**
     * 用于存储栈元素的数组
     */
    Object[] elements;
    /**
     * 用于表示栈顶元素的下表
     */
    int top;
    /**
     * 用于表示栈的容量
     */
    int maxSize;

    /**
     * 生成长度为MaxSize的空队列;
     * @param maxSize
     */
    public ArrayQueue(int maxSize) {
        if(maxSize<0){
            throw  new IllegalArgumentException("stack size must more than zero..");
        }
        this.maxSize = maxSize;
        this.top=-1;
        this.elements=new Object[maxSize];
    }

    /**
     * 生成的队列Q是否为满。
     */
    public boolean isFull() {
        return top==(maxSize-1);
    }

    /**
     * 将数据元素插入队列Q中。
     * @param e
     */
    public void push(E e){
        if(isFull()){
            System.out.println("stack is full now..");
        }else{
            elements[++top]=e;
        }
    }

    /**
     * 将队头数据元素从队列中删除并返回。
     */
    @SuppressWarnings("unchecked")
    public E pop(){
        if(isEmpty()){
            System.out.println("stack is empty now..");
            return null;
        }else{
            E popE=(E) elements[0];
            elements[0]=null;
            top--;
            return popE;
        }
    }

    /**
     * 判断队列是否为空。
     */
    public boolean isEmpty(){
        return top==-1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i <top+1; i++) {
            sb.append(elements[i].toString());
            if(i!=top){
                sb.append(',');
            }
        }
        sb.append(']').toString();
        return  sb.toString();
    }


}
