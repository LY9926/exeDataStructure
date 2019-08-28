package bitwise;

/**
 * @author ly
 * @date 2019/6/5 14:43
 * 用位运算代替二的倍数的乘法 左移
 */
public class Muti {
    public static void main(String[] args) {
        System.out.println("3乘以16= "+powerN(3,4));
    }

    private static int powerN(int m, int n) {
        for (int i=0;i<n;i++){
            m = m <<1;

        }
        return m;
    }
}
