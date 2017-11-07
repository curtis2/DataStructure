package com.simon.datastructure.javadatastructure;

/**
 * auther: Simon zhang
 * Emaill:18292967668@163.com
 *
 *线性表的链表代码实现
 */
public class LinearLinkedList<E>{
    /**
     * 头节点
     */
    private Node<E> header;

    /**
     * 当前节点数量
     */
    private  int size;

    /**
     * 初始化一个空线性表链表L
     * @param
     */
    public LinearLinkedList() {
        header=new Node<>();
    }

    /**
     * 根据位序K,返回相应的元素
     * @param index
     * @return
     */
    public E get(int index){
        validateIndex(index);
        Node<E> temp=header;
        int count=0;
        while (index!=count){
           temp.item=temp.next.item;
           count++;
        }
        return temp.item;
    }

    /**
     * 根据位序K,返回对应位置的节点
     * @param index
     * @return
     */
    public Node getNode(int index){
        validateIndex(index);
        Node<E> temp=header;
        int count=0;
        while (index!=count){
            temp=temp.next;
            count++;
        }
        return temp;
    }


    /**
     * 在线性表链表L中查找X的第一次出现的位置
     * @param e
     * @return
     */
    public int indexOf(E e){
        Node<E> temp=header;
        int count=0;
        while (!e.equals(temp.item)){
            temp.item=temp.next.item;
            count++;
        }
        return count;
    }

    /**
     * 在插入一个新元素X
     * @param e
     * @return
     */
    public void add(E e){
        //将插入元素包装成一个节点对象
        Node<E> insertNode=new Node<>(e);
        if(size==0){
            header=insertNode;
        }else{
           Node lastNode=getNode(size-1);
           lastNode.addNextNode(insertNode);;
        }
        size++;
    }

    /**
     * 在位序i前插入一个新元素X
     * @param e
     * @return
     */
    public void add(E e,int index){
        //将插入元素包装成一个节点对象
        Node<E> insertNode=new Node<>(e);

        Node<E> temp=header;
       //迭代列表，找到index对应的上一个node, 然后把他的节点next 节点置为e, e的下一个节点置为index对应的节点
        int count=0;
        while ((index-1)!=count){
            temp=temp.next;
            count++;
        }
        insertNode.addNextNode(temp.next);
        temp.addNextNode(insertNode);
    }


 /**
     * 删除指定次序的元素
     * @param index
     * @return
     */
    public E remove(int index){
        Node<E> temp=header;
        //迭代列表，找到index对应的上一个node, 然后把他的next节点置为index对应的节点的next。
        int count=0;
        while ((index-1)!=count){
            temp=temp.next;
            count++;
        }
        E oldValue= temp.next.item;
        temp.addNextNode(temp.next.next);
        size--;
        return oldValue;
    }

    /**
     * 验证下标是否合法
     * @param index
     */
    private void validateIndex(int index) {
        if(index<0||index>size){
            throw new IllegalArgumentException("index out Of Bound Index:"+index+"Size:"+size);
        }
    }

    /**
     *
     * 返回线性表L的长度n。
     * @return
     */
    public int size(){
        return this.size;
    }

    /**
     * 链表节点对象
     * @param <E>
     */
    class Node<E>{
    /**
     * 当前数据对象
     */
     E item;
    /**
     * 下一个节点
     */
     Node<E> next;

     public Node() {
     }
     public Node(E item) {
            this.item = item;
     }
     void addNextNode(Node<E> node){
         this.next=node;
     }
    }


}
