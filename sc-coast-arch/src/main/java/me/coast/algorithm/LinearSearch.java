package me.coast.algorithm;

/**
 * @author meiji 线性查找
 */
public class LinearSearch {
    public static void main(String[] args) {
        //目标数组
        int[] arr = new int[]{1,2,3,4,5,6};
        int target = 6;
        int index = -1;
        //遍历数组
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==target){
                index = i;
                break;
            }
        }
        System.out.println("index="+index);
    }
}
