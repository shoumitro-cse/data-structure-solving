// javac -d classes  LeftRightRotation.java && cd classes && java LeftRightRotation && cd ..

class LeftRightRotation {

  // Here Time complexity O(d*n) 
   public static void leftRotation(int [] arr, int d) {
     for(int i=0; i<d; i++) {
       int first = arr[0], j;
       for(j=0; j<arr.length-1; j++) {
         arr[j] = arr[j+1];
       }
       arr[j] = first;
     }
   }
     // Here Time complexity O(d*n) 
   public static void rigthRotation(int [] arr, int d) {
     for(int i=0; i<d; i++) {
       int last = arr[arr.length-1], j;
       for(j=arr.length-1; j>0; j--) {
         arr[j] = arr[j-1];
       }
       arr[j] = last;
     }
   }


  //A Juggling Algorithm
   // Time complexity : O(n)
   // Auxiliary Space : O(1)
  public static void leftRotate(int arr[], int d) { 

    int n = arr.length;// n =6
    //System.out.println("n : "+n);
    for (int i = 0; i < d; i++) { 

      /*
      arr[1,2,3,4,5,6]
       d=2
       loop1:
         first = 1
         while:
           3 2 3 4 5 6
           3 2 5 4 5 6
         end
         3 2 5 4 first=1 6
       loop2:
         first = 2
         while:
           3 4 5 4 1 6
           3 4 5 6 1 6
         end
         3 4 5 6 1 first=2 
      */

      int first = arr[i];
      int j = i; 

      while (true) {

        int k = j + d; 
        // System.out.println("replaceIndex(j,k) : ("+j+", "+k+")");
        
        if (k >= n) {
          // System.out.println("exit. it can't replace  => (j,k) : ("+j+", "+k+")");
          // System.out.println(j+" index value replace with first = "+first);
          k = k - n;
        }
        
        if (k == i) {
         // System.out.println("break...");
          break;
        }

        arr[j] = arr[k]; 
        j = k;

      } 
      arr[j] = first;
    } 
  } 

/*Reversal algorithm for array rotation
  Method 4 (The Reversal Algorithm) :
Algorithm : 
rotate(arr[], d, n)
  reverse(arr[], 1, d) ;
  reverse(arr[], d + 1, n);
  reverse(arr[], 1, n);

 Time Complexity : O(n)*/
 public static void leftRotate2(int arr[], int d) { 
      
      if(d == 0) return;

      int n = arr.length;
      d = d % n;

      rotate(arr, 0, d-1); 
      rotate(arr, d, n-1); 
      rotate(arr, 0, n-1); 
  }

  public static void rotate(int arr[], int start, int end) {
     int temp;
     while (start < end) {
       temp = arr[start];
       arr[start] = arr[end];
       arr[end] = temp;
       start++;
       end--;
     }
  } 

   
   public static void main(String[] arg) {
     int d = 2;
     int [] arr = new int[] {1,2,3,4,5,6};
     
     System.out.println("Orginal Array :");
     for(int i=0; i<arr.length; i++)  {
       System.out.print(arr[i]+" ");
     }
     System.out.println();
     
     //leftRotation(arr, d); // array left roation
     // leftRotate(arr, d);
     leftRotate2(arr, d);
     
     System.out.println("Array Left Roation By "+d+" Times : ");
     for(int i=0; i<arr.length; i++)  {
       System.out.print(arr[i]+" ");
     }
     System.out.println();
     
          
     rigthRotation(arr, d); // array rigth roation
     System.out.println("Array Right Roation By "+d+" Times : ");
     for(int i=0; i<arr.length; i++)  {
       System.out.print(arr[i]+" ");
     }
     System.out.println();
     
   }
}
