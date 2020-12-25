// Program for linked implementation of complete binary tree 

// g++ CompleteBinaryTree.cpp && ./a.out

#include <bits/stdc++.h>
using namespace std;

// For Queue Size 
#define SIZE 50 

// A tree Node 
class Node 
{ 
	public:
	int data; 
	Node *right,*left; 
}; 

// A queue Node 
class Queue 
{ 
   public:
	int front, rear; 
	int size; 
	Node**array; 
}; 

// A utility function to create a new tree Node 
Node* newNode(int data) 
{ 
	Node* temp = new Node();
	temp->data = data; 
	temp->left = temp->right = NULL; 
	return temp; 
} 

// A utility function to create a new Queue 
Queue* createQueue(int size) 
{ 
	Queue* queue = new Queue(); 

	queue->front = queue->rear = -1; 
	queue->size = size; 

	queue->array = new Node*[queue->size * sizeof( Node* )]; 

	int i; 
	for (i = 0; i < size; ++i) 
		queue->array[i] = NULL; 

	return queue; 
} 

// Standard Queue Functions 
int isEmpty(Queue* queue) 
{ 
	return queue->front == -1; 
} 

int isFull(Queue* queue) { 
	return queue->rear == queue->size - 1; 
} 

int hasOnlyOneItem(Queue* queue) { 
	return queue->front == queue->rear; 
} 

void Enqueue(Node *root, Queue* queue) 
{ 
	if (isFull(queue)) 
		return; 

	queue->array[++queue->rear] = root; 

	if (isEmpty(queue)) 
		++queue->front; 
} 

Node* Dequeue(Queue* queue) 
{ 
	if (isEmpty(queue)) 
		return NULL; 

	Node* temp = queue->array[queue->front]; 

	if (hasOnlyOneItem(queue)) 
		queue->front = queue->rear = -1; 
	else
		++queue->front; 

	return temp; 
} 

Node* getFront(Queue* queue) { 
	return queue->array[queue->front]; 
} 

// A utility function to check if a tree Node
// has both left and right children 
int hasBothChild(Node* temp) 
{ 
	return temp && temp->left && temp->right; 
} 

// Function to insert a new Node in complete binary tree 
void insert(Node **root, int data, Queue* queue) { 
	// Create a new Node for given data 
	Node *temp = newNode(data); 
	// If the tree is empty, initialize the root with new Node. 
	if (!*root) {
		*root = temp; 
	} else { 
		// get the front Node of the queue. 
		Node* front = getFront(queue); 
		// If the left child of this front Node doesn’t exist, set the left child as the new Node 
		if (!front->left) 
			front->left = temp; 
		// If the right child of this front Node doesn’t exist, set the 
		// right child as the new Node 
		else if (!front->right) 
			front->right = temp; 
		// If the front Node has both the left child and right child, Dequeue() it. 
		if (hasBothChild(front)) 
			Dequeue(queue); 
	} 
	// Enqueue() the new Node for later insertions 
	Enqueue(temp, queue); 
} 

// Standard level order traversal to test above function 
void levelOrder(Node* root) {

	Queue* queue = createQueue(SIZE); 

	Enqueue(root, queue); 

	while (!isEmpty(queue)) { 
		Node* temp = Dequeue(queue); 

		cout<<temp->data<<" "; 

		if (temp->left) 
			Enqueue(temp->left, queue); 

		if (temp->right) 
			Enqueue(temp->right, queue); 
	} 
} 

// Driver program to test above functions 
int main() {

	Node* root = NULL; 
	Queue* queue = createQueue(SIZE); 
	int i; 

	for(i = 1; i <= 12; ++i) {
		insert(&root, i, queue); 
	}

	printf("\n\n");
	levelOrder(root); 
	printf("\n");

	return 0; 
} 



/*
Linked complete binary tree & its creation

A complete binary tree is a binary tree where each level ‘l’ except the last has 2^l nodes 
and the nodes at the last level are all left-aligned. Complete binary trees are mainly used 
in heap-based data structures. 
The nodes in the complete binary tree are inserted from left to right in one level at a time. 
If a level is full, the node is inserted in a new level.


Below are some complete binary trees. 
 
       1
      / \
     2   3

        1
       / \
      2   3
     / \  / 
    4  5 6

Below binary trees are not complete:  
 

     1
    / \
   2   3
  /    /
  4   5

       1
      / \
     2   3
    / \  /
   4  5 6
  /
 7*/