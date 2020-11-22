// Remove all the Even Digit Sum Nodes from a Circular Singly Linked List

//javac -d classes RemoveAllEvenDigitSumNode.java  && cd classes && java RemoveAllEvenDigitSumNode && cd ..

class RemoveAllEvenDigitSumNode { 

  
    // Structure for a node
    static class Node
    {
        int data;
        Node next;
    };
      
    // Function to insert a node at the beginning
    // of a Circular linked list
    static Node push(Node head_ref, int data)
    {
         
        // Create a new node and make head 
        // as next of it.
        Node ptr1 = new Node();
      
        Node temp = head_ref;
        ptr1.data = data;
        ptr1.next = head_ref;
      
        // If linked list is not null then set the next of last node
        if (head_ref != null) {
            // Find the node before head and update next of it.
            while (temp.next != head_ref)
                temp = temp.next;
      
            temp.next = ptr1;
        } else
            // Point for the first node
            ptr1.next = ptr1;
      
        head_ref = ptr1;
        return head_ref;
    }
      
    // Function to delete the node from a 
    // Circular Linked list
    static void deleteNode(Node head_ref, Node del) {
        Node temp = head_ref;
      
        // If node to be deleted is head node
        if (head_ref == del)
            head_ref = del.next;
      
        // Traverse list till not found
        // delete node
        while (temp.next != del)
        {
            temp = temp.next;
        }
        // Copy the address of the node
        temp.next = del.next;
        // Finally, free the memory occupied by del
        del = null;
      
        return;
    }
      
    // Function to find the digit sum for a number
    static int digitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += (num % 10);
            num /= 10;
        }
        return sum;
    }
      
    // Function to delete all the Even Digit
    // Sum Nodes from the singly circular linked list
    static void deleteEvenDigitSumNodes(Node head) {
        Node ptr = head;
        // Traverse the list till the end
        do {
            // If the node's data is Fibonacci, delete node 'ptr'
            if (!(digitSum(ptr.data) % 2 == 1)){
                deleteNode(head, ptr);
            }
            // Point to the next node
            ptr = ptr.next;
        } while (ptr != head);
    }   

     // Function to delete all the Even Digit
    // Sum Nodes from the singly circular linked list
    static void deleteEvenParityNodes(Node head) {
        Node ptr = head;
        do {
            if (!isEvenParity(ptr.data)){
                deleteNode(head, ptr);
            }
            ptr = ptr.next;
        } while (ptr != head);
    }

    static boolean isEvenParity(int x) {

        // Parity will store the count of set bits
        int parity = 0;
         
        while (x != 0) {
            if ((x & 1) != 0) {
                parity++;
            }
            x = x >> 1;
        }
     
        if (parity % 2 == 0)
            return true;
        else
            return false;
    }
      
    // Function to print nodes in a given Circular linked list
    static void printList(Node head) {
        Node temp = head;
        if (head != null) {
            do {
                System.out.printf("%d ", temp.data);
                temp = temp.next;
            } while (temp != head);
        }
    }
      
    // Driver code
    public static void main(String[] args) {
         
        // Initialize lists as empty
        Node head = null;
      
        // Created linked list will be 9.11.34.6.13.21
        head = push(head, 21);
        head = push(head, 13);
        head = push(head, 6);
        head = push(head, 34);
        head = push(head, 11);
        head = push(head, 9);
      
        printList(head);
        System.out.println();

        deleteEvenDigitSumNodes(head);

        // deleteEvenParityNodes(head); // remove event party node
      
        printList(head);
        System.out.println();

    }
} 


/*Remove all the Even Digit Sum Nodes from a Circular Singly Linked List
Given a circular singly linked list containing N nodes, the task is to 
remove all the nodes from the list which contains elements whose digit sum is even.
Examples:

Input: CLL = 9 -> 11 -> 34 -> 6 -> 13 -> 21 
Output: 9 -> 34 -> 21 
Explanation: 
The circular singly linked list contains : 
9 -> 9 
11 -> 1 + 1 = 2 
34 -> 3 + 4 = 7 
6 -> 6 
13 -> 1 + 3 = 4 
21 -> 2 + 1 = 3 
Here, digit sum for nodes containing 11, 6 and 13 are even. 
Hence, these nodes have been deleted.
Input: 5 -> 11 -> 16 -> 21 -> 17 -> 10 
Output: 5 -> 16 -> 21 -> 10 
Explanation: 
The linked list contains two digit sum values 11 and 17. 
Hence, these nodes have been deleted.*/