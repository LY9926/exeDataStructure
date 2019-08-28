package queueAndStack;

import java.util.Arrays;

/**
 * @author ly
 * @date 2019/5/30 10:20
 * 数组的方式实现栈
 * 非线程安全
 */
public class MyArrStack<E> {
    private Object[] stack;
    private int size;//数组中存储元素的个数
    public MyArrStack(){
        stack = new Object[10];
    }
    public Boolean isEmpty(){
        return size==0;
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
        return (E)stack[size-1];
    }

    /**
    * @Description: 出栈
    * @Param: []
    * @return: E
    * @Author: ly
    * @Date: 2019/5/30
    */
    public E pop(){
        E e = peek();
        stack[size-1] = null;
        size--;
        return e;
    }

    public E push(E item){
        ensureCapacity(size+1);
        stack[size++] = item;
        return  item;
    }

    private void ensureCapacity(int size) {
       int len = stack.length;
       if(size>len){
           int newlen  = 10+len;//每次数组扩充的容量
           stack = Arrays.copyOf(stack,newlen);
           System.out.println("扩容后的大小"+stack.length);
       }
    }

    public static void main(String[] args) {
        MyArrStack<String> myArrStack = new MyArrStack<>();
        myArrStack.push("ly");
        myArrStack.push("jc");
        myArrStack.push("ly");
        myArrStack.push("jc"); myArrStack.push("ly");
        myArrStack.push("jc"); myArrStack.push("ly");
        myArrStack.push("jc");
        myArrStack.push("ly");
        myArrStack.push("jc"); myArrStack.push("ly");
        myArrStack.push("jc"); myArrStack.push("ly");
        myArrStack.push("jc"); myArrStack.push("ly");
        myArrStack.push("jc"); myArrStack.push("ly");
        myArrStack.push("jc");








        System.out.println(myArrStack.size);
        System.out.println(myArrStack.pop());
        System.out.println(myArrStack.pop());
    }


}
