package doublyLinkedList;

import java.util.Scanner;

class Node<T>{
    Node next;
    Node prev;
    T data;
    Node(T data){
        this.data=data;
    }

    Node (T data, Node next, Node prev){
        this.data=data;
        this.next=next;
        this.prev=prev;
    }
}
class DoublyLinkedList<T>{
    Scanner sc= new Scanner(System.in);
    Node head;
    Node tail;
    int size;
    void insertAtFirst(T data){
        Node addNode= new Node(data);
        addNode.next=head;
        addNode.prev=null;
        if(head!=null) {
            head.prev = addNode;
        }

        head=addNode;
        size++;

    }
    void reverse(){

        System.out.println("**********************************************************");
         Node temp=tail;
        while(temp !=null){
            System.out.print(temp.data+"<-");
            temp = temp.prev;
        }
        System.out.println("Start");
    }
    void display(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            tail=temp;
            temp=temp.next;

        }
        System.out.println("End");
    }
    void InsertLast(T data){
        Node addNode=new Node(data);
        if(head==null){
            head=addNode;
            tail=addNode;
            return;
        }
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        } temp.next=addNode;
        addNode.prev=temp;

    }
    void InsertMid(T data){
        System.out.println("Enter the position where node should be added!!");
        int pos= sc.nextInt();
        Node node=new Node(data);
        Node temp=head;
        if(pos==1){
            insertAtFirst(data);
            return;
        }
        for(int i=2;i<pos;i++){
            temp= temp.next;
        }
        node.next=temp.next;
        temp.next=node;
        node.prev=temp;
        if(node.next!=null){
        node.next.prev=node;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList node=new DoublyLinkedList();
        node.insertAtFirst(5);
        node.insertAtFirst(57);
        node.insertAtFirst(59);
        node.InsertLast(100);
        node.InsertMid("mid");
        node.display();
        node.reverse();
    }
}