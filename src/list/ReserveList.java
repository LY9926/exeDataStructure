package list;

/**
 * @author ly
 * @date 2019/6/20 9:45
 */
public class ReserveList {
    public Node node;
    public class Node{
        int val;
        Node next;
        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ReserveList list = new ReserveList();
    }

}
