package sort;

/**
 * @author ly
 * @date 2019/6/2 15:42
 */
public class BubbleSort {

    public static void main(String[] args) {
        int [] arr = {10,6,8,2,7,-1,0};
        bubblesort(arr);
        for (int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
    /**
    * @Description: 冒泡排序
    * 根据大的数往上冒的原则，在一趟排序中总是比较当前元素和后面元素的大小，使得大数在前，小数在后。
     * 每次能够保证最大的数到了最后面，
    * 双层for循环，第二层遍历的次数逐渐减小 内层循环，当后面的元素大于前面的元素时，进行数据交换
    * @Author: ly
    * @Date: 2019/6/2
    */
    private static void bubblesort(int[] arr) {
        int len = arr.length;
        for(int i=0;i<len-1;i++){
            for(int j=0;j<len-1-i;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
