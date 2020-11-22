// Construct a Maximum Sum Linked List out of two Sorted Linked Lists having some Common nodes
//javac -d classes MaxSumJoinTwoList.java  && cd classes && java MaxSumJoinTwoList && cd ..

class MaxSumJoinTwoList 
{ 
    Node head;  // head of list 
  
    /* Linked list Node*/
    class Node 
    { 
        int data; 
        Node next; 
        Node(int d) { 
            data = d; 
            next = null; 
        } 
    } 
  
    // Method to adjust pointers and print final list 
    // Time complexity: O(n) where n is the length of bigger linked list
    // Auxiliary space: O(1)
    void finalMaxSumJoinTwoListList(Node list1, Node list2) { 
        Node result = null; 
        /* assigning pre and cur to head  of the linked list */
        Node pre1 = list1, curr1 = list1; 
        Node pre2 = list2, curr2 = list2; 
  
        /* Till either of current pointers is not null execute the loop */
        while (curr1 != null || curr2 != null) { 
            // Keeping 2 local variables at the start of every 
            // loop run to keep track of the sum between pre 
            // and cur reference elements. 
            int sum1 = 0, sum2 = 0; 
  
            //Linked List 1 : 1->3->30->90->110->120->NULL 
            //Linked List 2 : 0->3->12->32->90->100->120->130->NULL 
            // output: 1 3 12 32 90 110 120 130
            while (curr1 != null && curr2 != null && curr1.data != curr2.data) { 
  
                if (curr1.data<curr2.data) { 
                    sum1 += curr1.data; 
                    curr1 = curr1.next; 
                    // System.out.println(sum1);
                }  else { 
                    sum2 += curr2.data; 
                    curr2 = curr2.next; 
                    // System.out.println(sum2);
                } 
            } 
  
            // If either of current pointers becomes null carry on the sum calculation for other one. 
            if (curr1 == null) { 
                while (curr2 != null) { 
                    sum2 += curr2.data; 
                    curr2 = curr2.next; 
                    // System.out.println(sum2);
                } 
            } 
            if (curr2 == null) { 
                while(curr1 != null) { 
                    sum1 += curr1.data; 
                    curr1 = curr1.next; 
                } 
            } 
            // First time adjustment of resultant head based on the maximum sum. 
            if (pre1 == list1 && pre2 == list2) {
                result = (sum1 > sum2) ? pre1 : pre2; //result=pre1
            } else { 
                if (sum1 > sum2) {
                    pre2.next = pre1.next; // join two list and make result list
                } else {
                    pre1.next = pre2.next; // join two list and make result list
                }
            } 
            // Adjusting previous pointers 
            pre1 = curr1; 
            pre2 = curr2; 
            // If curr1 is not NULL move to the next. 
            if (curr1 != null) {
                curr1 = curr1.next; 
            }
            // If curr2 is not NULL move to the next. 
            if (curr2 != null) {
                curr2 = curr2.next; 
            }
        } 
  
        while (result != null) //result: 1 3 12 32 90 110 120 130
        { 
            System.out.print(result.data + " "); 
            result = result.next; 
        } 
        System.out.println(); 
    } 
  
    /*  Inserts a node at start of linked list */
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
        MaxSumJoinTwoList llist1 = new MaxSumJoinTwoList(); 
        MaxSumJoinTwoList llist2 = new MaxSumJoinTwoList(); 
  
        //Linked List 1 : 1->3->30->90->110->120->NULL 
        //Linked List 2 : 0->3->12->32->90->100->120->130->NULL 
        // output: 1 3 12 32 90 110 120 130

        llist1.push(120); 
        llist1.push(110); 
        llist1.push(90); 
        llist1.push(30); 
        llist1.push(3); 
        llist1.push(1); 
  
        llist2.push(130); 
        llist2.push(120); 
        llist2.push(100); 
        llist2.push(90); 
        llist2.push(32); 
        llist2.push(12); 
        llist2.push(3); 
        llist2.push(0); 
  
        llist1.finalMaxSumJoinTwoListList(llist1.head, llist2.head); 
        // output: 1 3 12 32 90 110 120 130
    } 
}



/*Construct a Maximum Sum Linked List out of two Sorted Linked Lists having some Common nodes
Given two sorted linked lists, construct a linked list that contains maximum sum path
 from start to end. The result list may contain nodes from both input lists.
  When constructing the result list, we may switch to the other input list only at the point of 
  intersection (which mean the two node with the same value in the lists). 
  You are allowed to use O(1) extra space.

Input:
List1 =  1->3->30->90->120->240->511
List2 =  0->3->12->32->90->125->240->249

Output: Following is maximum sum linked list out of two input lists
list =  1->3->12->32->90->125->240->511
we switch at 3 and 240 to get above maximum sum linked list*/
