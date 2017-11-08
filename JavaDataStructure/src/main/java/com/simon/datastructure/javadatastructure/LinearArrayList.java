package com.simon.datastructure.javadatastructure;

/**
 * auther: Simon zhang
 * Emaill:18292967668@163.com
 * 线性结构之顺序表的实现
 *
 */
public class LinearArrayList<E> {
    /**
     * 用于存储元素的数组
     */
    private Object[] elements;

    /**
     * 当前数组有多少个元素
     */
    private  int size;

    /**
     * 线性表容量
     */
    private int capacity;

    public LinearArrayList() {
        this(10);
    }

    /**
     * 初始化一个空线性表L
     * @param capacity
     */
    public LinearArrayList(int capacity) {
        if(capacity<0){
            throw  new IllegalArgumentException("initial capacity can't less than zero");
        }else{
            this.capacity = capacity;
            size=0;
            elements=new Object[capacity];
        }
    }

    /**
     * 根据位序K,返回相应的元素
     * @param index
     * @return
     */
   public E get(int index){
        validateIndex(index);
        return (E) this.elements[index];
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
     * 在线性表L中查找X的第一次出现的位置
     * @param e
     * @return
     */
    public int indexOf(E e){
        if(e==null){
            for (int i = 0; i <size ; i++) {
                if(elements[i]==null){
                    return i;
                }
            }
        }else{
            for (int i = 0; i <size ; i++) {
                if(e.equals(elements[i])){
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * 插入一个新元素X
     * @param e
     * @return
     */
    public void add(E e){
       ensureCapacity(size+1);
       elements[size++]=e;
    }

    /**
     * 数组扩容
     * @param size
     */
    private void ensureCapacity(int size) {
    /*    if(size>capacity){
            capacity=size;
            Object[] temps=new Object[capacity];
            for (int i = 0; i <elements.length ; i++) {
                temps[i]=elements[i];
            }
            elements=temps;
        }*/
        //优化.扩容的时候不是每次都加1,避免频繁扩容
        if(size>capacity) {
            capacity = capacity+(capacity>>1);
            Object[] temps = new Object[capacity];
            for (int i = 0; i < elements.length; i++) {
                temps[i] = elements[i];
            }
            elements = temps;
        }
      }

    /**
     * 在位序i前插入一个新元素X
     * @param e
     * @return
     */
    public void add(E e,int index){
        validateIndex(index);
        //问题：数组要不要扩容    答：肯定要扩容。 因为数组是连续存储，不为空.
        ensureCapacity(size+1);
        size++;
        Object[] temps=new Object[capacity];
        for (int i = 0; i <size; i++) {
           if(i<index){
               temps[i]=elements[i];
           }else if(i==index){
               temps[i]=e;
           }else {
               temps[i]=elements[i-1];
           }
        }
        this.elements=temps;
    }

    /**
     * 删除指定次序的元素
     * @param index
     * @return
     */
    public E remove(int index){
      E oldValue= (E) elements[index];
       Object[] temps=new Object[size-1];
      for (int i = 0; i <size; i++) {
          if(i<index){
              temps[i]=elements[i];
          }else if(i>=index){
              temps[i]=elements[i-1];
          }
      }
       size--;
       this.elements=temps;
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
        for (int i = 0; i < size; i++) {
            sb.append(elements[i].toString());
            if(i!=size-1){
                sb.append(',');
            }
        }
        sb.append(']').toString();
        return  sb.toString();
    }

}
