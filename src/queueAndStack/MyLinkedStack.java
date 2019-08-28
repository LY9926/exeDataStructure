package queueAndStack;

/**
 * @author ly
 * @date 2019/5/30 11:03
 * 非线程安全
 */
public class MyLinkedStack<E> {
    class Node<E>{
        Node<E> next = null;
        E data;
        public Node(E data) {
            this.data = data;
        }
    }

   Node<E> top = null;
   public boolean isEmpty(){
       return top==null;
   }

   /**
   * @Description: 进栈
   * @Param: [item]  头插法
   * @return: void
   * @Author: ly
   * @Date: 2019/5/30
   */
   public void push(E item){
       Node node = new Node(item);
        node.next= top;
        top = node;
   }

   /**
   * @Description: 出栈
   * @Param: []
   * @return: E
   * @Author: ly
   * @Date: 2019/5/30
   */
   public E pop(){
       if(isEmpty()){
           return null;
       }
       E data = top.data;
       top = top.next;
       return data;
    }


    /**
    * @Description: 取栈顶元素的值
    * @Param: []
    * @return: E
    * @Author: ly
    * @Date: 2019/5/30
    */
    public E peek(){
       if(isEmpty()){
           return null;
       }
       return top.data;
    }
}


