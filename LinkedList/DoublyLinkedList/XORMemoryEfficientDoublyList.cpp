/* XOR Linked List – A Memory Efficient Doubly Linked List | Set 2 */
// g++ XORMemoryEfficientDoublyList.cpp && ./a.out
#include <stdio.h>
#include <stdlib.h>
#include <inttypes.h>

// Node structure of a memory efficient doubly linked list
struct Node {
	int data;
	struct Node* npx; /* XOR of next and previous node */
};

/* returns XORed value of the node addresses */
struct Node* XOR (struct Node *a, struct Node *b) {
	return (struct Node*) ((uintptr_t) (a) ^ (uintptr_t) (b));
}

/* Insert a node at the beginning of the 
XORed linked list and makes the newly inserted node as head */
void insert(struct Node **head_ref, int data) {
	// Allocate memory for new node
	struct Node *new_node = (struct Node *) malloc (sizeof (struct Node) );
	new_node->data = data;
	/* Since new node is being inserted at the 
	beginning, npx of new node will always be XOR of current head and NULL */
	new_node->npx = *head_ref;
	/* If linked list is not empty, then npx of 
	current head node will be XOR of new node and node next to current head */
	if (*head_ref != NULL) {
		// *(head_ref)->npx is XOR of NULL and next. So if we do XOR of it with NULL, we get next
		(*head_ref)->npx = XOR(new_node, (*head_ref)->npx);
		
/*		if((*head_ref)->npx)
		   printf("%d\n",(*head_ref)->npx);*/
	}
	// Change head
	*head_ref = new_node;
}

// prints contents of doubly linked list in forward direction
void printList (struct Node *head) {

	struct Node *curr = head;
	struct Node *prev = NULL;
	struct Node *next;

	printf ("Following are the nodes of Linked List: \n");
	while (curr != NULL) {
		// print current node
		printf ("%d ", curr->data);
		// get address of next node: curr->npx is 
		// next^prev, so curr->npx^prev will be next^prev^prev which is next
		next = XOR (prev, curr->npx);
		// update prev and curr for next iteration
		prev = curr;
		curr = next;
	}
	printf ("\n");	


    Node* rev_curr=prev; 
    Node* rev_prev=NULL;
	printf ("Reverse Order Print Linked List: \n");
	while (rev_curr != NULL) {
		// print current node
		printf ("%d ", rev_curr->data);
		// get address of next node: curr->npx is 
		// next^prev, so curr->npx^prev will be next^prev^prev which is next
		next = XOR (rev_prev, rev_curr->npx);
		// update prev and curr for next iteration
		rev_prev = rev_curr;
		rev_curr = next;
	}
	printf ("\n");

}


int main () {

	/* Create following Doubly Linked List head-->40<-->30<-->20<-->10 */
	struct Node *head = NULL;
	insert(&head, 10);
	insert(&head, 20);
	insert(&head, 30);
	insert(&head, 40);

	// print the created list
	printList (head);

	return (0);
}


/*
XOR List Representation:
Let us call the address variable in XOR representation npx (XOR of next and previous)

Node A:
npx = 0 XOR add(B) // bitwise XOR of zero and address of B

Node B:
npx = add(A) XOR add(C) // bitwise XOR of address of A and address of C

Node C:
npx = add(B) XOR add(D) // bitwise XOR of address of B and address of D

Node D:
npx = add(C) XOR 0 // bitwise XOR of address of C and 0

Traversal of XOR Linked List:
We can traverse the XOR list in both forward and reverse direction. 
While traversing the list we need to remember the address of the previously 
accessed node in order to calculate the next node’s address. 

For example when 
we are at node C, we must have address of B. XOR of add(B) and npx of C gives us the add(D).

The reason is simple: npx(C) is “add(B) XOR add(D)”. 
If we do xor of npx(C) with add(B), we get the result as “add(B) XOR add(D) XOR add(B)” 
which is “add(D) XOR 0” which is “add(D)”. So we have the address of next node. 
Similarly we can traverse the list in backward direction.

We have covered more on XOR Linked List in the following post.








XOR Linked List – A Memory Efficient Doubly Linked List | Set 1

An ordinary Doubly Linked List requires space for two address fields to store 
the addresses of previous and next nodes. A memory efficient version of Doubly
 Linked List can be created using only one space for address field with every node.
  This memory efficient Doubly Linked List is called XOR Linked List or Memory Efficient 
  as the list uses bitwise XOR operation to save space for one address. 
  In the XOR linked list, instead of storing actual memory addresses, 
every node stores the XOR of addresses of previous and next nodes.

*/


