package list;


import java.util.Arrays;
import java.util.Comparator;

/**
 * @author ly
 * @date 2019/5/27 20:07
 */
public class MyLinkedList {
    Node  head = null;
    
    public class Node {
        Node next = null;
        int data;
         public Node(int data) {
             this.data = data;
         }
     }





     
     /** 
     * @Description:  添加元素
     * @Param:  
     * @return:  
     * @Author: ly
     * @Date: 2019/5/27 
     */ 
     public void addNode(int d){
         Node newNode = new Node(d);
         if(head==null){
             head = newNode;
             return;
         }
         //先从头结点遍历到尾节点再插入
         Node node = head;
         while (node.next!=null){
             node = node.next;
         }
         node.next= newNode;
     }
     
     /** 
     * @Description: 删除第i个节点，
     * 分为删除第一个节点和其他节点
     * @return: java.lang.Boolean 删除成功则返回true，失败则返回false
     * @Author: ly
     * @Date: 2019/5/27
     */ 
     public Boolean deleteNode(int index){
         if(index<1||index>length()){
             return false;
         }
         //删除第一个元素
         if(index==1){
              head= head.next;
              return true;
         }
         int ind = 1;
         Node preNode = head;
         Node curNode = head.next;
         while (curNode!=null){
             if(ind == index){
               preNode.next  =  curNode.next;
               return true;
             }
             ind++;
             preNode = curNode;
             curNode = curNode.next;
         }
         return true;
     }

    private int length() {
         int length = 0;
         Node node = head;
         while (node!=null){
             length++;
             node = node.next;
         }
         return length;
    }
    
    /** 
    * @Description: 对链表进行排序
    * 每次选剩下元素中最小的
    * @return: void 
    * @Author: ly
    * @Date: 2019/5/28 
    */ 
    public Node orderLinkedList(){
        Node node = head;
        while (node.next!=null){
            Node nextNode = node.next;
            while (nextNode!=null){
                if(node.data>nextNode.data){
                    int temp = node.data;
                    node.data = nextNode.data ;
                    nextNode.data  = temp;
                }
                nextNode = nextNode.next;
            }
            node = node.next;
        }
         return head;
    }
    /**
    * @Description: 打印链表
    * @Param: []
    * @return: void
    * @Author: ly
    * @Date: 2019/5/28
    */
    public void printLinkedList(){
        Node node = head;
        while (node!=null){
            System.out.println(node.data);
            node = node.next;
        }
    }

    /**
    * @Description: 删除链表中的重复节点
    * @Param: []
    * @return: void
    * @Author: ly
    * @Date: 2019/5/28
    */
    public void deleteDuple(){
       Node curNode = head;
       while (curNode!=null){
           Node node = curNode;
           while (node.next!=null){
               if(node.next.data == curNode.data){
                   node.next = node.next.next;
               }else
                    node= node.next;

           }
           curNode = curNode.next;
       }
    }

    /**
    * @Description: 找出单链表中的倒数第K个元素
    * @Param: [k]
    * @return: list.MyLinkedList.Node
    * @Author: ly
    * @Date: 2019/5/28
    */
    public Node findLastK(int k){
        Node fast = head;
        Node low = head;
        for(int i=0;i<k-1;i++){
            fast = fast.next;
        }
        while (fast.next!=null){
            fast = fast.next;
            low = low.next;
        }
        return low;
    }

    /** 
    * @Description: 翻转链表 
    * @Param: [] 
    * @return: void 
    * @Author: ly
    * @Date: 2019/5/29 
    */ 
    public void reverseList(){
        Node newHead = head;
        Node curNode = head;
        Node preNode = null;
        while (curNode!=null){
            Node nextNode = curNode.next;
            if(nextNode==null){
                newHead = curNode;
            }
            curNode.next = preNode;

            preNode = curNode;
            curNode = nextNode;
        }
        this.head = newHead;
    }

    /**
    * @Description: 从尾到头输出单链表
    * @Param: 递归法
    * @return: void
    * @Author: ly
    * @Date: 2019/5/28
    */
    public void printreserve(Node head){
        if(head!=null){
            printreserve(head.next);
            System.out.println(head.data);
        }
    }

    /**
    * @Description: 找到链表的中间结点
    * @Param: 双指针法
    * @return: list.MyLinkedList.Node
    * @Author: ly
    * @Date: 2019/5/28
    */
    public Node findMidNode(){
        Node fast = head;
        Node slow = head;
        while (fast!=null&&fast.next!=null&&fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
    * @Description: 检测链表是否存在环
    * @Param: []双指针法
    * @return: java.lang.Boolean
    * @Author: ly
    * @Date: 2019/5/28
    */
    public Boolean isLoop(){
        Boolean flag = false;
        Node fast = head;
        Node slow = head;
        while (slow.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow){ //当慢指针与快指针相遇了，则存在环
                flag =true;
            }
        }
        if(fast==null||slow==null){
           flag = false;
        }
        return flag;
    }

    /** 
    * @Description: 不知道头结点的情况下删除节点 
    * @Param: [node] 
    * @return: void 
    * @Author: ly
    * @Date: 2019/5/29 
    */ 
    public void deleteNodeUnKnowHead(Node node){
        if(node==null||node.next==null){
            return;
        }
        Node nextNode = node.next;
        //交换当前节点和后节点的值
        int temp = node.data;
        node.data = nextNode.data;
        nextNode.data = temp;
        //删除当前节点
        node.next= nextNode.next;


    }




    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addNode(4);
        linkedList.addNode(1);
        linkedList.addNode(3);
        linkedList.addNode(7);
        linkedList.addNode(4);
        linkedList.addNode(1);
        linkedList.printLinkedList();

        System.out.println("print reserve");
        linkedList.printreserve(linkedList.head);

        System.out.println("find last 5th");
        System.out.println(linkedList.findLastK(5).data);

        System.out.println("find mid node");
        System.out.println(linkedList.findMidNode().data);

        System.out.println("reverse after");
        linkedList.reverseList();
        linkedList.printLinkedList();

        System.out.println("deleteDuple after");
        linkedList.deleteDuple();
        linkedList.printLinkedList();

//        MyLinkedList.Node node = new MyLinkedList.Node(5);
//        linkedList.deleteNodeUnKnowHead( node);



    }


}
