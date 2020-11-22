// javac BinaryHeap.java && java BinaryHeap

class BinaryHeap {

	public static int leftChildIndex(int index) {
		return index*2;
	}

	public static int rightChildIndex(int index) {
		return index*2+1;
	}

	public static int parentIndex(int index) {
		return index/2;
	}

    //time complexity => logn
	public static void maxHeapify(int [] heap, int heap_size, int index) {
        
        int left_child_index = leftChildIndex(index); 
        int right_child_index = rightChildIndex(index);

        int largest_index;

        if (left_child_index <= heap_size && heap[left_child_index] > heap[index]) {
        	largest_index = left_child_index;
        } else {
        	largest_index = index;
        }

        if (right_child_index <= heap_size && heap[right_child_index] > heap[largest_index]) {
        	largest_index = right_child_index;
        }

        if (largest_index != index) {
        	int temp = heap[index];
        	heap[index] = heap[largest_index];
        	heap[largest_index] = temp;
        	maxHeapify(heap, heap_size, largest_index);
        }
	}

    //time complexity => O(nlogn)
	public static void buildMaxHeap(int [] heap, int size) {
      for (int index=size/2; index>=1 ; index--) {//time complexity => O(n)
      	maxHeapify(heap, size, index);//time complexity => O(logn)
      }
	}

    //time complexity => nlogn
	public static void heapSort(int [] heap, int size) {
		
	  //buildMaxHeap(heap, size); // nlogn + nlogn = nlogn

      for (int last_index=size; last_index>1; last_index--) {
      	int temp = heap[1];
      	heap[1] = heap[last_index]; 
      	heap[last_index] = temp;

      	size--;
      	maxHeapify(heap, size, 1);
      }
	}


    //priority queue charecter
    // 1.  extract_max
    // 2. insert item
    // 3. increase key
	public static int extract_max(int [] heap, int size) { // find max heap item
		int max_item = heap[1];
		heap[1] = heap[size];
		size--;
      	maxHeapify(heap, size, 1);
		return max_item;
	}
	
	public static int insertItem(int [] heap, int heap_size, int item) {
		int i, p, t;
		heap_size++; //increase key
        heap[heap_size] = item; // insert new node
        i = heap_size;

        while(i>1 && heap[i] > heap[parentIndex(i)] ) { // increse priority
           p = parentIndex(i);
           t = heap[p];
           heap[p] = heap[i];
           heap[i]=t;
           i=p;
        }
        return heap_size;
	}

	public static void main(String[] args) {

	   // int [] heap_arr = new int[] {0,19,7,17,3,5,12,10,1,2}; 	
	   int [] heap_arr = new int[] {0,19,70,17,30,56,120,10,15,25}; 	

	   // heap_arr[1] = 19;
	   // heap_arr[2] = 7;
	   // heap_arr[3] = 17;

	   // heap_arr[2*2] = 3;
	   // heap_arr[2*2+1] = 5;

	   // heap_arr[3*2] = 12;
	   // heap_arr[3*2+1] = 10;

	   // heap_arr[4*2] = 1;
	   // heap_arr[4*2+1] = 2;

       System.out.print("Orginal Array : ");
	   for (int i=0; i<heap_arr.length ;i++ ) {
	   	 System.out.print(heap_arr[i]+" ");
	   }

	   System.out.println();
	   
	   buildMaxHeap(heap_arr, heap_arr.length - 1); // build a heap array
	   
       System.out.print("Heap Array : ");
	   for (int i=0; i<heap_arr.length ;i++ ) {
	   	 System.out.print(heap_arr[i]+" ");
	   }

	   System.out.println();	   



      // for priority queue
	   System.out.println("max item: "+extract_max(heap_arr, heap_arr.length - 1));

	   insertItem(heap_arr, heap_arr.length - 2, 60);

       System.out.print("Insert 60: ");
	   for (int i=0; i<heap_arr.length ;i++ ) {
	   	 System.out.print(heap_arr[i]+" ");
	   }

	   System.out.println();	

	   heapSort(heap_arr, heap_arr.length - 1);// for heap sort

       System.out.print("Heap Sort Array: ");
	   for (int i=0; i<heap_arr.length ;i++ ) {
	   	 System.out.print(heap_arr[i]+" ");
	   }

	   System.out.println();
	}
}