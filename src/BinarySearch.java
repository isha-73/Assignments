import java.util.Scanner;
public class BinarySearch {
    static Scanner sc = new Scanner(System .in);
    static int binarySearch(int arr[]){
        int start =0;
        int end= arr.length-1   ;
        int mid=start + (end-start)/2;
        System.out.println("Enter the number to be searched in this array");
       int key = sc.nextInt();
        while(start<=end){
            if(arr[mid]==key){
                return mid;
            }
            if(arr[mid]<key){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
            mid = start + (end-start)/2;
        }
        return -1;
    }
    public static void main(String[] args) {
        int array[]={22,30,32,40,45,60,62,70};
        System.out.println("Program of Binary Search !!!");
        int return1 = binarySearch(array);
        System.out.println("The number to be searched is at index "+return1);

    }
}
