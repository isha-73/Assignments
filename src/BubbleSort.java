public class BubbleSort {
   static void sort(int arr[]){
        int n= arr.length;
        int i,j,temp;
        for(i=1;i<=n-1;i++){  // for loop for rounds during bubble sort , for n length , there are n-1 rounds
            for(j=0;j<n-i;j++){  // at each round (n-i) steps are followed
                if(arr[j]>arr[j+1]){
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        System.out.println("Sorted array is ");
        for(int k=0;k<n;k++){
            System.out.print(arr[k]+" ");
        }

    }

    public static void main(String[] args) {
        int array[]={20,12,10,1,15,30,12};
        sort(array);
    }
}
