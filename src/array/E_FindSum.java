package array;

/**
 * @author ly
 * @date 2019/6/12 16:43
 */
public class E_FindSum {
    public static void main(String[] args) {
        int [] arr = {1,7,17,2,6,3,14};
        findSum_1(arr,20);
        findSum_2(arr,20);


    }
    //排序法 先排序再遍历
    private static void findSum_2(int[] arr, int sum) {
        int len = arr.length;
        quickSort(arr,0,len-1);
        int begin = 0;
        int end = len-1;
        System.out.println("方法二的结果");
        while (begin<end){
            if(arr[begin]+arr[end]>sum){
                end--;
            }else if(arr[begin]+arr[end]<sum){
                begin++;
            }else {
                System.out.println(arr[begin]+"+"+arr[end]+"="+sum);
                begin++;
                end--;
            }
        }
    }

    private static void quickSort(int[] arr, int low, int high) {
        if(low<high){
            int index = findInd(arr,low,high);
            quickSort(arr,low,index-1);
            quickSort(arr,index+1,high);
        }
    }

    private static int findInd(int[] arr, int low, int high) {
        int temp = arr[low];
        while (low<high){
            if(low<high&&arr[high]>temp){
                high--;
            }
            arr[low] = arr[high];
            if(low<high&&arr[low]<temp){
                low++;
            }
            arr[high] = arr[low];
            arr[low]= temp;
        }
        return low;
    }

    //方法一：暴力法
    private static void findSum_1(int[] arr,int sum) {
        int len = arr.length;
        System.out.println("方法一的结果");
        for (int i=0;i<len;i++){
            for (int j=i+1;j<len;j++){
                if(arr[i]+arr[j]==sum){
                    System.out.println(arr[i]+"+"+arr[j]+"="+sum);
                }
            }
        }
    }

}
