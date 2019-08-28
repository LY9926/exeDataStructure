package test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ly
 * @date 2019/6/17 12:50
 */
public class DupNUm {
    public static void main(String[] args) {
        int array[] ={2,1,3,0,4};
        int result[] = new int[1];
       boolean flag =  duplicate(array,array.length,result);
        System.out.println(flag);
    }
    public  static boolean duplicate(int numbers[],int length,int [] duplication) {
        if(length<2){
            return false;
        }
        Map<Integer,Integer> map = new HashMap<>();
        int i;
        for(i=0;i<length;i++){
            if(map.containsKey(numbers[i])){
                duplication[0] = numbers[i];
                break;
            }else{
                map.put(numbers[i],1);
            }
        }
        if(duplication[0]!=0){
            return true;
        }else return false;

    }
}
