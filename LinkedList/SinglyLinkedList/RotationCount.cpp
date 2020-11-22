// g++ RotationCount.cpp && ./a.out

// Count rotations in sorted and rotated linked list

#include <bits/stdc++.h> 
using namespace std; 
/* Linked list node */
struct Node { 
	int data; 
	struct Node* next; 
}; 

int countRotation(struct Node* head) 
{ 
	int count = 0; 
	int min = head->data; 
	while (head != NULL) { 
		if (min > head->data) 
			break; 
		count++; 
		head = head->next; 
	} 
	return count; 
} 

// Function to push element in linked list. 
void push(struct Node** head, int data) 
{ 
	// Allocate dynamic memory for newNode. 
	struct Node* newNode = new Node; 

	// Assign the data into newNode. 
	newNode->data = data; 

	// newNode->next assign the address of 
	// head node. 
	newNode->next = (*head); 

	// newNode become the headNode. 
	(*head) = newNode; 
} 

// Display linked list. 
void printList(struct Node* node) 
{ 
	while (node != NULL) { 
		printf("%d ", node->data); 
		node = node->next; 
	} 
} 

// Driver functions 
int main() 
{ 
	// Create a node and initialize with NULL 
	struct Node* head = NULL; 

	// push() insert node in linked list. 
	// 15 -> 18 -> 5 -> 8 -> 11 -> 12 
	push(&head, 12); 
	push(&head, 11); 
	push(&head, 8); 
	push(&head, 5); 
	push(&head, 18); 
	push(&head, 15); 

	printList(head); 
	cout << endl; 
	cout << "Linked list rotated elements: "; 

	// Function call countRotation() 
	cout << countRotation(head) << endl; 

	return 0; 
} 
