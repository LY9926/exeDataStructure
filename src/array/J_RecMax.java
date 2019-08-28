package array;

import static java.lang.StrictMath.max;

/**
 * @author ly
 * @date 2019/6/17 14:45
 * 递归地求出元素的最大值
 */
public class J_RecMax {

    public static void main(String[] args) {
        int arr[] ={0,16,2,3,4,5,10,7,8,9};

        System.out.println(recMax(arr,0));

    }

    private static int recMax(int[] arr, int begin) {
        int length = arr.length-begin;
        if(length==1){
            return arr[begin];
        }else {
            return maxNum(arr[begin],recMax(arr,begin+1));
        }
    }

    private static int maxNum(int a, int b) {
        return a>b?a:b;
    }
}
