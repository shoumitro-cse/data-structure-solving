// javac -d classes  LinkedListMap.java && cd classes && java LinkedListMap && cd ..

class LinkedListMap {

    Node head=null;

    static class Node {

    	int data, flag;
    	Node next;
    	Node(int data) {
          this.data = data;
          next = null;
          flag = 0;
    	}
    }

   //Time complexity O(1)
    void push(int data) {
      Node node = new Node(data);
      node.next = head;
      head = node;
    } 

    public int countNode(Node node) {
    	int count = 1;
    	Node current = node;
    	while(current.next != node) {
    		count++;
    		current = current.next;
    	}
     return count;
    }

    //Find length of loop in linked list
	// Time complexity:O(n).
	// Only one traversal of the linked list is needed.
	// Auxiliary Space:O(1).
	// As no extra space is required.
    public int countNodesinLoop() {
    	Node slow_ptr=head, fast_prt=head;
    	while(slow_ptr != null && fast_prt != null && fast_prt.next != null) {
           slow_ptr = slow_ptr.next;
           fast_prt = fast_prt.next.next;
           if(slow_ptr == fast_prt)
           	return countNode(slow_ptr);
    	}
      return 0;
    }

    public static void main(String[] args) {
    	LinkedListMap list = new LinkedListMap();

    	list.head = new Node(1);
    	list.head.next = new Node(2);
    	list.head.next.next = new Node(3);
    	list.head.next.next.next = new Node(4);
    	list.head.next.next.next.next = new Node(5);


        // loop 2, 3, 4, 5 node
    	list.head.next.next.next.next.next = list.head.next;
    	System.out.println(list.countNodesinLoop());  //Find length of loop in linked list

    }

}