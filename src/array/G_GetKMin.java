package array;

import java.util.Arrays;

/**
 * @author ly
 * @date 2019/6/12 21:06
 */
public class G_GetKMin {
    public static void main(String[] args) {
        int [] arr = {10,6,8,2,7,-1,0};
        findKMin_1(arr,3);
        findKMin_2(arr,3);

    }

    private static void findKMin_2(int[] arr, int k) {
        if(k<arr.length&&k>0){
            quickSort_2(arr,0,arr.length-1,k);
            System.out.println("方法一：第"+k+"个数为"+arr[k-1]);
        }
    }



    private static void findKMin_1(int[] arr,int k) {
        if(k<arr.length&&k>0){
            quickSort(arr,0,arr.length-1);
            System.out.println("方法一：第"+k+"个数为"+arr[k-1]);
        }

    }

    private static void quickSort_2(int[] arr, int low, int high,int k) {
        if(low<high){
            int index = finInd(arr,low,high);
            if(index==k){
                System.out.println("方法二：第"+k+"个数为"+arr[k-1]);
            }else if(index<k){
                quickSort(arr,index+1,high);
            }else {
                quickSort(arr,low,index-1);
            }
        }
    }
    private static void quickSort(int[] arr, int low, int high) {
        if(low<high){
            int index = finInd(arr,low,high);
            quickSort(arr,low,index-1);
            quickSort(arr,index+1,high);
        }
    }

    private static int finInd(int[] arr, int low, int high) {
        int temp=arr[low];
        while(low<high){
            while (low<high&&temp<arr[high])
                high--;
            arr[low]=arr[high];
            while (low<high&&temp>arr[low])
                low++;
            arr[high]=arr[low];
        }
        arr[low]=temp;
        return low;
    }
}
