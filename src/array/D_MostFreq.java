package array;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author ly
 * @date 2019/6/12 16:10
 */
public class D_MostFreq {
    public static void main(String[] args) {
        int [] arr = {1,1,2,2,4,4,4,4,5,5,6,6,7};
        findMostFrequenceInArray_1(arr);
        findMostFrequenceInArray_2(arr);
    }

    private static void findMostFrequenceInArray_2(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i])+1);
            }else {
                map.put(arr[i],1);
            }
        }
        int most = 0;
        int result= 0;
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry entry = (Map.Entry)iterator.next();
            int key = (Integer) entry.getKey();
            int value = (Integer)entry.getValue();
            if(value>most){
                result = key;
                most = value;
            }
        }
        System.out.println("方法2： " +result);
    }

    private static void findMostFrequenceInArray_1(int[] arr) {
        int len = arr.length;
        int Max = arr[0];
        for(int i=1;i<len;i++){
            if(arr[i]>Max){
                Max = arr[i];
            }
        }
        int count[] = new int[Max+1];
        for (int i=0;i<len;i++){
            int k=arr[i];
            count[k] = count[k]+1;
        }
        int most = 0;
        int num = count[0];
        for(int i=1;i<Max+1;i++){
            if(count[i]>most){
                most = count[i];
                num = i;
            }
        }
        System.out.println("方法1： " +num);
    }
}
