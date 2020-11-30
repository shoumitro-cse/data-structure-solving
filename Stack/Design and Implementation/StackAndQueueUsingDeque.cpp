// Implement Stack and Queue using Deque. Here Deque use doubly linked list

// g++ StackAndQueueUsingDeque.cpp && ./a.out

#include <bits/stdc++.h> 
using namespace std; 

// structure for a node of Deque 
struct Node { 
	int value; 
	Node* next; 
	Node* prev; 
}; 

// Implementation of Deque class 
class Deque { 
private: 

	// pointers to head and tail of Deque 
	Node* head; 
	Node* tail; 

public: 
	// constructor 
	Deque() { 
		head = tail = NULL; 
	} 

	// if list is empty 
	bool isEmpty() 
	{ 
		if (head == NULL) 
			return true; 
		return false; 
	} 

	// count the number of nodes in list 
	int size() 
	{ 
		// if list is not empty 
		if (!isEmpty()) { 
			Node* temp = head; 
			int len = 0; 
			while (temp != NULL) { 
				len++; 
				temp = temp->next; 
			} 
			return len; 
		} 
		return 0; 
	} 

	// insert at the first position 
	void insert_first(int element) 
	{ 
		// allocating node of Node type 
		Node* temp = new Node[sizeof(Node)]; 
		temp->value = element; 

		// if the element is first element 
		if (head == NULL) { 
			head = tail = temp; 
			temp->next = temp->prev = NULL; 
		} 
		else { 
			head->prev = temp; 
			temp->next = head; 
			temp->prev = NULL; 
			head = temp; 
		} 
	} 

	// insert at last position of Deque 
	void insert_last(int element) 
	{ 
		// allocating node of Node type 
		Node* temp = new Node[sizeof(Node)]; 
		temp->value = element; 

		// if element is the first element 
		if (head == NULL) { 
			head = tail = temp; 
			temp->next = temp->prev = NULL; 
		} 
		else { 
			tail->next = temp; 
			temp->next = NULL; 
			temp->prev = tail; 
			tail = temp; 
		} 
	} 

	// remove element at the first position 
	void remove_first() 
	{ 
		// if list is not empty 
		if (!isEmpty()) { 
			Node* temp = head; 
			head = head->next; 
			head->prev = NULL; 
			free(temp); 
			return; 
		} 
		cout << "List is Empty" << endl; 
	} 

	// remove element at the last position 
	void remove_last() 
	{ 
		// if list is not empty 
		if (!isEmpty()) { 
			Node* temp = tail; 
			tail = tail->prev; 
			tail->next = NULL; 
			free(temp); 
			return; 
		} 
		cout << "List is Empty" << endl; 
	} 

	// displays the elements in Deque 
	void display() 
	{ 
		// if list is not empty 
		if (!isEmpty()) { 
			Node* temp = head; 
			while (temp != NULL) { 
				cout << temp->value << " "; 
				temp = temp->next; 
			} 
			cout << endl; 
			return; 
		} 
		cout << "List is Empty" << endl; 
	} 
}; 

// Class to implement stack using Deque 
class Stack : public Deque { 
public: 
	// push to push element at top of stack 
	// using insert at last function of Deque 
	void push(int element) 
	{ 
		insert_last(element); 
	} 

	// pop to remove element at top of stack 
	// using remove at last function of Deque 
	void pop() 
	{ 
		remove_last(); 
	} 
}; 

// class to implement queue using Deque 
class Queue : public Deque { 
public: 
	// enqueue to insert element at last 
	// using insert at last function of Deque 
	void enqueue(int element) 
	{ 
		insert_last(element); 
	} 

	// Dequeue to remove element from first 
	// using remove at first function of Deque 
	void Dequeue() 
	{ 
		remove_first(); 
	} 
}; 

// Driver Code 
int main() 
{ 
	// object of Stack 
	Stack stk; 

	// push 7 and 8 at top of stack 
	stk.push(7); 
	stk.push(8); 
	cout << "Stack: "; 
	stk.display(); 

	// pop an element 
	stk.pop(); 
	cout << "Stack: "; 
	stk.display(); 

	// object of Queue 
	Queue que; 

	// insert 12 and 13 in queue 
	que.enqueue(12); 
	que.enqueue(13); 
	cout << "Queue: "; 
	que.display(); 

	// delete an element from queue 
	que.Dequeue(); 
	cout << "Queue: "; 
	que.display(); 

	cout << "Size of Stack is " << stk.size() << endl; 
	cout << "Size of Queue is " << que.size() << endl; 
	return 0; 
} 
