// javac -d classes SwapTwoNodes.java && cd classes && java SwapTwoNodes && cd ..
// Java program to swap two given nodes of a linked list 
  
class Node 
{ 
    int data; 
    Node next; 
    Node(int d) 
    { 
        data = d; 
        next = null; 
    } 
} 
  
class SwapTwoNodes 
{ 
    Node head; // head of list 
  
    // public void swapNodes(int x, int y) { 
    //    if(x==y) return;

    //    Node px=null, cx=head;
    //    Node py=null, cy=head;

    //    // Search x and y
    //    while (cx != null && cx.data != x) {//O(n)
    //    	  px = cx;
    //    	  cx = cx.next;
    //    }
    //    while (cy != null && cy.data != y) {
    //    	  py = cy;
    //    	  cy = cy.next;
    //    }

    //    if(cx == null || cy==null) return;
       
    //    if (px != null) {
    //    	 px.next = cy;
    //    } else {
    //    	head = cy;
    //    }       
    //    if (py != null) {
    //    	 py.next = cx;
    //    } else {
    //    	head = cx;
    //    }

    //    Node t = cx.next;
    //    cx.next = cy.next;
    //    cy.next = t;

    // } 
  
    public void swapNodes(int x, int y) { 

	    Node head_ref=head; 
	    // Nothing to do if x and y are same  
	    if (x == y)  
	        return ;  
	  
	    Node a = null, b = null;  
	  
	    // search for x and y in the linked list  
	    // and store therir pointer in a and b  
	    while (head_ref.next!=null) {  
	        if ((head_ref.next).data == x) { a = head_ref;}  
	        if ((head_ref.next).data == y) { b = head_ref;}
	        head_ref = ((head_ref).next);  
	    }  
	  
	    // if we have found both a and b  
	    // in the linked list swap current  
	    // pointer and next pointer of these  
	    if (a!=null &&  b!=null) {  

		    Node temp = a.next;  
		    a.next = b.next;  
		    b.next = temp;  

		    temp = a.next.next;  
		    a.next.next = b.next.next;  
		    b.next.next = temp;
 
	    } 

    }

    /* Function to add Node at beginning of list. */
    public void push(int new_data) 
    { 
        /* 1. alloc the Node and put the data */
        Node new_Node = new Node(new_data); 
  
        /* 2. Make next of new Node as head */
        new_Node.next = head; 
  
        /* 3. Move the head to point to new Node */
        head = new_Node; 
    } 
  
    /* This function prints contents of linked list starting 
       from the given Node */
    public void printList() 
    { 
        Node tNode = head; 
        while (tNode != null) 
        { 
            System.out.print(tNode.data+" "); 
            tNode = tNode.next; 
        } 
    } 
  
    /* Driver program to test above function */
    public static void main(String[] args) 
    { 
        SwapTwoNodes llist = new SwapTwoNodes(); 
  
        /* The constructed linked list is: 
            1->2->3->4->5->6->7 */
        llist.push(7); 
        llist.push(6); 
        llist.push(5); 
        llist.push(4); 
        llist.push(3); 
        llist.push(2); 
        llist.push(1); 
  
        System.out.print("\n Linked list before calling swapNodes() "); 
        llist.printList(); 
  
        llist.swapNodes(2, 6); 
  
        System.out.print("\n Linked list after calling swapNodes() "); 
        llist.printList(); 
        System.out.println(); 
    } 
} 