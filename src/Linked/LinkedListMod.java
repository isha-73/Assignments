package Linked;
class Node<T> {
   T data;
    Node next;

    Node(T data){
        this.data=data;
    }

    Node (T data, Node next){
        this.data=data;
        this.next=next;
    }
}
public class LinkedListMod <T> {
    Node head;
    Node tail;
    int size=0;
    void InsertAtFirst(T data){
        Node toAdd = new Node(data);
        toAdd.next=head;
        head=toAdd;

        if(tail==null){
            tail=head;
        }
        size++;

    }
    void InsertAtLast(T data){
        if(tail==null){
            InsertAtFirst(data);
            size++;
            return;
        }else
        {
            Node node =new Node(data);
            tail.next=node;
            tail=node;
            size++;
        }

    }
    void insertAtMid(T data, int pos){
        if(pos==0){
            InsertAtFirst(data);
            size++;
            return;
        }
        if(pos==size){
            InsertAtLast(data);
            size++;
            return;
        }
        Node prev=head;
        for(int i=0;i<pos-1;i++){
            prev=prev.next;
        }
        Node node= new Node(data,prev.next);
        prev.next=node;
        size++;

    }
    void display(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;

        }
        System.out.println("size  ="+ size);
    }

    public static void main(String[] args) {
        LinkedListMod node=new LinkedListMod();
        node.InsertAtFirst("Start");
        node.InsertAtFirst("End");
        node.InsertAtFirst("Pichhe se");
        node.display();
        System.out.println("**************************");
        node.InsertAtLast("Tail me");
        node.display();
        System.out.println("**************************");
        node.insertAtMid("555",3);
        node.display();
    }
}
