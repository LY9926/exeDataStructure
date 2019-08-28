package array;

/**
 * @author ly
 * @date 2019/6/17 15:25
 * 求取数对只差的最大值（动态规划）
 */
public class K_dfMax {
    public static void main(String[] args) {
       int arr[] = {1,4,17,3,2,9};
       df_max(arr);
    }

    private static void df_max(int[] arr) {
        int len = arr.length;
        int indMax[] = new int[len];

        //求出前第i个的最大值
        indMax[0] = arr[0];
        for (int i=1;i<len;i++){
            if(arr[i]>indMax[i-1]){
                indMax[i] = arr[i];
            }else
                indMax[i] = indMax[i-1];
        }
    }
}
