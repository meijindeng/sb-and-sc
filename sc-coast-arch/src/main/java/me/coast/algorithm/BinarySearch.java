package me.coast.algorithm;

/**
 * @author meiji 二分查找：适合有序的
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9};
        int target = 2;
        int index = -1;
        int begin = 0;
        int end = arr.length-1;
        int mid = (begin+end)/2;
        while (true){
            //判断中间元素是否是查找的元素
            if(arr[mid]==target){
                index = mid;
                break;
            }else {
                //判断中间元素是不是比目标元素大
                if(arr[mid]>target){
                    end = mid - 1;//将最后一个位置调整到中间位置前一个
                }else {
                    //判断中间元素是不是比目标元素小
                    begin = mid + 1;//将第一个位置调整到中间位置后一个
                }
                //取出新的中间位置
                mid = (begin+end)/2;
            }
        }
        System.out.println("index="+index);
    }
}
