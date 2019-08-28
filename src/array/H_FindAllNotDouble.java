package array;

/**
 * @author ly
 * @date 2019/6/13 20:45
 */
public class H_FindAllNotDouble {
    public static void main(String[] args) {
        int [] arr = {1,2,3,1,2,3,1,2,3,5};
        findAllNotDouble(arr,3);
    }

    private static void findAllNotDouble(int[] arr, int appearTimes) {
        int len = arr.length;
        int bitCount[] =new int[32];
        for (int i=0;i<len;i++){
            for (int j=0;j<32;j++){
                bitCount[j] += ((arr[i]>>j)&1);
            }
        }
        int appearOne = 0;
        for (int i=0;i<32;i++){
            if(bitCount[i]%appearTimes!=0){
                appearOne  +=1<<i;
            }
        }
        System.out.println(appearOne);
    }


}
