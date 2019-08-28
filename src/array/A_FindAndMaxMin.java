package array;

/**
 * @author ly
 * @date 2019/6/10 14:33
 * 找出数组中的最大值和最小值
 *
 */
public class A_FindAndMaxMin {
    public static void main(String[] args) {
        int [] arr = {10,6,8,2,7,-1,0};
        System.out.println("数组：[10,6,8,2,7,-1,0]");
        findAndMaxMin_1(arr);
        findAndMaxMin_2(arr);
        findAndMaxMin_3(arr);
        findAndMaxMin_4(arr);
        findAndMaxMin_5(arr);
    }
    //方法四：元素移位法，将数组中相邻的两个数分在一组，每次比较两个相邻数，将较大的交换至左边，较小的交换至右边。对大者
    //扫描一次得到最大值，对小者组扫描一次找出最小值
    private static void findAndMaxMin_5(int[] arr) {

    }


    //方法四：分治法，将数组划分为凉拌，分别找出两边的最大值和最小值，
    private static void findAndMaxMin_4(int[] arr) {
        int maxA= Integer.MIN_VALUE,maxB= Integer.MIN_VALUE;
        int minA= Integer.MAX_VALUE, minB= Integer.MAX_VALUE;
        for (int i=0;i<arr.length/2;i++){
            if(arr[i]<minA){
                minA = arr[i];
            }
            if(arr[i]>maxA){
                maxA = arr[i];
            }
        }
        for (int i=arr.length/2;i<arr.length;i++){
            if(arr[i]<minB){
                minB = arr[i];
            }
            if(arr[i]>maxB){
                maxB = arr[i];
            }
        }
        System.out.println("方法四：分治法求得的结果");
        if (maxA>maxB){
            System.out.println("最大值："+maxA);
        }else {
            System.out.println("最大值："+maxB);
        }
        if(minA<minB){
            System.out.println("最小值："+minA);
        }else {
            System.out.println("最小值："+minB);
        }
    }

    //方法三：取双元素法，维持两个变量min和max，每次比较相邻两个数，较大者与max比较，较小者与min比较
    private static void findAndMaxMin_3(int[] arr) {
        int max= Integer.MIN_VALUE;
        int min= Integer.MAX_VALUE;
        for (int i=0;i<arr.length-1;i++){
            if(arr[i]>arr[i+1]){
                if(arr[i]>max){
                    max = arr[i];
                }
                if(arr[i+1]<min){
                    min = arr[i+1];
                }
            }else {
                if(arr[i+1]>max){
                    max = arr[i+1];
                }
                if(arr[i]<min){
                    min = arr[i];
                }
            }
        }
        System.out.println("方法三：取双元素法求得的结果");
        System.out.println("最大值："+max);
        System.out.println("最小值："+min);
    }

    //方法二：取单元素法，维持两个变量min和max，每次取一个元素，先与找到的最小值比较，再与找到的最大值比较
    private static void findAndMaxMin_2(int[] arr) {
        int max= Integer.MIN_VALUE;
        int min= Integer.MAX_VALUE;
        for (int i=0;i<arr.length;i++){
            if(arr[i]<min){
                min = arr[i];
            }
            if(arr[i]>max){
                max = arr[i];
            }
        }
        System.out.println("方法二：取单元素法求得的结果");
        System.out.println("最大值："+max);
        System.out.println("最小值："+min);

    }

    //方法一：问题分解法把问题分成两个独立的问题，每次找出最大值，最小值即可，
    private static void findAndMaxMin_1(int[] arr) {
        int max= Integer.MIN_VALUE;
        int min= Integer.MAX_VALUE;
        for (int i=0;i<arr.length;i++){
            if(arr[i]>max){
                max = arr[i];
            }
        }
        for (int i=0;i<arr.length;i++){
            if(arr[i]<min){
                min = arr[i];
            }
        }
        System.out.println("方法一：问题问题分解法求得的结果");
        System.out.println("最大值："+max);
        System.out.println("最小值："+min);
    }
}
