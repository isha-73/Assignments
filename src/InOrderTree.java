import java.io.IOException;
import java.util.Scanner;
//import java.util.Stack;
public class InOrderTree {

    public void inorderRecursive(treeNode root) {
        if (root != null) {
            inorderRecursive(root.left);
            System.out.print(root.data + " ");
            inorderRecursive(root.right);
        }
    }

    public void inorderIteration(treeNode root) throws IOException {
       // Stack<treeNode> s = new Stack<treeNode>();
        MyStack s= new MyStack();
        while (true) {
            // Go to the left extreme insert all the elements to stack
            while (root != null) {
                s.push(root);
                root = root.left;
            }
            // check if Stack is empty, if yes, exit from everywhere
           /* if (s.isEmpty()) {
                return;
            }*/
            // pop the element from the stack , print it and add the nodes at
            // the right to the Stack
            root =s.pop();
            System.out.print(root.data + " ");
            root = root.right;
        }
    }

    public static void main(String[] args) {
        treeNode root = new treeNode(1);
        root.left = new treeNode(2);
        root.right = new treeNode(3);
        root.left.left = new treeNode(4);
        root.left.right = new treeNode(5);

        InOrderTree i = new InOrderTree();
        System.out.println("Recursive InOrder");
        i.inorderRecursive(root);
        System.out.println();
        System.out.println("Non Recursive InOrder");
        try {
            i.inorderIteration(root);
        } catch (IOException e) {}
    }

}

class treeNode {
    int data;
    treeNode left;
    treeNode right;

    public treeNode(int data) {
        this.data = data;
    }
}

class stackNode{
    stackNode next;
    treeNode data ;
    stackNode (treeNode data){
        this.data=data;
        next=null;
    }
}
class MyStack {
    Scanner sc = new Scanner(System.in);
    stackNode head;
    int size;

    MyStack() {
        head = null;
        size = 0;

    }

    void push(treeNode data) {
       stackNode newNode = new stackNode(data);
        newNode.next = head;
        head = newNode;


    }

    treeNode pop() throws IOException {
        if (head == null) {
            throw new IOException("");
        }
        treeNode dataToPop =  head.data;
        head = head.next;
        size--;
        return dataToPop;
    }
}