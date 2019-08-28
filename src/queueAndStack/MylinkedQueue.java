package queueAndStack;

/**
 * @author ly
 * @date 2019/5/30 14:22
 * 通过链表实现队列，完成元素先进先出，元素行队尾入栈，队头出栈
 */
class Node<T>{
    Node <T> next=null;
    T data;
    public Node(T data) {
        this.data = data;
    }
}

public class MylinkedQueue<T> {
     Node<T> head = null;
     Node<T> tail = null;

    public boolean isEmpty(){
        return head == tail;
    }

    /**
    * @Description: 入队，在队尾进行入队操作
    * @Param: [data]
    * @return: void
    * @Author: ly
    * @Date: 2019/5/30
    */
    public void put(T data){
        Node<T> newNode = new Node<T>(data);
        if(head==null&&tail==null){
            head = tail = newNode;
        }else {
            tail.next = newNode;
             tail= newNode;
        }
    }

    /** 
    * @Description: 出队
    * @Param: [] 将对头元素进行出队
    * @return: T 
    * @Author: ly
    * @Date: 2019/5/30 
    */ 
    public T pop(){
        if(this.isEmpty()){
            return null;
        }
        T data = head.data;
        head = head.next;
        return data;
    }

    public int size(){
        Node<T> temp = head;
        int n=0;
        while (temp!=null){
            n++;
            temp = temp.next;
        }
        return n;
    }

    public static void main(String[] args) {
        MylinkedQueue<Integer> queue =new MylinkedQueue<>();
        queue.put(1);
        queue.put(2);
        queue.put(4);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }



}
