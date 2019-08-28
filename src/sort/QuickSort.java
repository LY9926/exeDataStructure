package sort;

/**
 * @author ly
 * @date 2019/6/2 16:58
 */
public class QuickSort {
    public static void main(String[] args) {
        int [] arr = {1,7,17,2,6,3,14};
        quicksort(arr,0,arr.length-1);
        for (int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    private static void quicksort(int[] arr, int low, int high) {
        if(low<high){
            int index = getIndex(arr,low,high);
            quicksort(arr,low,index-1);
            quicksort(arr,index+1,high);
        }
    }

    private static int getIndex(int[] arr, int low, int high) {

            int temp = arr[low];
            while (low<high){
                while (low<high&&arr[high]>=temp)
                    high--;
                arr[low] = arr[high];
                while (low<high&&arr[low]<temp)
                    low++;
                arr[high] = arr[low];

            }
        arr[low]= temp;
        return low;
    }


}
