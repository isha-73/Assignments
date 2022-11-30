public class MergeSort {
    static void merge(int ar[],int s,int e){
        int mid=s+(e-s)/2;
        int len1=mid-s+1;
        int len2=e-mid;
        int first[]=new int[len1];
        int second[]=new int[len2];
        // copy first and second arrays
        int mainArrayIndex=s;
        for(int i=0;i<len1;i++){
            first[i]=ar[mainArrayIndex];
            mainArrayIndex++;
        }
        mainArrayIndex = mid+1;
        for(int i=0;i<len2;i++){
            second[i]=ar[mainArrayIndex];
            mainArrayIndex++;
        }
        int index1=0;
        int index2=0;
        mainArrayIndex=s;
        while(index1<len1&&index2<len2){
            if(first[index1]<second[index2]){
                ar[mainArrayIndex++] = first[index1++];
            }
            else ar[mainArrayIndex++] = second[index2++];
        }
        while(index1<len1)
        {
            ar[mainArrayIndex++] = first[index1++];
        }
        while(index2<len2){
            ar[mainArrayIndex++] = second[index2++];
        }
    }
    static void mergeSort(int arr[],int start,int end){
        //base case
        if(start>=end){
            return;
        }
        int mid=start+(end-start)/2;
        // sorting left part
        mergeSort(arr,start,mid);
        //sorting right part
        mergeSort(arr,mid+1,end);
        // merge both
        merge(arr,start,end);
    }


    public static void main(String[] args) {
        int array[]={2,56,12,11,47,23,20,5,1,0};
        int len=array.length;
        mergeSort(array,0,len-1);
        System.out.println("Sorted array is ");
        for(int i=0;i<len;i++){
            System.out.print(array[i]+" ");
        }
    }
}
