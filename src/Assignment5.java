import java.util.*;
class Pizza
{
    // creating pizza node
    String pizzaName;
    char size;
    int price;
    Pizza next;
    int orderNum=0;
    public Pizza (String pizzaName,char size,int price){ // (S-small, M-medium ,L-large)

        this.pizzaName= pizzaName;

        this.size=size;
        this.price=price;
        next= null;


    }

}

 class PizzaParlour
{
    Pizza front, rear;
    int maxSize;

    PizzaParlour(int maxSize){
        this.maxSize=maxSize;

    }

    boolean isFull()
    {
        int size=0;
        Pizza temp=front;
        while( temp.next!=null ){
            size++;
            temp=temp.next;
        }
        if ( size==maxSize){
            System.out.println("Queue is full of pizza!");
            return true;

        }
        else return false;
    }
    boolean isEmpty()

    {
        if (front==null){
            System.out.printf("The Queue of pizza is empty");
            return true;
        }
        return false;
    }
        void placeOrder(String pizzaName,char size,int price) // Enqueue
        {
            Pizza newPizza  =  new Pizza(pizzaName,size,price);
            if(front==null){
                front=rear=newPizza;
                newPizza.orderNum=1;
                return;
            }
            newPizza.orderNum= rear.orderNum+1;
            rear.next=newPizza;
            rear=newPizza;


        }
        void deliverOrder() //Dequeue
        {
            if(front== null){
                System.out.println("Sorry , no order is placed");
                return;
            }
            String pizzaName=front.pizzaName;
            char size=front.size;
            int price=front.price;

            System.out.printf("Your order of order number %d Pizza %s of size %c cost %d is out foe delivery ",front.orderNum,pizzaName,size,price);
            front = front.next;


        }
        void displayOrder() // All the orders present in the Queue
        {
            System.out.println("Pizza     Size     price");
            Pizza temp = front;
            while(temp!=null){
                System.out.println(temp.pizzaName+"    "+temp.size+"   "+temp.price);
                temp=temp.next;
            }
        }
    }
    public class Assignment5 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Welcome dear to 'PIZZABoaT'");
            PizzaParlour pizzaOrders = new PizzaParlour(6);
            System.out.println("CheckOut for the menu :");
            int choice=0;
            do {
                System.out.println("1: Place Order\n2:Deliver Order\n3:Check if queue is Empty\n4:Check if queue is Full\n0:Exit");
                choice = sc.nextInt();
                switch(choice){
                    case 1:
                        System.out.println("Choose your Yum : \n1- Margherita \n2-Pepperoni \n3-Hawaiian \n4-Stuffed Crust");
                        int type = sc.nextInt();
                        System.out.println("Select the size of pizza : \nS-Small \nM-Medium \nL-Large");
                        String size = sc.next();
                        char size1 = size.charAt(0);
                        String typo = null;
                        int prize = 0;
                        if (type == 1)
                            typo = "Margherita";
                    {
                        if (size1 == 'S') {
                            prize = 100;
                        } else if (size1 == 'M') {
                            prize = 150;
                        } else if (size1 == 'L') {
                            prize = 170;
                        }
                    }
                    if (type == 2)
                        typo = "Pepperoni";
                    {
                        if (size1 == 'S') {
                            prize = 110;
                        } else if (size1 == 'M') {
                            prize = 160;
                        } else if (size1 == 'L') {
                            prize = 170;
                        }
                    }
                    if (type == 3) {
                        typo = "Hawaiian";
                        if (size1 == 'S') {
                            prize = 110;
                        } else if (size1 == 'M') {
                            prize = 160;
                        } else if (size1 == 'L') {
                            prize = 220;
                        }
                    }
                    if (type == 4) {
                        typo = "Stuffed Crust";
                        if (size1 == 'S') {
                            prize = 120;
                        } else if (size1 == 'M') {
                            prize = 170;
                        } else if (size1 == 'L') {
                            prize = 230;
                        }
                    }
                    pizzaOrders.placeOrder(typo,size1,prize);
                    break;
                    case 2:
                        pizzaOrders.deliverOrder();
                        break;

                    case 3:
                         pizzaOrders.isEmpty();
                         break;

                    case 4:
                          pizzaOrders.isFull();
                          break;
                    case 0:
                            System.out.println("Will meet you soon , Have A Great Day!");
                            break;
                }


            }while (choice!=0);









           // pizzaOrders.placeOrder(typo,size1,prize);
           // pizzaOrders.deliverOrder();
            //pizzaOrders.displayOrder();

        }
    }

