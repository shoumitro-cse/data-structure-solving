// javac CircularQueue.java && java CircularQueue

class Queue {
	
	int size;
	int head, tail;
	int [] data;

	Queue(int size) {
		this.size=size;
	    data = new int[size+1]; 
	    head=0;
	    tail=0;
	}

	// Time complexity O(1)
	public void enqueue(Queue queue, int item) {
	   if ( ((queue.tail+1) % (queue.size+1)) == queue.head) {
	   	  System.out.println("Queue is full.");
	   	  return;
	   }
	   queue.data[queue.tail] = item;
	   queue.tail = (queue.tail+1) % (queue.size+1);

	}

	// Time complexity O(1)
	public int dequeue(Queue queue) {
	   if ( queue.tail == queue.head) {
	   	  System.out.println("Queue is empty.");
	   	  return -1;
	   }
	   int item = queue.data[queue.head];
	   queue.head = (queue.head+1) % (queue.size+1);
	   return item;

	}
}


public class CircularQueue {


    public static void main(String[] args) {
    	
    	Queue queue = new Queue(5);
         
        System.out.println("\nDequeue : "+queue.dequeue(queue)+"\n");

        queue.enqueue(queue, 1);
        queue.enqueue(queue, 2);
        queue.enqueue(queue, 3);
        queue.enqueue(queue, 4);
        queue.enqueue(queue, 5);

        queue.enqueue(queue, 6);
        queue.enqueue(queue, 7); 

        for (int i=0; i<=queue.size ;i++ ) {
    	   System.out.print(queue.data[i]+" ");
    	}
    	System.out.println(); 


    	System.out.println("\nhead : "+queue.head+"(this room is: "+(queue.head+1)+")");
    	System.out.println("tail : "+queue.tail+"(empty room is: "+(queue.tail+1)+")");

        System.out.println("\nDequeue : "+queue.dequeue(queue));
        System.out.println("Dequeue : "+queue.dequeue(queue));

    	System.out.println("\nhead : "+queue.head+"(this room is: "+(queue.head+1)+")");
    	System.out.println("tail : "+queue.tail+"(empty room is: "+(queue.tail+1)+")");

        queue.enqueue(queue, 6);
        queue.enqueue(queue, 7);

    	System.out.println("\nhead : "+queue.head+"(this room is: "+(queue.head+1)+")");
    	System.out.println("tail : "+queue.tail+"(empty room is: "+(queue.tail+1)+")");
    	System.out.println();

    	for (int i=0; i<=queue.size; i++ ) {
    	   System.out.print(queue.data[i]+" ");
    	}
    	System.out.println();

    }
}