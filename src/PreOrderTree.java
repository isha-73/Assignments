import java.util.Stack;

public class PreOrderTree {
    public void preOrderRecursive(NodeOfTree root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrderRecursive(root.left);
            preOrderRecursive(root.right);
        }
    }

    public void preorderIteration(NodeOfTree root) {
        Stack<NodeOfTree> s = new Stack<NodeOfTree>();
        while (true) {
            // First print the root node and then add left node
            while (root != null) {
                System.out.print(root.data + " ");
                s.push(root);
                root = root.left;
            }
            // check if Stack is emtpy, if yes, exit from everywhere
            if (s.isEmpty()) {
                return;
            }
            // pop the element from the stack and go right to the tree
            root = s.pop();
            root = root.right;
        }
    }

    public static void main(String[] args) {
        NodeOfTree root = new NodeOfTree(1);
        root.left = new NodeOfTree(2);
        root.right = new NodeOfTree(3);
        root.left.left = new NodeOfTree(4);
        root.left.right = new NodeOfTree(5);
        root.right.left = new NodeOfTree(6);
        root.right.right = new NodeOfTree(7);

        PreOrderTree i = new PreOrderTree();
        i.preOrderRecursive(root);
        System.out.println();
        i.preorderIteration(root);
    }


}

class NodeOfTree {
    int data;
    NodeOfTree left;
    NodeOfTree right;

    public NodeOfTree(int data) {
        this.data = data;
    }
}