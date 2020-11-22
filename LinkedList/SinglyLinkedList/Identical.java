// An iterative Java program to check if two linked lists 
// are identical or not 

//javac -d classes Identical.java  && cd classes && java Identical  && cd ..
class Identical 
{ 
    Node head;  // head of list 
  
    /* Linked list Node*/
    class Node 
    { 
        int data; 
        Node next; 
        Node(int d) { data = d; next = null; } 
    } 
  

/*    boolean areIdentical(Identical listb) 
    { 
        Node a = this.head, b = listb.head; 
        while (a != null && b != null) 
        { 
            if (a.data != b.data) 
                return false; 
            a = a.next; 
            b = b.next; 
        } 
        return (a == null && b == null); 
    } 
  */

    boolean areIdentical(Identical listb) {
      return areIdenticalRecur(this.head, listb.head);
    }
    //using recursion
    boolean areIdenticalRecur(Node a, Node b) { 
        if (a == null && b == null) 
            return true; 

        if (a != null && b != null) 
            return (a.data == b.data) && areIdenticalRecur(a.next, b.next);  
        return false; 
    } 

    void push(int new_data) 
    { 
        /* 1 & 2: Allocate the Node & 
                  Put in the data*/
        Node new_node = new Node(new_data); 
  
        /* 3. Make next of new Node as head */
        new_node.next = head; 
  
        /* 4. Move the head to point to new Node */
        head = new_node; 
    } 
  
  
    /* Driver program to test above functions */
    public static void main(String args[]) 
    { 
        Identical llist1 = new Identical(); 
        Identical llist2 = new Identical(); 
  
        /* The constructed linked lists are : 
           llist1: 3->2->1 
           llist2: 3->2->1 */
  
        llist1.push(1); 
        llist1.push(2); 
        llist1.push(3); 
  
        llist2.push(1); 
        llist2.push(2); 
        llist2.push(3); 
  
        if (llist1.areIdentical(llist2) == true) 
            System.out.println("\n\nIdentical Linked list "); 
        else
            System.out.println("\n\nNot identical Linked list"); 
  
    } 
}