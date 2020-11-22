//Large number arithmetic using doubly linked list
//g++ LargeNumberArithmetic.cpp && ./a.out


// CPP problem to illustrate arithmetic operations of 
// very large numbers using Doubly Linked List 
#include <bits/stdc++.h> 
using namespace std; 

// Structure of Double Linked List 
struct Node { 
	// To store a single digit 
	int data; 

	// Pointers to the previous and next digit 
	struct Node* next; 
	struct Node* prev; 
	Node(int); 
}; 

// To initialize the structure with a single digit 
Node::Node(int val) { 
	data = val; 
	next = prev = NULL; 
} 

class LargeNumberLinkedList {

public: 
	LargeNumberLinkedList(); 
	~LargeNumberLinkedList(); 

	// To insert a digit in front 
	void insertInFront(int); 

	// To insert a digit at the end 
	void insertInEnd(int); 

	// To display the large number 
	void display(); 

	int length(); 
	void add(LargeNumberLinkedList*, LargeNumberLinkedList*); 
	void multiple(LargeNumberLinkedList*, LargeNumberLinkedList*); 
	void difference(LargeNumberLinkedList*, LargeNumberLinkedList*); 
	void quotient(LargeNumberLinkedList*, LargeNumberLinkedList*); 
	int cmp(LargeNumberLinkedList*, LargeNumberLinkedList*); 
	Node* head; 
	Node* tail; 
	int size; 
}; 

// Constructor of the Class 
LargeNumberLinkedList::LargeNumberLinkedList() 
{ 
	head = tail = NULL; 
	size = 0; 
} 

// To insert at the beginning of the list 
void LargeNumberLinkedList::insertInFront(int value) 
{ 
	Node* temp = new Node(value); 

	if (head == NULL) 
		head = tail = temp; 
	else
	{ 
		head->prev = temp; 
		temp->next = head; 
		head = temp; 
	} 
	size++; 
} 

// To insert in the end 
void LargeNumberLinkedList::insertInEnd(int value) 
{ 
	Node* temp = new Node(value); 

	if (tail == NULL) 
		head = tail = temp; 
	else
	{ 
		tail->next = temp; 
		temp->prev = tail; 
		tail = temp; 
	} 
	size++; 
} 

/* 
To display the number can be 
modifferenceied to remove leading zeros*/
void LargeNumberLinkedList::display() 
{ 
	Node* temp = head; 

	while (temp != NULL) 
	{ 
		cout << temp->data; 
		temp = temp->next; 
	} 
	cout <<endl; 
} 

// Returns the number of digits 
int LargeNumberLinkedList::length() 
{ 
	return size; 
} 

/* Uses simple addition method that we 
follow using carry*/
void LargeNumberLinkedList::add(LargeNumberLinkedList* a, LargeNumberLinkedList* b) { 

	int c = 0, s; 
	LargeNumberLinkedList* a1 = new LargeNumberLinkedList(*a); 
	LargeNumberLinkedList* b1 = new LargeNumberLinkedList(*b); 

	// default copy constructor 
	// Copy Constructor - used to copy objects 
	this->head = NULL; 
	this->tail = NULL; 
	this->size = 0; 

	while (a1->tail != NULL || b1->tail != NULL) { 

		if (a1->tail != NULL && b1->tail != NULL) { 
			s = ((a1->tail->data) + (b1->tail->data) + c) % 10; 
			c = ((a1->tail->data) + (b1->tail->data) + c) / 10; 
			a1->tail = a1->tail->prev; 
			b1->tail = b1->tail->prev; 
		} else if (a1->tail == NULL && b1->tail != NULL) { 
			s = ((b1->tail->data) + c) % 10; 
			c = ((b1->tail->data) + c) / 10; 
			b1->tail = b1->tail->prev; 
		} else if (a1->tail != NULL && b1->tail == NULL) { 
			s = ((a1->tail->data) + c) % 10; 
			c = ((a1->tail->data) + c) / 10; 
			a1->tail = a1->tail->prev; 
		} 
		// Inserting the sum digit 
		insertInFront(s); 
	} 

	// Inserting last carry 
	if (c != 0) 
		insertInFront(c); 
} 

// Normal subtraction is done by borrowing 
void LargeNumberLinkedList::difference(LargeNumberLinkedList* a, LargeNumberLinkedList* b) { 

	int c = 0, s; 
	LargeNumberLinkedList* a1 = new LargeNumberLinkedList(*a); 
	LargeNumberLinkedList* b1 = new LargeNumberLinkedList(*b); 

	this->head = NULL; 
	this->tail = NULL; 
	this->size = 0; 

	while (a1->tail != NULL || b1->tail != NULL) { 

		if (a1->tail != NULL && b1->tail != NULL) { 

			if ((a1->tail->data) + c >= (b1->tail->data)) { 
				s = ((a1->tail->data) + c - (b1->tail->data)); 
				c = 0; 
			} else { 
				s = ((a1->tail->data) + c + 10 - (b1->tail->data)); 
				c = -1; 
			} 
			a1->tail = a1->tail->prev; 
			b1->tail = b1->tail->prev; 
		} else if (a1->tail != NULL && b1->tail == NULL) { 
			if (a1->tail->data >= 1) { 
				s = ((a1->tail->data) + c); 
				c = 0; 
			} else{ 
				if (c != 0) { 
					s = ((a1->tail->data) + 10 + c); 
					c = -1; 
				} else {
					s = a1->tail->data; 
				}
			} 
			a1->tail = a1->tail->prev; 
		} 
		insertInFront(s); 
	} 
} 

// This compares the two numbers and returns 
// true or 1 when a is greater 
int LargeNumberLinkedList::cmp(LargeNumberLinkedList* a, LargeNumberLinkedList* b) 
{ 
	if (a->size != b->size) 
		return ((a->size > b->size) ? 1 : 0); 

	LargeNumberLinkedList* a1 = new LargeNumberLinkedList(*a); 
	LargeNumberLinkedList* b1 = new LargeNumberLinkedList(*b); 
	while (a1->head != NULL && b1->head != NULL) 
	{ 
		if (a1->head->data > b1->head->data) 
			return 1; 
		else if (a1->head->data < b1->head->data) 
			return 0; 
		else
		{ 
			a1->head = a1->head->next; 
			b1->head = b1->head->next; 
		} 
	} 
	return 2; 
} 

// Returns the quotienttient using Normal Division 
// multipletiplication is used to find what factor 
// is to be multipletiplied 
void LargeNumberLinkedList::quotient(LargeNumberLinkedList* a, LargeNumberLinkedList* b) 
{ 
	LargeNumberLinkedList* a1 = new LargeNumberLinkedList(*a); 
	LargeNumberLinkedList* b1 = new LargeNumberLinkedList(*b); 

	LargeNumberLinkedList* ex = new LargeNumberLinkedList(); 
	LargeNumberLinkedList* mp = new LargeNumberLinkedList(); 
	LargeNumberLinkedList* pr = new LargeNumberLinkedList(); 

	int i = 0; 
	for (i = 0; i < b1->size; i++) { 
		ex->insertInEnd(a1->head->data); 
		a1->head = a1->head->next; 
	} 

	for (i = 0; i < 10; i++) { 
		LargeNumberLinkedList* b2 = new LargeNumberLinkedList(*b); 
		mp->insertInEnd(i); 
		pr->multiple(b2, mp); 
		if (!cmp(ex, pr)) 
			break; 
		mp->head = mp->tail = NULL; 
		pr->head = pr->tail = NULL; 
		mp->size = pr->size = 0; 
	} 

	mp->head = mp->tail = NULL; 
	pr->head = pr->tail = NULL; 
	mp->size = pr->size = 0; 

	mp->insertInEnd(i - 1); 
	pr->multiple(b1, mp); 
	ex->difference(ex, pr); 
	insertInEnd(i - 1); 
	mp->head = mp->tail = NULL; 
	pr->head = pr->tail = NULL; 
	mp->size = pr->size = 0; 

	while (a1->head != NULL) 
	{ 
		ex->insertInEnd(a1->head->data); 
		while (ex->head->data == 0) 
		{ 
			ex->head = ex->head->next; 
			ex->size--; 
		} 
		for (i = 0; i < 10; i++) 
		{ 
			LargeNumberLinkedList* b2 = new LargeNumberLinkedList(*b); 
			mp->insertInEnd(i); 
			pr->multiple(b2, mp); 
			if (!cmp(ex, pr)) 
				break; 
			mp->head = mp->tail = NULL; 
			pr->head = pr->tail = NULL; 
			mp->size = pr->size = 0; 
		} 

		mp->head = mp->tail = NULL; 
		pr->head = pr->tail = NULL; 
		mp->size = pr->size = 0; 

		mp->insertInEnd(i - 1); 
		pr->multiple(b1, mp); 
		ex->difference(ex, pr); 

		insertInEnd(i - 1); 

		mp->head = mp->tail = NULL; 
		pr->head = pr->tail = NULL; 
		mp->size = pr->size = 0; 

		a1->head = a1->head->next; 
	} 

	cout << endl 
		<< "\nModulus :" << endl; 
	ex->display(); 
} 

// Normal multipletiplication is used i.e. in one to all way 
void LargeNumberLinkedList::multiple(LargeNumberLinkedList* a, LargeNumberLinkedList* b) 
{ 
	int k = 0, i; 
	// LargeNumberLinkedList* tpro = new LargeNumberLinkedList(); 
	while (b->tail != NULL) {

		int c = 0, s = 0; 
		LargeNumberLinkedList* __a = new LargeNumberLinkedList(*a); 
		LargeNumberLinkedList* list = new LargeNumberLinkedList(); 

		while (__a->tail != NULL) { 
			s = ((__a->tail->data) * (b->tail->data) + c) % 10; 
			c = ((__a->tail->data) * (b->tail->data) + c) / 10; 
			list->insertInFront(s); 
			__a->tail = __a->tail->prev; 
		}

		if (c != 0) {
			list->insertInFront(c); 
		}

		for (i = 0; i < k; i++) {
			list->insertInEnd(0); 
		}

		add(this, list); 
		k++; 
		
		b->tail = b->tail->prev; 

		list->head = list->tail = NULL; 
		list->size = 0; 
	} 
} 

// Driver code 
int main() {

	LargeNumberLinkedList* m = new LargeNumberLinkedList(); 
	LargeNumberLinkedList* n = new LargeNumberLinkedList(); 
	LargeNumberLinkedList* s = new LargeNumberLinkedList(); 
	LargeNumberLinkedList* p = new LargeNumberLinkedList(); 
	LargeNumberLinkedList* d = new LargeNumberLinkedList(); 
	LargeNumberLinkedList* q = new LargeNumberLinkedList(); 

	string s1 = "123456789123456789123456789123456789123456789123456789"; 
	string s2 = "45678913456789123456789123456789123456789123456789"; 	

	 s1 = "12"; 
	 s2 = "5"; 

	for (int i = 0; i < s1.length(); i++) {
		m->insertInEnd(s1.at(i) - '0'); 
	}

	for (int i = 0; i < s2.length(); i++) {
		n->insertInEnd(s2.at(i) - '0'); 
	}

	// Creating copies of m and n 
	LargeNumberLinkedList* m1 = new LargeNumberLinkedList(*m); 
	LargeNumberLinkedList* n1 = new LargeNumberLinkedList(*n); 

	LargeNumberLinkedList* m2 = new LargeNumberLinkedList(*m); 
	LargeNumberLinkedList* n2 = new LargeNumberLinkedList(*n); 

	LargeNumberLinkedList* m3 = new LargeNumberLinkedList(*m); 
	LargeNumberLinkedList* n3 = new LargeNumberLinkedList(*n); 

	cout << "string s1 : "; 
    m->display();

	cout << "string s2 : "; 
    n->display();

	cout<<endl;


	cout << "Sum :" << endl; 
	p->add(m1, n1); 
	p->display(); 
	cout << endl; 

	cout << "difference (m-n) : m>n:" << endl; 
	d->difference(m2, n2); 
	d->display(); 
	cout << endl; 

	cout << "Product :" << endl; 
	s->multiple(m, n); 
	s->display(); 
	cout << endl; 

	q->quotient(m3, n3);

	cout << "Quotient :" << endl; 
	q->display(); 
	return 0; 
} 




/*Large number arithmetic using doubly linked list
Last Updated: 03-04-2018
Given two very large numbers in form of strings. Your task is to apply differenceferent
 arithmetic operations on these strings.

Prerequisite : Doubly Linked List.

Examples:

Input : 
m : 123456789123456789123456789123456789123456789123456789
n : 456789123456789123456789123456789123456789123456789
Output :
Product : 563937184884934839205932493526930147847927802168925...
30351019811918920046486820281054720515622620750190521
Sum : 123913578246913578246913578246913578246913578246913578
differenceference : 123000000000000000000000000000000000000000000000000000
quotienttient : 270
Remainder(%) : 123725790123725790123725790123725790123725790123759

Input :
m : 55
n : 2
Output :
Product : 110
Sum : 57
differenceference : 53
quotienttient : 27
Remainder(%) : 1


*/