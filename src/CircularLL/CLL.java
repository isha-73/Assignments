package CircularLL;
class Node<T>{
    T data;
    Node next;
    Node(T data){
      this.data=data;
    }
}
public class CLL<T> {
    Node head;
    Node tail;
    void insert(T data){
        Node node = new Node(data);
        if(head==null){
            head=node;
            tail=node;
            return;
        }
        //if(head!=null){

                System.out.println("Inside insert");
                tail.next=node;
                node.next=head;
                tail=node;


    }
    void display(){
        Node temp=head;
      if (head!=null){
        do{
            System.out.print(temp.data+" ");
            temp=temp.next;
        }while(temp!=head);

      }
    }
    void delete(T data){
        Node node = head;
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        if(node.data==data){
            head=head.next;
            tail.next=head;
            return;
        }
        do{
            Node temp=node.next;
            if(temp.data==data){
                node.next=temp.next;
                break;
            } node=node.next;
        }while(node!=head);
    }

    public static void main(String[] args) {
        CLL node = new CLL();
        node.insert(1);
        node.insert(2);
        node.insert(3);
        node.insert(4);
        System.out.println("This is the circular linkedlist");
        node.display();
        System.out.println();
        System.out.println("What u want to delete??");
        node.delete(4);
        node.display();
    }
}
