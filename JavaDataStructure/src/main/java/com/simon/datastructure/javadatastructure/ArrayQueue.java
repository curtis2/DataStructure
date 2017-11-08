package com.simon.datastructure.javadatastructure;

/**
 * auther: Simon zhang
 * Emaill:18292967668@163.com
 *
 *  队列 - 顺序表的实现
 */
public class ArrayQueue<E>{
    /**
     * 用于存储队列元素的数组
     */
    Object[] elements;
    /**
     * 用于表示队列尾部元素的下表
     */
    int last;
    /**
     * 用于表示队列的容量
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
        this.last=0;
        this.maxSize=maxSize;
        this.elements=new Object[maxSize];
    }

    /**
     * 生成的队列Q是否为满。
     */
    public boolean isFull() {
        return last==maxSize;
    }

    /**
     * 将数据元素插入队列Q中。
     * @param e
     */
    public void push(E e){
        if(isFull()){
            System.out.println("Queue is full now..");
        }else{
            elements[last++]=e;
        }
    }

    /**
     * 将队头数据元素从队列中删除并返回。
     */
    public E pop(){
/*        if(isEmpty()){
            System.out.println("Queue is empty now..");
            return null;
        }else{
            E popE=(E)elements[frist];
            elements[frist]=null;
            frist++;
            return popE;
        }
        */
        //优化，元素统一向前移动一位，可以优化队列的空间使用
        if(isEmpty()){
            System.out.println("Queue is empty now..");
            return null;
        }else{
            E popE=(E)elements[0];
            for (int i = 0; i <last-1 ; i++) {
                elements[i]=elements[i+1];
            }
            last--;
            return popE;
        }
    }

    /**
     * 判断队列是否为空。
     */
    public boolean isEmpty(){
        return last==0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i <last; i++) {
            sb.append(elements[i].toString());
            if(i!=last-1){
                sb.append(',');
            }
        }
        sb.append(']').toString();
        return  sb.toString();
    }

}
