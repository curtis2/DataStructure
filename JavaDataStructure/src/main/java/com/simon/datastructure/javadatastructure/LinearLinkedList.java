package com.simon.datastructure.javadatastructure;

/**
 * auther: Simon zhang
 * Emaill:18292967668@163.com
 *
 *  线性表的链表代码实现
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
    }

    /**
     * 根据位序K,返回相应的元素
     * @param index
     * @return
     */
    public E get(int index){
        if(index<0||index>size-1){
            throw new IllegalArgumentException("Index out Of Bound Index:"+index+"Size:"+size);
        }
        Node<E> temp=header;
        int count=0;
        while (index!=count){
           temp=temp.next;
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
        if(index<0||index>size-1){
            throw new IllegalArgumentException("Index out Of Bound Index:"+index+"Size:"+size);
        }
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
        if(e==null){
             while (count!=size){
               if(temp.item==null){
                   return count;
               }
                temp=temp.next;
                count++;
            }
        }else{
            while (count!=size){
                if(temp.item.equals(e)){
                    return count;
                }
                temp=temp.next;
                count++;
            }
        }
        return -1;
    }

    /**
     * 在插入一个新元素X
     * @param e
     * @return
     */
    public void add(E e){
        Node<E> insertNode=new Node<>(e);
        if(size==0){
            header=insertNode;
        }else{
           Node lastNode=getNode(size-1);
           lastNode.addNextNode(insertNode);
        }
        size++;
    }

    /**
     * 在位序i前插入一个新元素X
     * @param e
     * @return
     */
    public void add(E e,int index){
        if(index<0||index>size){
            throw new IllegalArgumentException("Index out Of Bound Index:"+index+"Size:"+size);
        }
        Node<E> insertNode=new Node<>(e);
        if(size==0){
            header=insertNode;
        }else {
            //找到index对应的node, 然后把他的next节点置为e, e的next节点置为index node的next
            Node<E> temp = getNode(index-1);
            insertNode.addNextNode(temp.next);
            temp.addNextNode(insertNode);
        }
        size++;
    }


    /**
     * 删除指定次序的元素
     * @param index
     * @return
     */
    public E remove(int index){
        E oldValue;
        if(index<0||index>size-1){
            throw new IllegalArgumentException("index out Of Bound Index:"+index+"Size:"+size);
        }
        //移除头节点
        if(index==0){
            header=header.next;
            oldValue=header.item;
        }else{
            //找到index对应的node, 然后把他的next节点置为index对应的节点的next。
            Node<E> temp=getNode(index-1);
            oldValue= temp.next.item;
            temp.addNextNode(temp.next.next);
            //清空引用
            temp.next.next=null;
        }
        size--;
        return oldValue;
    }

    /**
     *
     * 返回线性表L的长度n。
     * @return
     */
    public int size(){
        return this.size;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        Node<E> temp=header;
        while (temp.next!=null){
            sb.append(temp.item.toString());
            sb.append(',');
            temp=temp.next;
        }
        sb.append(temp.item.toString());
        sb.append(']').toString();
        return  sb.toString();
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
