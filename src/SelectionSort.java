public class SelectionSort {
    static void sort(int arr[]){
        int n= arr.length;
        int i,j,temp=0;
        for( i=0;i<n-1;i++){

            for(j=i+1;j<n;j++){

                if(arr[i]>arr[j]){

                    temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }

            }
        }
        System.out.println("Sorted array is ");
        for(int k=0;k<n;k++){
            System.out.print(arr[k]+" ");
        }
    }

    public static void main(String[] args) {
        int array[] = {15,20,1,45,10,55,100};
        sort(array);
    }
}
