package array;

/**
 * @author ly
 * @date 2019/6/10 15:27
 */
public class B_FindSecondMax {
    public static void main(String[] args) {
        int [] arr = {10,6,8,2,7,-1,0};
        System.out.println("数组：[10,6,8,2,7,-1,0]");
        findSecondMax_1(arr,0,arr.length-1);
        System.out.println("方法一计算得到的第二大数："+arr[arr.length-2]);
        findSecondMax_2(arr);

    }
    //方法二：定义一个存储最大值的元素，初始值为数组的首元素，
    // 另一个变量用来存储数组中的第二大数，初始值为最小负整数，
    //然后遍历数组，如果数组元素大于最大值，则把最大数值赋给第二大值，最大值更新为该元素的值，若数组元素值小于最大值，则判断是否比第二大数的值大
    //若大则吧第二大值更新为该值
    private static void findSecondMax_2(int[] arr) {
        int max = arr[0];
        int secondMax = Integer.MIN_VALUE;
        for (int i=1;i<arr.length;i++){
            if(arr[i]>max){
                 secondMax= max;
                 max = arr[i];
            }else if(arr[i]>secondMax){
                secondMax = arr[i];
            }
        }
        System.out.println("方法二计算得到的第二大数："+secondMax);
    }

    //方法一：先快速排序，然后取第二个大元素
    private static void findSecondMax_1(int[] arr,int low,int high) {
        if(low<high){
            int index = findIndex(arr,low,high);
            findSecondMax_1(arr,low,index-1);
            findSecondMax_1(arr,index+1,high);
        }
    }

    private static int findIndex(int[] arr, int low, int high) {
        if(low<high){
            int temp = arr[low];
            while (low<high&&arr[high]>temp){
                high--;
            }
            arr[low] = arr[high];
            while (low<high&&arr[low]<temp){
                low++;
            }
            arr[high] = arr[low];
            arr[low] = temp;
        }
        return low;
    }

}
