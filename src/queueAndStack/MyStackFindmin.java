package queueAndStack;

import queueAndStack.MyLinkedStack;

/**
 * @author ly
 * @date 2019/5/30 11:21
 */
public class MyStackFindmin {
    MyLinkedStack<Integer> elem;
    MyLinkedStack<Integer> min;

    public MyStackFindmin() {
        this.elem = new MyLinkedStack<Integer>();
        this.min = new MyLinkedStack<Integer>();
    }

    public void push(int data){
        elem.push(data);
        //如果当前值小于最小值栈中的栈顶元素，则把元素压入栈
        if(min.isEmpty()){
            min.push(data);
        }else {
            if(data<min.peek()){
                min.push(data);
            }
        }
    }

    public Integer pop(){
        int topData = elem.peek();
        elem.pop()  ;
        if(topData==getMin()){
            min.pop();
        }
        return topData;
    }

    public int getMin() {
       if(min.isEmpty()){
           return Integer.MAX_VALUE;
       }else return min.peek();
    }

}
