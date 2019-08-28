package dynprogram;

/**
 * @author ly
 * @date 2019/6/12 8:46
 */
public class Daja
{
    public static void main(String[] args) {
        int [] nums = {1,2,3,1};
        System.out.println("数组：[1,2,3,1]");
        int len = nums.length;
        int opt[] = new int[len];
        opt[0] = nums[0];
        opt[1] = opt[0]>nums[1]?opt[0]:nums[1];
        for(int i=2;i<len;i++){
            opt[i] = (opt[i-2]+nums[i])>opt[i-1]?opt[i-2]+nums[i]:opt[i-1];
        }
        System.out.printf(opt[len-1]+"");
    }


}
