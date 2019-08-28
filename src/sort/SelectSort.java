package sort;

/**
 * @author ly
 * @date 2019/5/31 19:53
 */
public class SelectSort {
    public static void main(String[] args) {
        int [] arr = {10,6,8,2,7,-1,0};
        selectsort(arr);
        for (int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
     /**
     * @Description: 选择排序
     * 对于给定的一组记录，经过一轮比较后得到最小的记录，然后将该纪录与第一个记录的位置进行交换，
     * 接着对不包含第一个记录以外的其他的记录进行第二轮比较，得到最小的记录并与第二个记录进行位置交换
     * 重复该过程，直到进行比较的只有一个为止
     * 双层for循环，第二层是为了记录每次遍历的最小值和最小值的位置
     * @Author: ly
     * @Date: 2019/6/2
    */
    private static void selectsort(int[] arr) {
        int len = arr.length;
        for (int i=0;i<len;i++){
            int temp = arr[i];
            int k= i;
            for (int j = i+1;j<len;j++){
                if(arr[j]<temp){
                    temp = arr[j];
                    k=j;
                }
            }
            arr[k] = arr[i];
            arr[i] = temp;
        }
    }

}
