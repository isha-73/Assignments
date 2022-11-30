import java.util.*;
public class QuickSort {
    static void quickSort(int ar[],int start,int end){
        // base case
        if(start>=end){
            return ;
        }
        int p= partition(ar,start,end); // p is pivote-index
        // sorting left of p
        quickSort(ar,start,p-1);
        // sorting right of p
        quickSort(ar,p+1,end);
    }
    static int partition(int ar[],int s,int e) {

        int pivote = ar[s];
        int cnt = 0;
        for (int i = s + 1; i <= e; i++) {
            if (ar[i] <= pivote) {
                cnt++;
            }}
            int pivoteIndex = s + cnt;
            int temp = 0;
            temp = ar[pivoteIndex];
            ar[pivoteIndex] = ar[s];
            ar[s] = temp;

            // considering right and left partition
            int i = s;
            int j = e;

            while (i < pivoteIndex && j > pivoteIndex) {

                while (ar[i] < pivote) {
                    i++;
                }
                while (ar[j] > pivote) {
                    j--;
                }
                if (i < pivoteIndex && j > pivoteIndex) {
                    temp = ar[j];
                    ar[j] = ar[i];
                    ar[i] = temp;
                    i++;
                    j--;
                }

            }
            return pivoteIndex;
        }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array");
        int n = sc.nextInt();
        int ar[] = new int[n];
        System.out.println("Enter the elements of array");
        for (int i = 0; i < n; i++) {
            ar[i] = sc.nextInt();
        }
        quickSort(ar,0,n-1);
        System.out.println("Sorted array is :");
        for(int i = 0; i < n; i++) {
            System.out.print(ar[i] + " ");
        }
    }

    }
