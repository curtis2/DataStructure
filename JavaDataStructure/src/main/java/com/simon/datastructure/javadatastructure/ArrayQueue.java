package com.simon.datastructure.javadatastructure;

/**
 * auther: Simon zhang
 * Emaill:18292967668@163.com
 *  队列 - 顺序表的实现
 */
public class ArrayQueue<E>{
    /**
     * 用于存储队列元素的数组
     */
    Object[] elements;
    /**
     * 用于表示队列头部元素的下表
     */
    int first;
    /**
     * 用于表示队列尾部元素的下表
     */
    int last;
    /**
     * 用于表示队列的容量
     */
    int maxSize;
    /**
     * 用于表示队列中元素的数量
     */
    int size;
    /**
     * 生成长度为MaxSize的空队列;
     * @param maxSize
     */
    public ArrayQueue(int maxSize) {
        if(maxSize<0){
            throw  new IllegalArgumentException("stack size must more than zero..");
        }
        this.last=first=0;
        this.maxSize=maxSize;
        this.elements=new Object[maxSize];
    }

    /**
     *  生成的队列Q是否为满。
     */
    public boolean isFull() {
        return size==maxSize;
    }

    /**
     * 将数据元素插入队列Q中。
     * @param e
     */
    public void push(E e){
        if(isFull()){
            System.out.println("Queue is full now..");
        }else{
            elements[last]=e;
            last=(last+1)%maxSize;
            size++;
        }
    }

    /**
     * 将队头数据元素从队列中删除并返回。
     */
    public E pop(){
        //优化，循环数组实现
        if(isEmpty()){
            System.out.println("Queue is empty now..");
            return null;
        }else{
            E popE=(E)elements[first];
            elements[first]=null;
            first=(first+1)%maxSize;
            size--;
            return popE;
        }
    }

    /**
     * 判断队列是否为空。
     */
    public boolean isEmpty(){
         return size==0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        if(first<last){
            for (int i = first; i <last; i++) {
                sb.append(elements[i].toString());
                if(i!=last-1){
                    sb.append(',');
                }
            }
        }else if(last<first){
            for (int i = first; i <maxSize; i++) {
                 sb.append(elements[i].toString());
                 if(i!=maxSize-1){
                     sb.append(',');
                 }
            }
            for (int i = 0; i <last; i++) {
                sb.append(',');
                sb.append(elements[i].toString());
            }
        }
        sb.append(']').toString();
        return  sb.toString();
    }

}
