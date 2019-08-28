package array;

/**
 * @author ly
 * @date 2019/6/16 20:36
 */
public class I_FindDup {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,4};
        findDup_1(arr);
        findDup_2(arr);
        findDup_3(arr);
    }

    //要求：空间换时间
    private static void findDup_3(int[] arr) {
        int len = arr.length;
        boolean arrFlag[] = new boolean[len];
        int i=1;
        while (i<len){
            arrFlag[i] = false;
            i++;
        }
        int result = 0;
        for (int j=0;j<len;j++){
            if(arrFlag[arr[j]]==false){
                arrFlag[j] = true;
            }else {
                result = arr[j];
            }
        }
        System.out.println("方法三 额外空间标记法+-："+result);
    }

    //要求：不用辅助存储空间——异或法
    private static void findDup_2(int[] arr) {
        int len = arr.length;
        int result = 0;
        for (int i=0;i<len;i++){
            result =result^arr[i];
        }
        for (int i=1;i<len;i++){
            result =result^i;
        }
        System.out.println("方法二 异或法的结果："+result);
    }

    //要求：每个元素只能访问一次，不用辅助存储空间——求和法
    private static void findDup_1(int[] arr) {
        int len = arr.length;
        int result1 = 0,result2 = 0;
        for (int i=0;i<len-1;i++){
            result1 +=(i+1);
            result2 +=arr[i];
        }
        result2+=arr[len-1];
        System.out.println("方法一 求和法的结果："+(result2-result1));
    }
    //
}
