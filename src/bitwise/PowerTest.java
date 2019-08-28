package bitwise;

/**
 * @author ly
 * @date 2019/6/5 14:53
 * 判断一个数是否是2的n次方 右移
 */
public class PowerTest {
    public static void main(String[] args) {
        System.out.println("17 是不是2的n次方？ " + (isPower(10)==0?"是":isPower(14)));
    }

    private static int isPower(int n) {
        if (n < 2) {
            return -1;
        }
//        int i=1;
//        while (i <= n) {
//            i = i << 1;
//            if (i == n) {
//                return true;
//            }
//        }
        return n & (n - 1);
    }
}
