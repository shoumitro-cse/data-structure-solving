// g++ Merge_two_linked_InPlace.cpp && ./a.out

// In-place Merge two linked lists without changing links of first list
#include <bits/stdc++.h> 
using namespace std; 

/* Structure for a linked list node */
struct Node { 
	int data; 
	struct Node *next; 
}; 

/* Given a reference (pointer to pointer) to the head of a list and an int,
 push a new node on the front of the list. */
void push(struct Node** head_ref, int new_data) { 
	/* allocate node */
	struct Node* new_node = (struct Node*) malloc(sizeof(struct Node)); 
	/* put in the data */
	new_node->data = new_data; 
	/* link the old list off the new node */
	new_node->next = (*head_ref); 
	/* move the head to point to the new node */
	(*head_ref) = new_node; 
} 

void swapTwo(int *a, int *b) {
   int t = *a;
   *a=*b;
   *b=t;
}

// Function to merge two sorted linked lists LL1 and LL2 without using any extra space.
// Time Complexity : O(m*n) 
void mergeLists(struct Node *a, struct Node *b) { 
	// run till either one of a or b runs out 
	while (a && b) { 
		// for each element of LL1, compare it with first element of LL2. 
		if (a->data > b->data) { 
			// swap the two elements involved if LL1 has a greater element 
			
			// swap(a->data, b->data); // built-in
			swapTwo(&a->data, &b->data); 

			struct Node *temp = b; 
			// To keep LL2 sorted, place first element of LL2 at its correct place 
			if (b->next && b->data > b->next->data) { 
				b = b->next; 
				struct Node *ptr= b, *prev = NULL; 
				// find mismatch by traversing the second linked list once 
				while (ptr && ptr->data < temp->data) { 
					prev = ptr; 
					ptr = ptr -> next; 
				} 
				// correct the pointers 
				prev->next = temp; 
				temp->next = ptr; 
			} 
		} 
		// move LL1 pointer to next element 
		a = a->next; 
	} 
} 

// Code to print the linked link 
void printList(struct Node *head) { 
	while (head) { 
		cout << head->data << "->" ; 
		head = head->next; 
	} 
	cout << "NULL" << endl; 
} 

// Driver code 
int main() {

	//a-> 2->4->7->8->10->null
	struct Node *a = NULL; 
	push(&a, 10); 
	push(&a, 8); 
	push(&a, 7); 
	push(&a, 4); 
	push(&a, 2); 

	//b-> 1->3->12->null
	struct Node *b = NULL; 
	push(&b, 12); 
	push(&b, 3); 
	push(&b, 1); 

	cout << "First: "; 
	printList(a); 

	cout << "Second: "; 
	printList(b); 
	cout << "\n"; 

	mergeLists(a, b); 

	cout << "First List: "; 
	printList(a); 

	cout << "Second List: "; 
	printList(b); 

	return 0; 
} 


/*In-place Merge two linked lists without changing links of first list
Given two sorted singly linked lists having n and m elements each, 
merge them using constant space. First n smallest elements in both the 
lists should become part of first list and rest elements should be part of
 second list. Sorted order should be maintained. We are not allowed to change 
 pointers of first linked list.

For example,

Input:
First List: 2->4->7->8->10
Second List: 1->3->12

Output: 
First List: 1->2->3->4->7
Second List: 8->10->12*/