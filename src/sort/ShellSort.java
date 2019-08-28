package sort;

/**
 * @author ly
 * @date 2019/6/2 17:22
 */
public class ShellSort {
    public static void main(String[] args) {
        int [] arr = {10,6,8,2,7,-1,0};
        shellsort(arr);
        for (int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    private static void shellsort(int[] arr) {
        int len = arr.length;
        for (int d= len/2;d>0;d= d/2){
            for(int i=d;i<len;i++){
                int temp = arr[i];
                int j = i;
                if(temp<arr[j-d]){
                    while (j-d>=0&&temp<arr[j-d]){
                        arr[j] = arr[j-d];
                        j = j-d;
                    }
                }
                arr[j] = temp;
            }
        }
    }


}
