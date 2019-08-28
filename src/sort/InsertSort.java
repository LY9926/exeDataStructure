package sort;

/**
 * @author ly
 * @date 2019/6/2 14:03
 */
public class InsertSort {
    public static void main(String[] args) {
        int [] arr = {10,6,8,2,7,-1,0};
        insertsort(arr);
        for (int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    /**
    * @Description: 插入排序，
    * @Param:
     * 初始时假设第一个记录自称一个有序序列，其余记录为无序序列。
     * 接着从第二个记录开始，按照记录的大小依次将当前处理的记录插入到其之前的有序序列中，
     * 直至最后一个记录插入到有  序序列为终止
    * 外层为for循环，内层为while循环 当当前处理元素小于前面的有序序列时，需要对都需序列值往后挪动直到找到当前处理值的位置
    * @Author: ly
    * @Date: 2019/6/2
    */
    private static void insertsort(int[] arr) {
        int len = arr.length;
        for (int i=1;i<len;i++){
            int temp = arr[i];
            int j = i;
            if(arr[j-1]>temp){
                while (j-1>=0&&arr[j-1]>temp){
                    arr[j] = arr[j-1];
                    j = j-1;
                }
            }
            arr[j] = temp;
        }
    }
}
