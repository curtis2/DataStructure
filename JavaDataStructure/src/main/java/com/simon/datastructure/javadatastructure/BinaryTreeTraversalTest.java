package com.simon.datastructure.javadatastructure;

import java.util.HashMap;
import java.util.Stack;

/**
 * auther: Simon zhang
 * Emaill:18292967668@163.com
 */

public class BinaryTreeTraversalTest {
    public static void main(String[] args) {
//      System.out.println(11>>>1);
        Node<String> A=new Node("A");
        Node<String> B=new Node("B");
        Node<String> C=new Node("C");
        Node<String> D=new Node("D");
        Node<String> E=new Node("E");
        Node<String> F=new Node("F");
        Node<String> G=new Node("G");
        Node<String> H=new Node("H");
        Node<String> I=new Node("I");

        A.setLeft(B);
        A.setRight(C);
        B.setLeft(D);
        B.setRight(F);
        C.setLeft(G);
        C.setRight(I);
        G.setRight(H);
        F.setLeft(E);
//        preOlderTraversal(A);
//        inOlderTraversal(A);
//        postOlderTraversal(A);
//        inOlderTraversalNotRecursion(A);
//        preOlderTraversalNotRecursion(A);
//        postOlderTraversalNotRecursion(A);
         levelOlderTraversal(A);
        System.out.println(builder.toString());
    }

    static StringBuilder builder=new StringBuilder();

    /**
     * 1.访问根结点
     * 2.先序遍历其左子树
     * 3.先序遍历其右子树
     *  先序遍历 递归实现  顺序为：A,B,D,F,E,C,G,H,I
     * @param tree
     */
    public static void preOlderTraversal(Node tree){
          if(tree!=null){
//            System.out.println(tree.item);
              builder.append(tree.item+",");
              preOlderTraversal(tree.left);
              preOlderTraversal(tree.right);
          }
    }

    /**
     * 1. 中序遍历其左子树
     * 2. 访问根结点
     * 3. 中序遍历其右子树
     * 中序遍历 递归实现  顺序为：D,B,E,F,A,G,H,C,I
     * @param tree
     */
    public static void inOlderTraversal(Node tree){
        if(tree!=null){
//          System.out.println(tree.item);
            inOlderTraversal(tree.left);
            builder.append(tree.item+",");
            inOlderTraversal(tree.right);
        }
    }

    /**
     * 后序遍历 递归实现  顺序为：D,E,F,B,H,G,I,C,A
     * @param tree
     */
    public static void postOlderTraversal(Node tree){
        if(tree!=null){
//          System.out.println(tree.item);
            postOlderTraversal(tree.left);
            postOlderTraversal(tree.right);
            builder.append(tree.item+",");
        }
    }

    /**
     * 中序遍历  非递归实现
     * @param tree
    //算法
    //遇到一个结点就把它压入栈中，并去遍历它的左子树
    //当左子树遍历结束后，从栈顶弹出这个结点并访问它
    //然后按其右指针再去中序遍历该结点的右子树
     */
    public static void inOlderTraversalNotRecursion(Node tree){
       LinkedStack<Node> stack=new LinkedStack(30);
        while (tree!=null||!stack.isEmpty()){
            while (tree!=null){
                stack.push(tree);
                tree=tree.left;
            }
            if(!stack.isEmpty()){
                tree= stack.pop();
                builder.append(tree.item+",");
                tree=tree.right;
            }
        }
    }

    /**
     * 先序遍历  非递归实现
     *  1.
     *  2.
     *  3.
     * @param tree
     */
    public static void preOlderTraversalNotRecursion(Node tree){
        LinkedStack<Node> stack=new LinkedStack(30);
        while (tree!=null||!stack.isEmpty()){
            while (tree!=null){
                builder.append(tree.item+",");
                stack.push(tree);
                tree=tree.left;
            }
            if(!stack.isEmpty()){
                tree= stack.pop();
                tree=tree.right;
            }
        }
    }

    /**
     * 后序遍历  非递归实现
     *  1.左子树
     *  2.右子树
     *  3.根结点
     * @param tree
     */
    public static void postOlderTraversalNotRecursion(Node tree){
        //算法，先要遍历树的左子树，然后再遍历树的右子树,所以应该确保左子树和右子树遍历完成后再访问根结点
        HashMap<Node,Boolean> map=new HashMap<>();
        Stack<Node> stack=new Stack<>();
        stack.push(tree);
        while (!stack.isEmpty()){
          Node temp=stack.peek();
          //左子树
          if(temp.left!=null&&!map.containsKey(temp.left)){
              temp=temp.left;
              while (temp!=null){
                  if(map.containsKey(temp))break;
                   stack.push(temp);
                   temp=temp.left;
              }
              continue;
          }
          //右子树
          if(temp.right!=null&&!map.containsKey(temp.right)){
              stack.push(temp.right);
              continue;
          }
          Node t=stack.pop();
          map.put(t,true);
          System.out.println(t.item);
        }
    }

    /**
     * 层序遍历  非递归实现
     * 从上到大 从左到右
     * @param tree
     */
    public static void levelOlderTraversal(Node tree){
        //算法：先将根结点压入栈中，然后循环遍历队列，弹出第一个元素，然后把左结点和右结点压队列中
        LinkedQueue<Node> queue=new LinkedQueue<>(30);
        queue.push(tree);
        while (!queue.isEmpty()){
            Node pop = queue.pop();
            System.out.println(pop.item);
            if(pop.left!=null) queue.push(pop.left);
            if(pop.right!=null) queue.push(pop.right);
        }
    }


    static class Node<E>{
      E item;
      Node left;
      Node right;
        public Node(E item) {
            this.item = item;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }
}
