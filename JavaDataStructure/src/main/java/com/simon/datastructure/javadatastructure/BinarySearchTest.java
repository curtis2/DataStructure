package com.simon.datastructure.javadatastructure;

/**
 * auther: Simon zhang
 * Emaill:18292967668@163.com
 */

public class BinarySearchTest{
    public static void main(String[] args) {
//      System.out.println(11>>>1);
        int[] ints=new int[]{1,3,7,9,12,17,18,24,37,51,60};
        System.out.println(sequentialSearch(ints,12));
        System.out.println(binarySearch(ints,12));
    }


    /**
     * 给定一个有序数组，使用顺序查找找到对应的元素 K的位置
     * @param
     * @param key
     * @return
     * */
    public static int sequentialSearch(int[] args,int key){
        for (int i = 0; i<args.length ; i++) {
           if(args[i]==key)return i;
        }
        return -1;
    }


    /**
     * 给定一个有序数组，使用二分查找找到对应的元素 K的位置
     * @param
     * @param key
     * @return
     * */
    public static int binarySearch(int[] args,int key){
         int left=0;
         int right=args.length-1;
         while (left<=right){
            int mid=(left+right)>>>1;
            int midValue=args[mid];
            if(midValue>key){
                right=mid-1;
            }else if(midValue<key){
               left=mid+1;
            }else
                return mid;
            }
         return -1;
    }


}
