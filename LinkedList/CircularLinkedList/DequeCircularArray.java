// Implementation of Deque using circular array
// javac -d classes DequeCircularArray.java  && cd classes && java DequeCircularArray && cd ..

// A structure to represent a Deque 
class Deque 
{ 
	static final int MAX = 100; 
	int arr[]; 
	int front; 
	int rear; 
	int size; 
	
	public Deque(int size) { 
		arr = new int[MAX]; 
		front = -1; 
		rear = 0; 
		this.size = size; 
	} 

	/*// Operations on Deque: 
	void insertfront(int key); 
	void insertrear(int key); 
	void deletefront(); 
	void deleterear(); 
	bool isFull(); 
	bool isEmpty(); 
	int getFront(); 
	int getRear();*/

	// Checks whether Deque is full or not. 
	boolean isFull() { 
		return ((front == 0 && rear == size-1)|| front == rear+1); 
	} 

	// Checks whether Deque is empty or not. 
	boolean isEmpty () { 
		return (front == -1); 
	} 

	// Inserts an element at front 
	void insertfront(int key) { 
		// check whether Deque if full or not 
		if (isFull()) { 
			System.out.println("Overflow"); 
			return; 
		} 
		// If queue is initially empty 
		if (front == -1) { 
			front = 0; 
			rear = 0; 
		} else if (front == 0) { // front is at first position of queue 
			front = size - 1 ; 
		} else { // decrement front end by '1' 
			front = front-1; 
		}
		// insert current element into Deque 
		arr[front] = key ; 
	} 

	// function to inset element at rear end of Deque. 
	void insertrear(int key) {

		if (isFull()) { 
			System.out.println(" Overflow "); 
			return; 
		} 
		// If queue is initially empty 
		if (front == -1) { 
			front = 0; 
			rear = 0; 
		} else if (rear == size-1) {// rear is at last position of queue 
			rear = 0; 
		} else {// increment rear end by '1' 
			rear = rear+1; 
		}
		// insert current element into Deque 
		arr[rear] = key ; 
	} 

	// Deletes element at front end of Deque 
	void deletefront() { 
		// check whether Deque is empty or not 
		if (isEmpty()) { 
			System.out.println("Queue Underflow\n"); 
			return ; 
		} 
		if (front == rear) { // Deque has only one element 
			front = -1; 
			rear = -1; 
		} else {
			if (front == size -1) { // back to initial position 
				front = 0; 
			} else { // increment front by '1' to remove current front value from Deque 
				front = front+1; 
			}
	    }			
	} 

	// Delete element at rear end of Deque 
	void deleterear() { 
		if (isEmpty()) { 
			System.out.println(" Underflow"); 
			return ; 
		} 
		// Deque has only one element 
		if (front == rear) { 
			front = -1; 
			rear = -1; 
		} else if (rear == 0) {
			rear = size-1; 
		} else {
			rear = rear-1; 
		}
	} 

	// Returns front element of Deque 
	int getFront() { 
		// check whether Deque is empty or not 
		if (isEmpty()) { 
			System.out.println(" Underflow"); 
			return -1 ; 
		} 
		return arr[front]; 
	} 

	// function return rear element of Deque 
	int getRear() { 
		// check whether Deque is empty or not 
		if(isEmpty() || rear < 0) { 
			System.out.println(" Underflow\n"); 
			return -1 ; 
		} 
		return arr[rear]; 
	} 

} 

class DequeCircularArray {

	// Driver program to test above function 
	public static void main(String[] args) { 
		
		Deque dq = new Deque(5); 
		
		System.out.println("Insert element at rear end : 5 "); 
		dq.insertrear(5); 
		
		System.out.println("insert element at rear end : 10 "); 
		dq.insertrear(10); 
		
		System.out.println("get rear element : "+ dq.getRear()); 
		
		dq.deleterear(); 
		System.out.println("After delete rear element new rear become : " + dq.getRear()); 
		
		System.out.println("inserting element at front end"); 
		dq.insertfront(15); 
		
		System.out.println("get front element: " +dq.getFront()); 
		
		dq.deletefront(); 
		
		System.out.println("After delete front element new front become : " + + dq.getFront()); 
		
	} 

}

/*Implementation of Deque using circular array
Last Updated: 20-04-2018
Deque or Double Ended Queue is a generalized version of Queue data structure that allows insert and delete at both ends.In previous post we had discussed introduction of deque. Now in this post we see how we implement deque Using circular array.
Operations on Deque:
Mainly the following four basic operations are performed on queue:
insetFront(): Adds an item at the front of Deque.
insertRear(): Adds an item at the rear of Deque.
deleteFront(): Deletes an item from front of Deque.
deleteRear(): Deletes an item from rear of Deque.

In addition to above operations, following operations are also supported
getFront(): Gets the front item from queue.
getRear(): Gets the last item from queue.
isEmpty(): Checks whether Deque is empty or not.
isFull(): Checks whether Deque is full or not.


Circular array implementation deque
For implementing deque, we need to keep track of two indices, front and rear. We enqueue(push) an item at the rear or the front end of qedue and dequeue(pop) an item from both rear and front end.
Working
1. Create an empty array ‘arr’ of size ‘n’
initialize front = -1 , rear = 0
Inserting First element in deque, at either front or rear will lead to the same result.



After insert Front Points = 0 and Rear points = 0
Insert Elements at Rear end

a). First we check deque if Full or Not 
b). IF Rear == Size-1 
       then reinitialize Rear = 0 ;
    Else increment Rear by '1'
    and push current key into Arr[ rear ] = key 
Front remain same.  



Insert Elements at Front end

a). First we check deque if Full or Not
b). IF Front == 0 || initial position, move Front
                     to points last index of array
       front = size - 1
    Else decremented front by '1' and push 
         current key into Arr[ Front] = key 
Rear remain same. 


Delete Element From Rear end

a). first Check deque is Empty or Not
b).  If deque has only one element
        front = -1 ; rear =-1 ;
    Else IF Rear points to the first index of array
         it's means we have to move rear to points 
         last index [ now first inserted element at 
         front end become rear end ]  
            rear = size-1 ;
    Else || decrease rear by '1'  
            rear = rear-1;


Delete Element From Front end

a). first Check deque is Empty or Not
b).  If deque has only one element
            front = -1 ; rear =-1 ;
    Else IF front points to the last index of the array
         it's means we have no more elements in array so 
          we move front to points first index of array
            front = 0 ;
    Else || increment Front by '1'  
            front = front+1;*/