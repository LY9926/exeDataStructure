package sort;

/**
 * @author ly
 * @date 2019/6/2 16:11
 */
public class MergeSort {
    public static void main(String[] args) {
        int [] arr = {10,6,8,2,7,-1,0};
        mergesort(arr,0,arr.length-1);
        for (int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    private static void mergesort(int[] arr, int low, int high) {
        if(low<high){
            int mid = (high+low)/2;
            mergesort(arr,low,mid);
            mergesort(arr,mid+1,high);
            merge(arr,low,mid,high);
        }
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        if(low<high){
            int nl = mid-low+1;
            int nr = high-mid;
            int left[] = new int[nl];
            int right[] = new int[nr];
            int i,j,k;
            for (i=0,k=low;i<nl;i++,k++){
                 left[i] = arr[k];
            }
            for (j=0,k=mid+1;j<nr;j++,k++){
                right[j] = arr[k];
            }
            for(i=0,j=0,k=low;i<nl&&j<nr;k++){
                if(left[i]<right[j]){
                    arr[k] =left[i];
                    i++;
                }else {
                    arr[k] = right[j];
                    j++;
                }
            }
            if(i<nl){
                for(j=i;j<nl;j++){
                    arr[k++] = left[j];
                }
            }
            if(j<nr){
                for (i=j;i<nr;i++){
                    arr[k++] = right[i];
                }
            }
        }
    }


}
