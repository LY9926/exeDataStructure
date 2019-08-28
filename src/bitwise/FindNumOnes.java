package bitwise;

/**
 * @author ly
 * @date 2019/6/7 17:39
 * 一个整形数组里除了两个数字之外，其他的数字都出现了两次，找出这两个只出现了一次的数字，时间复杂度为O（n），空间复杂度为O（l）
 * 例如：输入：{2，4，3，，6，3，2，5，5}
 * 思路：找出一个数组中的只出现了一次的数字可采用异或的方法；
 * 找出两个数，先从全部异或结果（两个只出现一次的疑惑结果)中，找出第一个为1的位置，根据这个位置，将数组分为两个）
 */
public class FindNumOnes {

    public static void main(String[] args) {
        int arr[] = {2,4,3,6,3,2,5,5};
        int arrA[] = new int[arr.length];
        int arrB[] = new int[arr.length];
        findNumOnes(arr,arrA,arrB);


    }

  public static void findNumOnes(int data[],int num1[] , int num2[]){
      int len = data.length;
        int temp = 0;
        for(int i=0;i<len;i++){
            temp = temp^ data[i];
        }
      int count = 0;
      //得到异或结果的第n位为1，如001 0;
      while (temp>0){
          if((temp&1)==1){
              break;
          }
          count++;
          temp =  temp>>1;
      }

      int j=0,k=0;
      for(int i=0;i<len;i++){
         if(isBit1(data[i],count)){
             num1[j++] = data[i];
         }else {
             num2[k++] = data[i];
         }
      }
      temp = 0;
      for(int i=0;i<=j;i++){
          temp = temp^ num1[i];
      }
      System.out.println(temp);
      temp = 0;
      for(int i=0;i<=k;i++){
          temp = temp^ num1[i];
      }
      System.out.println(temp);
    }

    private static boolean isBit1(int datum, int count) {
      datum = datum>>count;
      return (datum & 1)==1;
    }
}
