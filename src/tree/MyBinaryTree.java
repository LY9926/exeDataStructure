package tree;

import java.util.*;

/**
 * @author ly
 * @date 2019/6/23 10:52
 * 二叉排序树：
 * 如果左子树不为空，则左子树上所有的节点值均小于它的根节点；
 * 如果右子树不为空，则右子树上的所有节点的值均大于它的根节点的值
 * 左右子树也分别为二叉排序树
 */

class Node{
    public int data;
    public Node left;
    public Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
public class MyBinaryTree {
    private Node root;
    public MyBinaryTree(){
        root = null;
    }

    public void insert(int data){
        Node newNode = new Node(data);
        if(root==null){
            root  = newNode;
        }else {
            Node cur = root;
            Node parent;
            while (true){
                parent = cur;
                if(data<cur.data){
                    cur = cur.left;
                    if(cur==null){
                        parent.left = newNode;
                        return;
                    }
                }else {
                    cur = cur.right;
                    if(cur==null){
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    public void buildsortTree(int []data){
        for (int i=0;i<data.length;i++){
            insert(data[i]);
        }
    }


    //中序遍历
    public void inOrder(Node localRoot){
        if(localRoot!=null){
            inOrder(localRoot.left);
            System.out.print(localRoot.data+" ");
            inOrder(localRoot.right);
        }
    }

    public void inOrder(){
        this.inOrder(root);
    }

    //先序遍历
    public void  preOrder(Node localRoot){
       if(localRoot!=null){
           System.out.print(localRoot.data+" ");
           preOrder(localRoot.left);
           preOrder(localRoot.right);
       }
    }

    public void preOrder(){
        this.preOrder(root);
    }





    /**
    * @Description: 层序遍历
    * @Date: 先将根节点放入队列中，然后每次都从队列中取出一个节点打印该节点的值，若这个节点还有子节点，则将他的子节点放入队列尾，知道队列为空
    */
    public  void layerTrancerse(){
        if(root==null)
            return;
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(this.root);
        while (!queue.isEmpty()){
            Node n = queue.poll();
            System.out.print(n.data+" ");
            if(n.left!=null){
                queue.add(n.left);
            }
            if(n.right!=null){
                queue.add(n.right);
            }
        }
    }

    /**
    * @Description:  层析遍历，每一层在一个list中
    * @Date: 2019/6/24
    */
   public ArrayList<ArrayList<Integer>> Print() {
        ArrayList<ArrayList<Integer> > lists = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(this.root);
        ArrayList<Integer> list = new ArrayList<>();
        int now = 1, next = 0;//队列里面有now个，当前层下一层有next个；
        while(!q.isEmpty()){
            Node node =  q.poll();
            now--;
            list.add(node.data);
            if(node.left!=null){
                q.add(node.left);
                next++;
            }
            if(node.right!=null){
                q.add(node.right);
                next++;
            }
            if(now==0){
                lists.add(new ArrayList<Integer>(list));
                list.clear();
                now = next;
                next = 0;
            }
        }
        return lists;
    }
    /**
     * @Description:  层析遍历，每一层在一个list中
     * @Date: 2019/6/24
     */
    public ArrayList<ArrayList<Integer>> Print1() {
        ArrayList<ArrayList<Integer> > lists = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(this.root);
        while(!q.isEmpty()){
            ArrayList<Integer> list = new ArrayList<>();
            int size = q.size();
            for (int i=0;i<size;i++){
                Node node =  q.poll();
                list.add(node.data);
                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
            }
            lists.add(list);
        }
        return lists;
    }


    // 锯齿形输出层次遍历的结果
    public List<List<Integer>> zigzagLevelOrder() {
        List<List<Integer>> lists = new ArrayList<>();
        if(this.root==null){
            return lists;
        }
        LinkedList<Node> q = new LinkedList<>();
        q.add(this.root);
        boolean isleftToright = true;
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for (int i=0;i<size;i++){
                Node node;
                if(isleftToright){
                    node = q.poll();
                    list.add(node.data);
                    if(node.left!=null){
                        q.add(node.left);
                    }
                    if(node.right!=null){
                        q.add(node.right);
                    }
                }else {
                    node = q.removeLast();
                    list.add(node.data);
                    if(node.right!=null){
                        q.addFirst(node.right);
                    }
                    if(node.left!=null){
                        q.addFirst(node.left);
                    }
                }
            }
            isleftToright = !isleftToright;
            lists.add(list);
        }
        return lists;
    }

    public static void main(String[] args) {
        MyBinaryTree tree = new MyBinaryTree();
        int data[] = {2,8,7,4,9,3,1,6,7,5};
        tree.buildsortTree(data);
        System.out.print("先序遍历的结果为：");
        tree.preOrder();
        System.out.println();
        System.out.print("中序遍历的结果为：");
        tree.inOrder();
        System.out.println();
        System.out.print("非递归中序遍历的结果为：");
        tree.numRESinOrder();
        System.out.println();
        System.out.print("层次遍历的结果为：");
        tree.layerTrancerse();
        System.out.println();
        System.out.print("多级层次遍历的结果为：");
        System.out.println(tree.Print());
        System.out.print("多级锯齿形层次遍历的结果为：");
        System.out.println(tree.zigzagLevelOrder());
        MyBinaryTree nTree = new MyBinaryTree();
        int preOdr[] = {1,2,4,8,9,5,10,3,6,7};
        int inOdr[] = {8,4,9,2,10,5,1,6,3,7};
        nTree.initTree(preOdr,inOdr);
    }

    private void numRESinOrder() {
        if(this.root==null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node node = this.root;
        stack.push(node);
        while (!stack.isEmpty()){
            if(node!=null&&node.left!=null){
                stack.push(node.left);
                node = node.left;
            }else {
                node = stack.pop();
                System.out.println(node.data+" ");
                if(node!=null&&node.right!=null){
                    stack.push(node.right);
                    node = node.right;
                }else {
                    node = null;
                }
            }
        }

    }

    private void initTree(int[] preOdr, int[] inOdr) {
        this.root = this.buildTree(preOdr,0,preOdr.length-1,inOdr,0,inOdr.length-1);
    }

    private Node buildTree(int[] preOdr, int pstart, int pend, int[] inOdr, int instart, int inend) {
        if(pstart>pend||instart>inend){
            return null;
        }
        int rootData = preOdr[pstart];
        Node head = new Node(rootData);
        for (int i=instart;i<=inend;i++){}
        int rootIndex = findIndexInArray(inOdr,rootData,instart,inend);
        int offset = rootIndex-instart-1;
        head.left = buildTree(preOdr,pstart+1,pstart+1+offset,inOdr,instart,instart+offset);
        head.right = buildTree(preOdr,pstart+2+offset,pend,inOdr,rootIndex+1,inend);
        return head;
    }

    private int findIndexInArray(int[] inOdr, int rootData, int instart, int inend) {
        for (int i=instart;i<=inend;i++){
            if(inOdr[i] == rootData){
                return i;
            }
        }
        return -1;
    }


}
