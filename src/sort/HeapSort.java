package sort;

/**
 * @author ly
 * @date 2019/6/2 21:27
 */
public class HeapSort {
    public static void main(String[] args) {
        int [] arr = {10,6,8,2,7,-1,0};
        heapsort(arr);
        for (int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    private static void heapsort(int[] arr) {
        for(int i=arr.length/2-1;i>=0;i--){
            adjestHeap(arr,i,arr.length-1);
        }
        for(int j= arr.length-1;j>0;j--){
            int temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjestHeap(arr,0,j);
        }
    }
    //调整大顶堆（仅是调整过程，建立在大顶堆已构建的基础上）
    //从上往下调整
    private static void adjestHeap(int[] arr, int i, int length) {
        int temp = arr[i];
       for(int k = 2*i+1;k<length;k=2*k+1){//从i节点的左子节点开始开始
            if(k+1<length&&arr[k]<arr[k+1]){//如果左子节点小于右子节点，则将k指向右子节点
                k++;
            }
            if(arr[k]>temp){//如果子节点大于父节点 则将子节点复制给父节点，(不用交换)
                arr[i]= arr[k];
                i = k;
            }else break;
       }
       arr[i] = temp;
    }
}
