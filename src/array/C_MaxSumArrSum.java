package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ly
 * @date 2019/6/10 15:56
 * 求最大子数组之和
 */
public class C_MaxSumArrSum {
    public static void main(String[] args) {
        int [] arr = {1,-2,4,8,-4,7,-1,-5};
        System.out.println("数组：[1,-2,4,8,-4,7,-1,-5]");
        maxSubArray_1(arr);
        maxSubArray_2(arr);
        maxSubArray_3(arr);
        maxSubArray_4(arr);
    }

    //方法四：动态规划的优化 降低空间复杂度
    private static void maxSubArray_4(int[] arr) {
        int len = arr.length;
        int nend = arr[0];
        int nall = arr[0];
        for (int i=1;i<len;i++){
            nend = (nend+arr[i])>arr[i]?nend+arr[i]:arr[i];
            nall = nend>nall?nend:nall;
        }
        System.out.println("方法四最大子数组之和："+nall);
    }



    //方法三 动态规划 找出不同的方案
    private static void maxSubArray_3(int[] arr) {
        int len = arr.length;
        int all[] = new int[len];
        int end[] = new int[len];
        end[0] = arr[0];
        all[0] = arr[0];
        for (int i=1;i<len;i++){
            //分为三种情况 1.一当前值结尾，2，只选当前值，3，不选当前值
            int A=end[i-1]+arr[i];
            int B = arr[i];
            int C = all[i-1];
            end[i] = A>B?A:B;
            all[i] = end[i]>C?end[i]:C;
        }
        System.out.println("方法三最大子数组之和："+all[len-1]);


    }

    //方法二：重复利用已经计算的子数组之和 Sum[i,j] = Sum[i,j-1]+arr[j]
    private static void maxSubArray_2(int[] arr) {
        int len = arr.length;
        int maxSum =Integer.MIN_VALUE;
        for (int i=0;i<len;i++){
            int thisSum = 0;
            for (int j=i;j<len;j++){
                thisSum = thisSum + arr[j];
                if(thisSum>maxSum){
                    maxSum = thisSum;
                }
            }
        }
        System.out.println("方法二最大子数组之和："+maxSum);
    }


    //方法一：暴力法 找出所有自数组，然后求出自数组之和
    private static void maxSubArray_1(int[] arr) {
        int len = arr.length;
        int maxSum =0;
        for(int i=0;i<len;i++){
            for (int j=1;j<len;j++){
                int thisSum = 0;
                for (int k=i;k<j;k++){
                    thisSum = thisSum+arr[k];
                }
                if(thisSum>maxSum){
                    maxSum = thisSum;
                }
            }
        }
        System.out.println("方法一最大子数组之和："+maxSum);

    }
}
