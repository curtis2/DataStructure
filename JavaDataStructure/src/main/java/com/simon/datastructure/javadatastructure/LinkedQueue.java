package com.simon.datastructure.javadatastructure;

/**
 * auther: Simon zhang
 * Emaill:18292967668@163.com
 * 链表实现 队列
 */
public class LinkedQueue<E> {
    /**
     * 用于表示队列头部的元素
     */
    Node header;
    /**
     * 用于表示队列尾部的元素
     */
    Node last;
    /**
     * 用于表示队列的容量
     */
    int maxSize;
    /**
     * 当前队列数量
     */
    int size;

    /**
     * 生成长度为MaxSize的空队列;
     * @param maxSize
     */
    public LinkedQueue(int maxSize) {
        if(maxSize<0){
            throw  new IllegalArgumentException("stack size must more than zero..");
        }
        this.maxSize=maxSize;
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
            Node insertNode=new Node(e);
            if(header==null){
                header=insertNode;
                last=insertNode;
            }else{
                last.addNext(insertNode);
                last=insertNode;
            }
            size++;
        }
    }

    /**
     * 将队头数据元素从队列中删除并返回。
     */
    public E pop(){
        if(isEmpty()){
            System.out.println("Queue is empty now..");
            return null;
        }else{
            E popE=(E)header.item;
            header=header.next;
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
        Node temp=header;
        while (temp.next!=null){
            sb.append(temp.item.toString());
            sb.append(',');
            temp=temp.next;
        }
        sb.append(temp.item.toString());
        sb.append(']').toString();
        return  sb.toString();
    }


    class Node<E>{
        E item;
        Node next;
        public Node(E item) {
            this.item = item;
        }

        public void addNext(Node next) {
            this.next = next;
        }
    }




}
