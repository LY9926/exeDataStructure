package array;

/**
 * @author ly
 * @date 2019/6/12 20:53
 * 如何把一个数组循环右移K位
 */
public class F_ShiftK {
    public static void main(String[] args) {
        int [] arr = {1,7,17,2,6,3,14};
        shift_K(arr,3);
    }

    private static void shift_K(int[] arr, int k) {
        int n= arr.length;
        k = k%n;
        reverse(arr,0,n-k-1);
        reverse(arr,n-k,n-1);
        reverse(arr,0,n-1);
        for (int i=0;i<n;i++){
            System.out.println(arr[i]);
        }
    }

    private static void reverse(int[] arr, int low, int high) {
        for (;low<high;low++,high--){
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
        }
    }
}
