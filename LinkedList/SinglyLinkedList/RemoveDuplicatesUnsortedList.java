// Java program to remove duplicates from unsorted  
// javac -d classes RemoveDuplicatesUnsortedList.java && cd classes && java RemoveDuplicatesUnsortedList && cd ..
 
import java.util.HashSet; 

class RemoveDuplicatesUnsortedList { 
  
    static Node head; 
  
    static class Node { 
  
        int data; 
        Node next; 
  
        Node(int d) { 
            data = d; 
            next = null; 
        } 
    } 
  
    // //Time Complexity: O(n^2)
    // void remove_duplicates() { 
    //   Node ptr1=null, ptr2=null;
    //   ptr1=head;
    //   while(ptr1 != null && ptr1.next != null) { //O(n)
    //     ptr2=ptr1;
    //     while(ptr2.next != null) { //O(n)
    //       if(ptr1.data == ptr2.next.data) {
    //           ptr2.next=ptr2.next.next;
    //           System.gc();
    //       } else {
    //         ptr2 = ptr2.next;
    //       }
    //     }
    //     ptr1 = ptr1.next;
    //   }
    // } 

   //Time Complexity: O(n) on average (assuming that hash table access time is O(1) on average). 
    void remove_duplicates() { 
      Node current = head, prev=null;
      HashSet<Integer> set = new HashSet<Integer>();//0(1)
      while(current != null) { //O(n)
        int value = current.data;
        if (set.contains(value)) {
            prev.next=current.next;
        } else {
            set.add(value);
            prev = current;
        }
        current = current.next;
      }
    }
  
    void printList(Node node) { 
        while (node != null) { 
            System.out.print(node.data + " "); 
            node = node.next; 
        } 
    } 
  
    public static void main(String[] args) { 
        RemoveDuplicatesUnsortedList list = new RemoveDuplicatesUnsortedList(); 
        list.head = new Node(10); 
        list.head.next = new Node(12); 
        list.head.next.next = new Node(11); 
        list.head.next.next.next = new Node(11); 
        list.head.next.next.next.next = new Node(12); 
        list.head.next.next.next.next.next = new Node(11); 
        list.head.next.next.next.next.next.next = new Node(10); 
  
        System.out.println("Linked List before removing duplicates : \n "); 
        list.printList(head); 
  
        list.remove_duplicates(); 
        System.out.println(""); 
        System.out.println("Linked List after removing duplicates : \n "); 
        list.printList(head); 
        System.out.println(""); 
    } 
} 
