//Isha Bule - UCE2021610
  //      Assignment 4 Stack implementation using linked list
package Stack;
import java.util.*;

class Node<T> {
    Node next;
    T data;
    Node(T data){
        this.data=data;
        next=null;
    }
}
class MyStack <T> {
    Scanner sc = new Scanner(System.in);
    Node head;
    int size;
    MyStack(){
        // head=null;
        size=0;
    }
    void push(T data){
        Node newNode = new Node(data);
        if(head==null) {
            head=newNode;
            return;
        }
        newNode.next=head;
        head=newNode;
        size++;

    }
    T pop () {
        if(head==null){
            System.out.println("Stack is empty!");
        }
        T dataToPop = (T) head.data;
        head=head.next;
        size--;
        return dataToPop;
    }
    void peek(){
        if(head!=null){
            System.out.println("Top most element in stack is : "+head.data);
            return;
        }else System.out.println("Stack is empty");
    }
    String isEmpty(){
        if(head==null){
            return "Yes Stack is empty";
        }
        return "Data in stack exists";
    }
    boolean isFull(int size){
        if(this.size == size){
            System.out.println("Stack is full....");
            return true;
        }
        return false;
    }

}

public class StackExp {
    static Scanner sc = new Scanner(System.in);
    static void solveExpression(){
        MyStack <Float> stackObj= new MyStack<Float>();
        System.out.println("Enter the expression to solve...");
        String str = sc.next();
        int size = str.length();


        for(int i =0; i<size;i++){
            if(str.charAt(i)=='+'||str.charAt(i)=='-'||str.charAt(i)=='/'||str.charAt(i)=='*'){
                float op2= stackObj.pop();
                float op1= stackObj.pop();
                float res;
                switch (str.charAt(i)){
                    case '+':  res=op1+op2;
                        stackObj.push(res);
                        break;
                    case '-':  res=op1-op2;
                        stackObj.push(res);
                        break;
                    case '/':  res=op1/op2;
                        stackObj.push(res);
                        break;
                    case '*':  res=op1*op2;
                        stackObj.push(res);
                        break;
                }
            }else{
                stackObj.push(Float.parseFloat(String.valueOf(str.charAt(i))));
            }
        }
        System.out.println("Result of expression is : "+ stackObj.pop());

    }
    static void reverseString(){
        MyStack <Character> string= new MyStack<Character>();
        System.out.println("Enter the string to reverse...");
        String str = sc.nextLine();
        str = sc.nextLine();
        int size = str.length();
        for(int i =0; i<size;i++){
            char c = str.charAt(i);
            string.push(c);
        }
        System.out.printf("Reverse of %s is ",str);
        for(int i =0; i<size;i++) {
            try {
                System.out.print(string.pop());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int choice=0;
        do{
            System.out.println("Menu: \n 1. Evaluate Expression \n 2. Reverse String \n 0. Exit");
            choice = sc.nextInt();
            switch (choice){
                case 1: solveExpression();
                    break;
                case 2: reverseString();
                    break;
            }
        }while(choice!=0);
    }

}
/*

OUTPUT:
        Menu:
        1. Evaluate Expression
        2. Reverse String
        0. Exit
        1
        Enter the expression to solve...
        5122/*-

Result of expression is : 4.0
Menu:
 1. Evaluate Expression
 2. Reverse String
 0. Exit
2
Enter the string to reverse...
Hi Annada
Reverse of Hi Annada is adannA iH
Menu:
 1. Evaluate Expression
 2. Reverse String
 0. Exit
0
*/
