package com.simon.datastructure.javadatastructure;

/**
 * auther: Simon zhang
 * Emaill:18292967668@163.com
 *
 *  栈结构的链式存储方式实现
 */
public class LinkedStack<E>{
    /**
     * 头节点
     */
    Node<E> header;

    /**
     * 栈的容量
     */
    int maxSize;
    
    /**
     * 当前节点数量
     */
    private  int size;

    public LinkedStack(int maxSize) {
        this.maxSize = maxSize;
    }

    /**
     * 判断堆栈是否已满
     */
    public boolean isFull() {
        return size==maxSize;
    }

    /**
     * 将元素压入堆栈
     * @param e
     */
    public void push(E e){
        if(isFull()){
            System.out.println("stack is full now..");
        }else{
            Node<E> insertNode = new Node(e);
            insertNode.addFirst(header);
            header=insertNode;
            size++;
        }
    }

    /**
     *  删除并返回栈顶元素
     */
    @SuppressWarnings("unchecked")
    public E pop(){
        if(isEmpty()){
            System.out.println("stack is empty now..");
            return null;
        }else{
            E item= header.item;
            header=header.first;
            size--;
            return item;
        }
    }

    /**
     * 将元素压入堆栈
     */
    public boolean isEmpty(){
        return size==0;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        Node temp=header;
        while (temp.first!=null){
            sb.append(temp.item.toString());
            sb.append(',');
            temp=temp.first;
        }
        sb.append(temp.item.toString());
        sb.append(']').toString();
        return  sb.toString();
    }


    class Node<E>{
        E item;
        Node first;
        public Node(E item) {
            this.item = item;
        }

        public void addFirst(Node next) {
            this.first = next;
        }
    }

}
