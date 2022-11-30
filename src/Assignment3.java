// Isha Deepak Bule
// UCE2021610
// Assignment 3 : Design a system to simulate Banking. Choose
//appropriate data structure.
import java.util.Scanner;
class  AccountNode{
    int Accountno;
    String Name;
    //String Address;
    float balance;
    AccountNode link=null;
    AccountNode(int num,String name,float bal){
        Name=name;
        Accountno=num;
      //  Address=adr;
        balance=bal;
       }

    }
 class Bank {
     AccountNode head;
     AccountNode newAccount;
     Scanner sc = new Scanner(System.in);

     void create() {
         int i = 0;
         System.out.println("**** Welcome To ITD Bank ****");
         for (i = 0; i < 3; i++) {
             int num;
             String name;
             String adr;
             float bal;
             System.out.println("Enter the Account No of Account " + (i + 1));
             num = sc.nextInt();
             System.out.println("Enter the Account name ");
             name = sc.nextLine();
             name = sc.nextLine();
           /*  System.out.println("Enter the address ");
             adr = sc.nextLine();*/
             System.out.println("Enter the balance in account ");
             bal = sc.nextFloat();
             AccountNode temp = new AccountNode(num, name,  bal);
             if (head == null) {
                 head = temp;
             } else {
                 newAccount = head;
                 while (newAccount.link != null) {
                     newAccount = newAccount.link;
                 }
                 newAccount.link = temp;

             }
         }

     }

     void displayList() {
         newAccount = head;
         if (newAccount == null) {
             System.out.println("List of accounts is empty!");
         } else {
             int cnt = 1;
             while (newAccount != null) { // it is the part of traversing
                 System.out.println("For account " + cnt);
                 System.out.println("Account Number: " + newAccount.Accountno + "\n Account Name: " + newAccount.Name);
                 System.out.println("Account Balance: " + newAccount.balance);
                 newAccount = newAccount.link;
                 cnt++;
             }

         }
     }

     void insert() {
         int num;
         String name;
         String adr;
         float bal;
         int howMuchInsertions, position;
         System.out.println("How many accounts are being inserted??");
         howMuchInsertions = sc.nextInt();
         for (int i = 0; i < howMuchInsertions; i++) {
             System.out.println("The position at where new-account " + (i + 1) + " must be inserted");
             position = sc.nextInt();
             System.out.println("Enter the Account No of new-account " + (i + 1));
             num = sc.nextInt();
             System.out.println("Enter the Account name ");
             name = sc.nextLine();
             name = sc.nextLine();
             System.out.println("Enter the address ");
             adr = sc.nextLine();
             System.out.println("Enter the balance in account ");
             bal = sc.nextFloat();
             AccountNode temp = new AccountNode(num, name,  bal);
             if (position == 0) {
                 temp.link = head;
                 head = temp;
             } else {
                 AccountNode prev = head;
                 for (i = 0; i < position - 1; i++) {
                     prev = prev.link;
                 }
                 temp.link = prev.link;
                 prev.link = temp;
             }
         }

     }

     void withdraw() {
         System.out.println("Enter the account number and amount to withdraw");
         int accnum = sc.nextInt();
         float withdraw = sc.nextFloat();
         AccountNode prev=head;
         int cnt=0;
         while(prev != null) {
             if(prev.Accountno==accnum) {  // if true,refers to the prev account node and access its data
                 prev.balance= prev.balance-withdraw;
                 cnt=1;
                break;
             } prev=prev.link;
         }
         if(cnt==0){
             System.out.println("Account not found!! Try again!");
             withdraw();
         }
         System.out.println("After Withdrawing the balance ammount is "+prev.balance);


     }
     void deposit(){
         System.out.println("Enter the account number and amount to deposit");
         int accnum = sc.nextInt();   // inorder to identify which node , we will check for the account number
         float deposit = sc.nextFloat();
         AccountNode prev=head;
         int cnt=0;
         while(prev != null) {
             if(prev.Accountno==accnum) {  // if true,refers to the prev account node and access its data
                 prev.balance= prev.balance+deposit;
                 cnt=1;
                 break;
             } prev=prev.link;
         }
         if(cnt==0){
             System.out.println("Account not found!! Try again!");
             withdraw();
         }
         System.out.println("After depositing, the balance amount is "+prev.balance);

     }
 }
         public class Assignment3 {
             public static void main(String[] args) {
                 Scanner sc = new Scanner(System.in);
                 Bank accounts = new Bank();
                 // switch case
                 accounts.create();
                 accounts.displayList();
                 int choice=0;
                 do{
                     System.out.println("**** Welcome To ITD Bank ****");
                     System.out.println("Menu: \n1: Add Account \n2: Display List\n3:Withdraw Amount\n4:Deposit Amount\n0:Exit");
                     choice = sc.nextInt();
                     switch(choice) {

                         case 1: accounts.insert();
                                break;
                         case 2: accounts.displayList();
                                break;
                         case 3: accounts.withdraw();
                                break;
                         case 4: accounts.deposit();
                                break;

                     }

             }while(choice!=0);
             }

         }


         /*
         "C:\Program Files\Java\jdk-18\bin\java.exe" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2021.3.3\lib\idea_rt.jar=58522:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2021.3.3\bin" -Dfile.encoding=UTF-8 -classpath E:\JavaIntellij\out\production\JavaIntellij Assignment3
Enter the Account No of Account 1
7502
Enter the Account name
Isha Bule
Enter the balance in account
85555
Enter the Account No of Account 2
7503
Enter the Account name
Tilak Dave
Enter the balance in account
6533333
Enter the Account No of Account 3
7504
Enter the Account name
Sarthak Bule
Enter the balance in account
75633333
For account 1
Account Number: 7502
 Account Name: Isha Bule
Account Balance: 85555.0
For account 2
Account Number: 7503
 Account Name: Tilak Dave
Account Balance: 6533333.0
For account 3
Account Number: 7504
 Account Name: Sarthak Bule
Account Balance: 75633337
**** Welcome To ITD Bank ****
Menu:
1: Add Account
2: Display List
3:Withdraw Amount
4:Deposit Amount
0:Exit
1
How many accounts are being inserted??
1
The position at where new-account 1 must be inserted
1
Enter the Account No of new-account 1
7501
Enter the Account name
Bappa Morya
Enter the address
EveryWhere
Enter the balance in account
7777777777
**** Welcome To ITD Bank ****
Menu:
1: Add Account
2: Display List
3:Withdraw Amount
4:Deposit Amount
0:Exit
2
For account 1
Account Number: 7502
 Account Name: Isha Bule
Account Balance: 85555.0
For account 2
Account Number: 7501
 Account Name: Bappa Morya
Account Balance: 7777777
For account 3
Account Number: 7503
 Account Name: Tilak Dave
Account Balance: 6533333.0
For account 4
Account Number: 7504
 Account Name: Sarthak Bule
Account Balance: 7563333
**** Welcome To ITD Bank ****
Menu:
1: Add Account
2: Display List
3:Withdraw Amount
4:Deposit Amount
0:Exit
3
Enter the account number and amount to withdraw
7503 8000
After Withdrawing the balance ammount is 6525333.0
**** Welcome To ITD Bank ****
Menu:
1: Add Account
2: Display List
3:Withdraw Amount
4:Deposit Amount
0:Exit
4
Enter the account number and amount to deposit
7502 7500
After depositing, the balance amount is 93055.0
**** Welcome To ITD Bank ****
Menu:
1: Add Account
2: Display List
3:Withdraw Amount
4:Deposit Amount
0:Exit
0

Process finished with exit code 0

          */

