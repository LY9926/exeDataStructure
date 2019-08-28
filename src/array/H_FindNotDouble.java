package array;

/**
 * @author ly
 * @date 2019/6/13 20:45
 */
public class H_FindNotDouble {
    public static void main(String[] args) {
        int [] arr = {1,2,3,2,4,3,5,4,1};
        findNotDouble(arr);
    }

    private static void findNotDouble(int[] arr) {
        int len = arr.length;
        int temp = 0;
        for (int i=0;i<len;i++){
            temp  = temp^arr[i];
        }
        System.out.println("只出现一次的数字"+temp);
    }


}
