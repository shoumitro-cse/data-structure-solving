//javac QuickSort.java && java QuickSort

public class QuickSort {

   public static void quickSort(int [] arr, int low, int high) {
       if (low >= high) return;
       int p = partition(arr, low, high);
       quickSort(arr, low, p-1);
       quickSort(arr, p+1, high);
   }

   public static int partition(int [] arr, int low, int high) {
      int index, pivot, temp;
      pivot = arr[high];
      index = low - 1;
      
      for (int j=low; j<high; j++) {
      	if (arr[j]<pivot) {
      		index++;
      		temp = arr[j];
      		arr[j] = arr[index];
      		arr[index] = temp;
      	}
      }
      
      index++;
      // System.out.println(arr[index]);
      // System.out.println(arr[high]);
      temp = arr[high];
      arr[high] = arr[index];
      arr[index] = temp; 

    //    for (int i=0; i<arr.length ;i++ ) {
	   // 	 System.out.print(arr[i]+" ");
	   // }
   	//    System.out.println();

      return index;
   }
   
   public static void main(String[] args) {
	   // int [] arr = new int[] {9,2,5,3,8,6,7,4,1}; 	
	   int [] arr = new int[] {6,3,8,4,7,5}; 	

	   for (int i=0; i<arr.length ;i++ ) {
	   	 System.out.print(arr[i]+" ");
	   }
	   System.out.println();
	   
	   quickSort(arr, 0, arr.length - 1);
	   
	   for (int i=0; i<arr.length ;i++ ) {
	   	 System.out.print(arr[i]+" ");
	   }
	   System.out.println();
   }
}