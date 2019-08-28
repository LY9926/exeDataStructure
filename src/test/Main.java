package test;

/**
 * @author ly
 * @date 2019/6/11 9:52
 * 拷贝对象和原始对象的引用类型引用不同对象。
 */

public class Main {
    public static void main(String[] args) {
        int sum = 0;
        final int capacity = 40000000;
        for (int i = 0; i < 100; i++) {
            sum += cost(capacity);
        }
        System.out.println(sum / 100);
    }

    public static long cost(int capacity) {
        long start = System.currentTimeMillis();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 10000000; i++) {
            builder.append("java");
        }
        return System.currentTimeMillis() - start;
    }
}
