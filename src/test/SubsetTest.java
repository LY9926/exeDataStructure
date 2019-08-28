package test;

/**
 * @author ly
 * @date 2019/6/16 12:01
 */
public class SubsetTest {
    public static void main(String[] args) {
        int []arr= {3,34,4,12,5,2};
        getSum(arr,9);
    }

    private static void getSum(int[] arr, int sum) {
        int len = arr.length;
        boolean subset[][] = new boolean[len][sum+1];
        for (int i=0;i<sum+1;i++){  //第一行除了等于arr[0]的 其余的都等于false
            if(arr[0]==i){
                subset[0][i] = true;
            }else {
                subset[0][i] = false;
            }
        }
        for (int i=0;i<len;i++){
            subset[i][0] = false;
        }
        for (int i=1;i<len;i++){
            for (int j=1;j<sum+1;j++){
                if(arr[i]>j){           
                    subset[i][j] = subset[i-1][j];
                }else {
                    boolean A = subset[i-1][j-arr[i]];
                    boolean B = subset[i-1][j];
                    subset[i][j] = A||B;
                }

            }
        }
        System.out.println(subset[len-1][sum-1]);
    }
}
