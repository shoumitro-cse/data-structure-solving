//javac MergeSortAlogrithm.java && java MergeSortAlogrithm

// This algorithm is divide and conquer algorithm. time complexity O(nlogn)
public class MergeSortAlogrithm {

	public static void mergeSort(int [] arr, int left, int right) {
        
	  if(left>=right) return; // base case
	    
      int mid = (left + right)/2;

      mergeSort(arr, left, mid);
      mergeSort(arr, mid+1, right);

      merge(arr, left, mid, right);
	}

	public static void merge(int [] arr, int left, int mid, int right) {

	   //System.out.println("in");

       int left_arr_size = mid - left + 1;
       int right_arr_size = right - mid;

       int [] L = new int[left_arr_size];
       int [] R = new int[right_arr_size];

       for (int i=0; i<left_arr_size ; i++) {
       	 L[i]=arr[left+i];
       }
       for (int j=0; j<right_arr_size ; j++) {
       	 R[j]=arr[mid+1+j];
       }

       int k=left, i=0, j=0;

       while(i<left_arr_size && j<right_arr_size) {
       	 if(L[i] <= R[j]) {
       	 	arr[k] = L[i];
       	 	i++;
       	 } else {
       	 	arr[k] = R[j];
       	 	j++;
       	 }
       	 k++;
       }
      
      while(i<left_arr_size) {
        arr[k] = L[i];
        i++;
        k++;
      }

      while(j<right_arr_size) {
      	arr[k] = R[j];
      	j++;
      	k++;
      }

	}
	
	public static void main(String[] args) {

	   int [] arr = new int[] {9,2,5,3,8,6,7,4,1}; 	

	   for (int i=0; i<arr.length ;i++ ) {
	   	 System.out.print(arr[i]+" ");
	   }
	   System.out.println();
	   
	   mergeSort(arr, 0, arr.length - 1);
	   
	   for (int i=0; i<arr.length ;i++ ) {
	   	 System.out.print(arr[i]+" ");
	   }
	   System.out.println();
	}
}