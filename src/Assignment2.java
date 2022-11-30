// Isha Bule UCE2021610
// Assignment 2 : Implementation of linear data structure in College Library maintaining records of books.
import java.util.Scanner;
class Books{  // creating book class comprising attribute
String name;
int ISBNno;
String AuthorName;
String Publication;
Books(String n,int no,String authorName,String publication) {
    this.name = n;
    this.ISBNno = no;
    this.AuthorName = authorName;
    this.Publication = publication;
}
}
class Library{  // creating library class for implementing library functions
    int num;
    Scanner sc = new Scanner(System.in);
    Library(int num){
        this.num=num;

    }

    void Search(String nameToSearch,Books books[]){
        int flag=0,i;
        for ( i=0 ; i<num;i++){    // linear search algorithm is used
           if( books[i].name.equals(nameToSearch)){
               flag=1;
               break;
           }
        }
        if(flag==1){
            System.out.println("Book found at "+(i+1)+" in list & ISBN no. is "+books[i].ISBNno);
        }else System.out.println("Book not found!!!");
    }
    int BinarySearch(Books books[]){   // binary search algo is used ,
        // to search book according to ISBN number entered by the user
        int start =0;
        int end= books.length-1;
        int mid=start + (end-start)/2;
        System.out.println("Enter the ISBN number of book to be searched ");
        int key = sc.nextInt();
        while(start<=end){
            if(books[mid].ISBNno==key){
                System.out.println("Book found at "+(mid+1));
                return mid;
            }
            if(books[mid].ISBNno<key){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
            mid = start + (end-start)/2;
        }
        System.out.println("Not found , try again!");
        return -1;
    }
    void SelectionSort(Books  books[]){
        int i,j,temp=0;
        for(i=0;i<num-1;i++) // n-1 steps will be followed throughout
            {
                for(j=i+1;j<num;j++){
                    if(books[i].ISBNno>books[j].ISBNno){
                       temp=books[i].ISBNno;
                        books[i].ISBNno=books[j].ISBNno;
                        books[j].ISBNno=temp;
                }
            }
        }    System.out.println("Sorted list of books according to ISBN no. is ");
        for(i=0;i<num;i++){
            System.out.println(books[i].ISBNno+" = "+books[i].name);
        }

    }
    void BubbleSort(Books books[]){
        int n= books.length;
        int i,j,temp;
        for(i=1;i<=n-1;i++){  // for loop for rounds during bubble sort , for n length , there are n-1 rounds
            for(j=0;j<n-i;j++){  // at each round (n-i) steps are followed
                if(books[j].ISBNno>books[j+1].ISBNno){
                    temp=books[j].ISBNno;
                    books[j].ISBNno=books[j+1].ISBNno;
                    books[j+1].ISBNno=temp;
                }
            }
        }
        System.out.println("Bubble Sorted list of books is ");
        for(int k=0;k<n;k++){
            System.out.println(books[k].ISBNno+" = "+books[k].name);
        }
    }
    void listing(Books books[]){
        for(int i=0;i<num;i++)
        {
            System.out.println("Books of "+books[i].AuthorName);
           // System.out.println(books[i].name);
                for(int j=i+1;j<num;j++) {

                    if (books[i].AuthorName.equals(books[j].AuthorName)) {

                        System.out.println(books[i].name);
                    } else System.out.println(books[i].name);
                }
        }
    }

}
public class Assignment2 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the number of books in a Library");
        int num= sc.nextInt();
        Books []books =new Books[num];
            System.out.println("Enter the book details as:");
            for(int i=0;i<num;i++){
                System.out.println("Book "+(i+1));
                System.out.println("Name:");
                String name1=sc.nextLine();
                name1=sc.nextLine();
                System.out.println("ISBN no. ");
                int ISBNno=sc.nextInt();
                System.out.println("Author Name : ");
                String Authnum=sc.nextLine();
                Authnum=sc.nextLine();
                System.out.println("Publication : ");
                String Publication= sc.nextLine() ;
                books[i]=new Books(name1,ISBNno,Authnum,Publication);
        }
        Library setBooks=new Library(num);

        int choice=0;
        do{
            System.out.println("**** Welcome To ITD Library ****");
            System.out.println("Menu: \n1: Selection Sort \n2: Bubble sort\n3:Binary search\n4:linear search\n5:List of Books\n0:exit");
            choice = sc.nextInt();
            switch(choice) {

                case 1: setBooks.SelectionSort(books);
                        System.out.println("Enter 1 if you want to continue:");
                        int cont = sc.nextInt();
                        if(cont==1){
                            continue;
                        }else break;
                case 2: setBooks.BubbleSort(books);
                        System.out.println("Enter 1 if you want to continue:");
                        cont = sc.nextInt();
                         if(cont==1){
                            continue;
                        }else
                            break;
                case 3: setBooks.BinarySearch(books);
                        System.out.println("Enter 1 if you want to continue:");
                        cont = sc.nextInt();
                        if(cont==1){
                             continue;
                        }else break;
                case 4: System.out.println("Enter the book to be searched ");
                        String name= sc.nextLine();
                        setBooks.Search(name,books);
                         System.out.println("Enter 1 if you want to continue:");
                            cont = sc.nextInt();
                             if(cont==1){
                                 continue;
                            }else break;
                case 5: setBooks.listing(books);
                             System.out.println("Enter 1 if you want to continue:");
                                 cont = sc.nextInt();
                                    if(cont==1){
                                              continue;
                                         }else break;
            }

        }while(choice!=0);

    }
}
/*
Enter the number of books in a Library
2
Enter the book details as:
Book 1
Name:
Atomic Habit
ISBN no.
444
Author Name :
James clear
Publication :
ll
Book 2
Name:
Khilli
Khilli
ISBN no.
222
Author Name :
PL deshpande
Publication :
kk
**** Welcome To ITD Library ****
Menu:
1: Selection Sort
2: Bubble sort
3:Binary search
4:linear search
5:List of Books
0:exit
1
Sorted list of books according to ISBN no. is
222 = Atomic Habit
444 = Khilli
Enter 1 if you want to continue:
1
**** Welcome To ITD Library ****
Menu:
1: Selection Sort
2: Bubble sort
3:Binary search
4:linear search
5:List of Books
0:exit
2
Bubble Sorted list of books is
222 = Atomic Habit
444 = Khilli
Enter 1 if you want to continue:
1
**** Welcome To ITD Library ****
Menu:
1: Selection Sort
2: Bubble sort
3:Binary search
4:linear search
5:List of Books
0:exit
3
Enter the ISBN number of book to be searched
22
Not found , try again!
Enter 1 if you want to continue:
1
**** Welcome To ITD Library ****
Menu:
1: Selection Sort
2: Bubble sort
3:Binary search
4:linear search
5:List of Books
0:exit
3
Enter the ISBN number of book to be searched
222
Book found at 1
Enter 1 if you want to continue:
1

*** Welcome To ITD Library ****
Menu:
1: Selection Sort
2: Bubble sort
3:Binary search
4:linear search
5:List of Books
0:exit
5
Books of James clear
Atomic Habit
Books of PL deshpande
Enter 1 if you want to continue:
0
**** Welcome To ITD Library ****
Menu:
1: Selection Sort
2: Bubble sort
3:Binary search
4:linear search
5:List of Books
0:exit
0

 */