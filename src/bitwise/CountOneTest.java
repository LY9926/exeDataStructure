package bitwise;

/**
 * @author ly
 * @date 2019/6/5 15:14
 * 右移
 */
public class CountOneTest {
    public static void main(String[] args) {
        System.out.println("1的二进制中2的个数 "+countOne(1));
    }

    private static int countOne(int n) {
        int count = 0;
        while (n>0){
           n = n & (n - 1);
           count++;
        }
        return count;
    }
}
