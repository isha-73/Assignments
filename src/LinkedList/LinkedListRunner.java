package LinkedList;
class Node{
    int data;
    Node next;
}
class LinkedList {
    Node head;

    void insert(int data) {
        Node node = new Node();
        node.data = data;
        node.next = null;
        if (head == null) {
            head = node;
        } else {
            Node n = head;
            while (n.next != null) {
                n = n.next;
            }
            n.next = node;

        }
    }
    void show(){
        Node node=head;
        while(node!=null){
            System.out.print(node.data+" ");
            node=node.next;
        }
        System.out.println(node.data); // for last data we have to put manually as loop terminates as it refers to null node
    }
}
public class LinkedListRunner {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insert(1);
        linkedList.insert(2);
        linkedList.insert(3);
        linkedList.insert(4);
        linkedList.show();
    }

}
