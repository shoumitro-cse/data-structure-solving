// javac -d classes  LinkedListEx.java && cd classes && java LinkedListEx && cd ..

import java.util.*; 
class LinkedListEx {
    
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

    public int pop() {
      Node node = head, previous = null;
      while (node.next != null) {
      	previous = node;
      	node = node.next;
      }
      int item = node.data;
      previous.next = null;
      return item;
    }

    void append(int data) {
      Node new_node = new Node(data);	
      Node node = head;
      while (node.next != null) {
      	node = node.next;
      }
      node.next = new_node;
    }

    void insertAfter(Node prev_node, int data) {
      
      Node new_node = new Node(data);
      if (prev_node == null) {
      	System.out.println("previous node can't null");
        return;
      }

      new_node.next = prev_node.next;
      prev_node.next = new_node;
    }

    void deleteNode(int item) {
      Node c_node = head, prev=null;

      if (c_node != null && c_node.data == item) {
      	 head = c_node.next;
      	 return;
      }

      while (c_node != null && c_node.data != item) {
      	prev = c_node;
      	c_node = c_node.next;
      }
      
      if (c_node == null) return; // item not found
       
      prev.next = c_node.next;
    }

    void deleteNodePosition(int position) {
        
        Node temp = head;

    	if(position == 0) {
          head = head.next;
    	}

    	for (int i=0; temp != null && i<position-1; i++) {
    		temp = temp.next;
    	}

        //If position is more than number of nodes 
    	if(temp == null || temp.next == null) return;

    	temp.next = temp.next.next;

    }

    void deleteList() {
    	head = null;
    }

    // iterative
    public int getCount2() {
    	Node temp = head;
    	int c = 0;
    	while(temp != null) {
    		temp = temp.next;
    		c++;
    	}
     return c;	
    }    

    //recursion
   public int getCountRect(Node node) {
       if (node == null) return 0;
       return 1 + getCountRect(node.next);
   }

    // for recursion
    public int getCount() {
      return getCountRect(head);
    }

    // iterative
    public boolean search(int item) {
    	Node current = head;
    	while(current != null) {
    		if (current.data == item) return true;
    		current = current.next;
    	}
      return false;	
    }


    // for recursion
    public boolean search2Rect(Node current, int item) {
       if(current == null) return false;
       if(current.data == item) return true;
       return search2Rect(current.next, item);
    }

    // for recursion
    public boolean search2(int item) {
        return search2Rect(head, item);
    }


    //Time Complexity: O(n)
    public int getNthNode(int index) {
       Node current = head;
       int count = 0;
       while(current != null) {
       	if(count == index) return current.data;
       	count++;
       	current = current.next;
       }
        /*if we get to this line, the caller was asking 
          for a non-existent element so we assert fail */
        assert(false);
       return count;
    }

   //Time Complexity: O(n)
    //recursion
    public int getNthNodeRect(Node head, int index) { 
        int count = 0;
    	if(head == null) return -1;
    	if(count == index) return head.data;
      return getNthNodeRect(head.next, index-1);
    }

    public int getNthNode2(int index) {
      return getNthNodeRect(head, index);
    }

   
   //Time Complexity: O(n) where n is the length of linked list. 
    public int printNthFromLast(int index) {
    	Node temp = head;
    	int len = 0;
    	while (temp != null) {
          len++;
          temp = temp.next;
    	}

    	if(index > len) return 0;

    	temp = head;
    	for (int i=1; i<len-index+1 ; i++)
          temp = temp.next;
        return temp.data;
    }

    
    //Time Complexity: O(n) where n is the length of linked list. 
    void printNthFromLast2(int index) {

       Node main_ptr = head, ref_ptr = head;
       int count = 0;

       if (head != null) {

       	  while (count < index) {
       	  	if (ref_ptr == null) {
       	  	  System.out.println("null value");
       	  	  return;
       	  	}
       	  	ref_ptr =  ref_ptr.next;
       	  	count ++;
       	  }

       	  if (ref_ptr == null) {
       	  	head = head.next;
       	  	if (head != null) {
       	  	   System.out.println("last data : "+ head.data);
       	    }
       	  } else {
	   	  		while(ref_ptr != null) {
	   	  	      main_ptr = main_ptr.next;
	   	  		  ref_ptr = ref_ptr.next;
	   	  		}
	   	  	   System.out.println("last data : "+ main_ptr.data);
       	    }
       }
    }

    public void prntMiddleElement() {
       Node slow_ptr = head;
       Node fast_ptr = head;
       while(fast_ptr != null && fast_ptr.next != null) {
       	fast_ptr = fast_ptr.next.next;
       	slow_ptr = slow_ptr.next;
       }
       System.out.println("Middle element : "+slow_ptr.data);
    }

    public void prntMiddleElement2() {
      Node current = head, mid = head;
      int count = 0;

      while(current != null) {
        if (count%2 == 0) {
        	mid = mid.next;
        }
        count++;
        current = current.next;
      }
	  if (mid != null) {
	    System.out.println("Middle element : "+mid.data);	
	  }
    }

	// Time Complexity: O(n)
	// Auxiliary Space: O(1)
    public int countRepeatNode(int search_key) {
    	int count = 0;
    	Node current = head;
    	while(current != null) {
    		if (current.data == search_key) {
    			count++;
    		}
          current = current.next;
    	}
      return count;
    }

    // With Recursion
    //Time Complexity: O(n)
    // int frequency = 0;
    public int countRepeat(Node head, int search_key) {
    	// if (head == null) return frequency;
    	// if(head.data == search_key) frequency++;
    	if (head == null) {
    		System.out.println("head null");
    		return 0;
    	}
    	if(head.data == search_key) 
    		return 1+countRepeat(head.next, search_key);
      return countRepeat(head.next, search_key);
    }

    public int countRepeatNode2(int search_key) {
    	return countRepeat(head, search_key);
    }


	// Time complexity: O(n). Only one traversal of the loop is needed.
	// Auxiliary Space: O(n). n is the space required to store the value in hashmap.
    public boolean loopDetect() {
        HashSet<Node> set = new HashSet<Node>();
        while(head != null) {
        	if(set.contains(head))
        		return true;
        	set.add(head);
        	head = head.next;
        }
    	return false;
    }   

    public boolean loopDetect2() {
         while(head != null) {
         	if (head.flag == 1) return true;
         	head.flag = 1;
         	head = head.next;
         }    
    	return false;
    }

	// Time complexity: O(n). 
	// Only one traversal of the loop is needed.
	// Auxiliary Space:O(1). 
	// There is no space required.
	//Implementation of Floyd’s Cycle-Finding Algorithm: 
    public boolean loopDetect3() {
    	Node slow_ptr = head, fast_ptr = head;
    	while(slow_ptr != null && fast_ptr != null && fast_ptr.next != null) {
    		slow_ptr = slow_ptr.next;
    		fast_ptr = fast_ptr.next.next;
    		if (slow_ptr == fast_ptr) return true; 
    	}
       return false;	
    }

	// Time complexity: O(n). 
	// Only one traversal of the loop is needed.
	// Auxiliary Space: O(1). 
	// There is no space required.
    public boolean loopDetect4() {
    	Node temp = new Node(-3);
    	while(head != null) {
    		if (head == null) return false;
    		if (head == temp) return true;
    		Node next = head.next;
    		head.next = temp;
    		head = next;
    		// System.out.println(head.data+" "+temp.data);
    	}
      return false;	
    }

    public void printList() {
    	Node node = head;
    	while (node != null) {
    		System.out.print(node.data + " ");
    		node = node.next;
    	}
    	System.out.println();
    }

   
	public static void main(String[] args) {
		
         LinkedListEx linkedList = new LinkedListEx();

         // linkedList.head = new Node(1);

         Node one = new Node(1);
         Node second = new Node(2);
         Node third = new Node(3);
         Node four = new Node(4);

         linkedList.head = one;
         linkedList.head.next = second;

         second.next = third;
         third.next = four;

         
         // add front node
         // Node five = new Node(5);
         // five.next = linkedList.head;
         // linkedList.head = five;
         linkedList.push(5);
         linkedList.append(7);

         linkedList.insertAfter(second, 8);

         linkedList.deleteNodePosition(1);

         // linkedList.deleteList(); //delete all list


         // linkedList.deleteNode(3);

         // int pop_item;

         // pop_item = linkedList.pop();
         // System.out.println("pop_item : "+pop_item);  

         // pop_item = linkedList.pop();
         // System.out.println("pop_item : "+pop_item);


         System.out.println("total item(I) : "+linkedList.getCount2());
         System.out.println("total item(R) : "+linkedList.getCount());

         System.out.println("search a item (I): "+linkedList.search(8));
         System.out.println("search a item (R): "+linkedList.search2(80));

         System.out.println("get Nth Node item (I): "+linkedList.getNthNode(2));
         System.out.println("get Nth Node item (R): "+linkedList.getNthNode2(3));

         System.out.println("get Nth Node last item (I): "+linkedList.printNthFromLast(3));
         linkedList.printNthFromLast2(3);

         linkedList.prntMiddleElement(); // print middle element
         linkedList.prntMiddleElement2(); // print middle element

         linkedList.push(9);
         linkedList.push(9);
         System.out.println("count repeat: "+linkedList.countRepeatNode(9));
         System.out.println("count repeat: "+linkedList.countRepeatNode2(9));

          /* Create a loop for testing */
         // linkedList.head.next.next.next.next = linkedList.head; 
         // System.out.println("Loop Detect: "+linkedList.loopDetect());
         // System.out.println("Loop Detect: "+linkedList.loopDetect2());
         // System.out.println("Loop Detect: "+linkedList.loopDetect3());
         // System.out.println("Loop Detect: "+linkedList.loopDetect4());

         linkedList.printList(); 
	}
}
