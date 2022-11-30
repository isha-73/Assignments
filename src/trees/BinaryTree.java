package trees;
import java.util.Scanner;
import java.util.Stack;

public class BinaryTree {

    static Scanner sc = null;
    public static void main(String[] args) {
        sc = new Scanner(System.in);

       Node root=null;
        int choice =0;
        do {
            System.out.println("**************************************");
            System.out.println("MENU: \n\n1.Create a Binary Tree \n2.Display the recursive Inorder \n3.Display the non recursive Inorder \n4.Display the non recursive Preorder\n5.Display the non Recursive Postorder \n6.Display the recursive Preorder \n7.Display the recursive Postorder");
            System.out.println("\n*************************************");
            System.out.println("\nEnter your choice: ");
            choice = sc.nextInt();
            switch(choice) {
                case 1:  root = createTree();
                            break;

                case 2:     System.out.println("******************INORDER TRAVERSAL OF THE BINARY TREE******************");
                            inOrder(root);
                            System.out.println();
                            break;
                case 3:   System.out.println("*******************NON-RECURSIVE INORDER TRAVERSAL OF THE BINARY TREE******************");
                            NonRecursiveinorder(root);
                           System.out.println();
                            break;
                case 4 :   System.out.println("*******************NON-RECURSIVE PRE-ORDER TRAVERSAL OF THE BINARY TREE******************");
                            NonRecurssivePreorder(root);
                    System.out.println();
                            break;
                case 5:  System.out.println("*******************NON-RECURSIVE POST-ORDER TRAVERSAL OF THE BINARY TREE******************");
                            NonRecurssivePostOrder(root);
                            System.out.println();
                            break;
                case 6:   System.out.println("*******************PRE-ORDER TRAVERSAL OF THE BINARY TREE******************");
                            preOrder(root);
                    System.out.println();
                            break;
                case 7:  System.out.println("*******************POST-ORDER TRAVERSAL OF THE BINARY TREE******************");
                        postOrder(root);
                    System.out.println();
                        break;
                case 0:
                    System.out.println("Visit again , Bye bye");
                    break;
            }
        }while(choice!=0);
    }

    static Node createTree() {

        Node root = null;
        System.out.println("Enter data: ");
        int data = sc.nextInt();

        if(data == -1) return null;

        root = new Node(data);

        System.out.println("Enter left for " + data);
        root.left = createTree();

        System.out.println("Enter right for "+ data);
        root.right = createTree();

        return root;
    }
    static void NonRecursiveinorder(Node root){

        Stack<Node> s = new Stack<Node>();
        while(true) {
            while (root != null) {
                s.push(root);
                root = root.left;
            }
            if(s.isEmpty()){
                return;
            }
            root = s.pop();
            System.out.print(root.data+" ");
            root=root.right;
        }
    }

    static void inOrder(Node root) {
        if(root == null) return;

        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }
   static void NonRecurssivePreorder(Node root){

        Stack<Node> s = new Stack<Node>();
        while(true) {
            while (root != null) {
                System.out.print(root.data+" ");
                s.push(root);
                root = root.left;
            }
            if(s.isEmpty()){
                return;
            }
            root = s.pop();
            root=root.right;
        }
    }
    static void preOrder(Node root) {
        if(root == null) return;
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    static void NonRecurssivePostOrder(Node root) {


            Stack<Node> s1 = new Stack<Node>();
            Stack<Node> s2 = new Stack<Node>();
            s1.push(root);
            while(!s1.isEmpty()) {
                Node temp = s1.pop();
                s2.push(temp);
                if (temp.left != null) {
                    s1.push(temp.left);
                }
                if (temp.right != null) {
                    s1.push(temp.right);
                }
            }
            while(!s2.isEmpty()) {
              Node temp = s2.pop();
                System.out.print(temp.data + " ");
            }
    }
    static void postOrder(Node root) {
        if(root == null) return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }
    static Node deleteTree(Node root) {
        if(root==null){
            return null;
        }
        deleteTree(root.left);
        deleteTree(root.right);
        System.out.println("Deleted " + root.data);
        root = null;
        return root;

    }
}

class Node {
    Node left, right;
    int data;

    public Node(int data) {
        this.data = data;
    }
}
