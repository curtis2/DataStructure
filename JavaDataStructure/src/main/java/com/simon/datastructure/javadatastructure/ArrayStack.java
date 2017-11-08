package com.simon.datastructure.javadatastructure;

/**
 * auther: Simon zhang
 * Emaill:18292967668@163.com
 *
 * 基于数组的Stack的实现
 */
public class ArrayStack<E>{
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
     * 生成空堆栈，其最大长度为MaxSize
     * @param maxSize
     */
    public ArrayStack(int maxSize) {
        if(maxSize<0){
            throw  new IllegalArgumentException("stack size must more than zero..");
        }
        this.maxSize = maxSize;
        this.top=-1;
        this.elements=new Object[maxSize];
    }

    /**
     * 判断堆栈是否已满
     */
    public boolean isFull() {
        return top==(maxSize-1);
    }

    /**
     * 将元素压入堆栈
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
     *  删除并返回栈顶元素
     */
    @SuppressWarnings("unchecked")
    public E pop(){
        if(isEmpty()){
            System.out.println("stack is empty now..");
            return null;
        }else{
            //这个unchecked cast异常怎么解决？
            E popE=(E) elements[top];
            elements[top]=null;
            top--;
            return popE;
        }
    }

    /**
     * 将元素压入堆栈
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
