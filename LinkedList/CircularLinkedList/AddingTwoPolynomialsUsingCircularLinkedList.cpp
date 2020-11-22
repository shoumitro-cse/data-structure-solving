// Adding two polynomials using Circular Linked List

// g++ AddingTwoPolynomialsUsingCircularLinkedList.cpp && ./a.out


#include <bits/stdc++.h> 
using namespace std; 

// Structure of a node  in a circular linked list 
struct Node { 
	// Stores coefficient / of a node 
	int coeff; 
	// Stores power of' variable x of a node 
	int powx; 
	// Stores power of / variable y of a node 
	int powy; 
	// Stores pointer  to next node 
	struct Node* next; 
}; 


// Function to dynamically create a node 
void create_node(int c, int p1, int p2, struct Node** last) { 
	// Stores new node 
	struct Node *r; 
	// Stores last node 
	struct Node *last_node = *last; 
	// Dyanamically create a new node 
	r = (struct Node*) malloc(sizeof(struct Node)); 		
	// Update coefficient of r			 
	r->coeff = c; 
	// Update power of variable x in r 
	r->powx = p1; 
	// Update power of variable y in r 
	r->powy = p2; 
	// If z is null 
	if (last_node == NULL) { 
		// Update last node 
		(*last) = r; 
		// Create circular list
		(*last)->next = (*last); 
	} else { 
	    // Update next pointer of z 
		r->next = last_node->next; 
		// Update next pointer of z 
		last_node->next = r; 
		// Update last Node 
		(*last) = r; 
	} 
} 


// Function to add polynomial of two list 
void add_poly(struct Node* poly1, struct Node* poly2, struct Node** store) { 
	// Stores head node of polynomial1 
	struct Node *last1 = poly1; 
	// Stores head node of polynomial1 
	struct Node *last2 = poly2; 
	// Update poly1 
	poly1 = poly1->next; 
	// Update poly2 
	poly2 = poly2->next; 


	// Traverse both circular linked list 
	while ((poly1 != last1 && poly2 != last2)) { 	
		// Stores new node				 
		struct Node* r; 
		// Stores temp node 
		struct Node* z = *store; 
		// Dynamically create a new node		 
		r = (struct Node*)malloc(sizeof(struct Node)); 	
		// Update coefficient of r			 
		r->coeff = 0; 
		// If power of x of poly1 is greater than power of x of poly2 
		if (poly1->powx > poly2->powx) { 
			// Update coefficient of r 
			r->coeff = poly1->coeff; 
			// Update of power of x in r 
			r->powx = poly1->powx; 
			// Update of power of y in r 
			r->powy = poly1->powy; 
			// Update poly1 
			poly1 = poly1->next; 
		} 
		// If power of x of 1st polynomial is less than power of x of 2nd poly 
		else if (poly1->powx < poly2->powx) { 
			// Update coefficient OF r 
			r->coeff = poly2->coeff; 
			// Update power of x in r 
			r->powx = poly2->powx; 
			// Update power of y in r 
			r->powy = poly2->powy; 
			// Update ploy2 
			poly2 = poly2->next; 
		} 
		// If power of x of 1st polynomial is equal to power of x of 2nd poly 
		else { 
			// Power of y of 1st polynomial is greater than power of y of poly2 
			if (poly1->powy > poly2->powy) { 				
				// Update coefficient of r 
				r->coeff = poly1->coeff; 
				// Update power of x in r 
				r->powx = poly1->powx; 
				// Update power of y in r 
				r->powy = poly1->powy; 
				// Update poly1 
				poly1 = poly1->next; 
			} 
			// If power of y of poly1 is less than power of y of ploy2 
			else if (poly1->powy < poly2->powy) { 
				// Update coefficient of r 
				r->coeff = poly2->coeff; 
				// Update power of x in r 
				r->powx = poly2->powx; 
				// Update power of y in r 
				r->powy = poly2->powy; 
				// Update poly2 
				poly2 = poly2->next; 
			} 
			// If power of y of 1st poly is 
			// equal to power of y of ploy2 
			else { 
				// Update coefficient of r 
				r->coeff = poly2->coeff + poly1->coeff; 	
				// Update power of x in r		 
				r->powx = poly1->powx; 
				// Update power of y in r 
				r->powy = poly1->powy; 
				// Update poly1 
				poly1 = poly1->next; 
				// Update poly2 
				poly2 = poly2->next; 
			} 
		} 
		// If z is null 
		if (z == NULL) { 
			// Update store 
			(*store) = r; 
			// Update next pointer of store 
			(*store)->next = (*store); 
		} else { 
			// Update next pointer of r 
			r->next = z->next; 
			// Update next pointer of z 
			z->next = r; 
			// Update store 
			(*store) = r; 
		} 
	} 


	// If there are nodes left to be 
	// traversed in poly1 or poly2 then append them in resultant polynomial . 
	while (poly1 != last1 || poly2 != last2) { 			
		// If poly1 is not empty				 
		if (poly1 != last1) { 
			// Stores new node 
			struct Node *r; 
			// Stores store node 
			struct Node *z = *store; 
			// Create new node 
			r = (struct Node*)malloc(sizeof(struct Node)); 	
			// Update coefficient or r 
			r->coeff = poly1->coeff; 
			// Update power of x in r 
			r->powx = poly1->powx; 
			// Update power of y in r 
			r->powy = poly1->powy; 
			// Update poly1 
			poly1 = poly1->next; 
			// If z is null 
			if (z == NULL) { 
				// Update store 
				(*store) = r; 
				// Update pointer to next node 
				(*store)->next = (*store); 
			} else { 
				// Update next pointer  of r 
				r->next = z->next; 
				// Update next pointer of z 
				z->next = r; 
				// Update store 
				(*store) = r; 
			} 
		} 
		// If poly2 is not empty 
		if (poly2 != last2) { 
			// Stores new node 
			struct Node *r; 
			// Stores store node 
			struct Node *z = *store; 
			// Create new node 
			r = (struct Node*)malloc(sizeof(struct Node)); 	
			// Update coefficient of z		 
			z->coeff = poly2->coeff; 
			// Update power of x in z 
			z->powx = poly2->powx; 
			// Update power of y in z 
			z->powy = poly2->powy; 
			// Update poly2 
			poly2 = poly2->next; 
			// If z is null 
			if (z == NULL) { 
				// Update store 
				(*store) = r; 
				// Update next pointer of store 
				(*store)->next = (*store); 
			} 
			else { 
				// Update next pointer of r 
				r->next = z->next; 
				// Update next pointer of z 
				z->next = r; 
				// Update store 
				(*store) = r; 
			} 
		} 
	} 


	// Stores new node 
	struct Node *r; 
	// Stores store node 
	struct Node *z = *store; 
	// Create new node 
	r = (struct Node*)malloc(sizeof(struct Node)); 
	// Update coefficient of r	 
	r->coeff = 0; 
	// If power of x of last1 greater than power of x of last2 
	if (last1->powx > last2->powx) { 
		// Update coefficient of r 
		r->coeff = last1->coeff; 
		// Update power of x in r 
		r->powx = last1->powx; 
		// Update power of y in r 
		r->powy = last1->powy; 
	} 
	// If power of x of last1 less than power of x of last2 
	else if (last1->powx < last2->powx) { 
		// Update coefficient of r 
		r->coeff = last2->coeff; 
		// Update power of x in r 
		r->powx = last2->powx; 
		// Update power of y in r 
		r->powy = last2->powy; 
	} 
	// If power of x of last1 equal to power of x of last2 
	else { 
		// If power of y of last1 greater than power of y of last2 
		if (last1->powy > last2->powy) { 
			// Update coefficient of r 
			r->coeff = last1->coeff; 
			// Update power of x in r 
			r->powx = last1->powx; 
			// Update power of y in r 
			r->powy = last1->powy; 
		} 
		// If power of y of last1 less than power of y of last2 
		else if (last1->powy < last2->powy) { 
			// Update coefficient of r 
			r->coeff = last2->coeff; 
			// Update power of x in r 
			r->powx = last2->powx; 
			// Update power of y in r 
			r->powy = poly2->powy; 
		} 
		// If power of y of last1 equal to power of y of last2 
		else { 
			// Update coefficient of r 
			r->coeff = last2->coeff + last1->coeff; 
			// Update power of x in r 
			r->powx = last1->powx; 
			// Update power of y in r 
			r->powy = last1->powy; 
		} 
	} 
	// If z is null 
	if (z == NULL) { 
		// Update store 
		(*store) = r; 
		// Update next pointer of store 
		(*store)->next = (*store); 
	} else { 
		// Update next pointer of r 
		r->next = z->next; 
		// Update next pointer of z 
		z->next = r; 
		// Update store 
		(*store) = r; 
	} 
} 


// Display the circular linked list 
void display(struct Node* node) {

	// Stores head node of list 
	struct Node* last = node; 
	struct Node* head; 
	// Update node 
	head = last->next; 
	// Traverse the list 
	while (head != last && head->coeff != 0) { 		
		// Print coefficient of current node		 
		cout << head->coeff; 
		// If power of variable x is not zero 
		if (head->powx != 0) 
			cout << "x^" << head->powx; 
		// If power of variable x and y is not zero	 
		if(head->powx != 0 && head->powy != 0) 
			cout<<" * "; 
		// If power of variable y is not zero	 
		if (head->powy != 0) 
			cout << "y^" << head->powy; 
		// Add next term of the polynomial	 
		if (head != last && head->next->coeff != 0) { 
			cout << " + "; 
		} 
		// Update node 
		head = head->next; 
	} 
	// Print coefficient of current node 
	cout << head->coeff; 
	// If power of variable x is not zero 
	if (head->powx != 0) 
		cout << "x^" << head->powx; 
	// If power of variable y is not zero	 
	if (head->powy != 0) 
		cout << "y^" << head->powy; 
	cout << "\n\n"; 
} 


// Driver Code 
int main() 
{ 
	
	// Stores node of  first polynomial 
	struct Node *poly1 = NULL; 
	// Stores node of second polynomial 
	struct Node *poly2 = NULL; 
	// Stores node of resultant  polynomial 
	struct Node *store = NULL; 


	// Create first polynomial 
	create_node(5, 2, 1, &poly1); 
	create_node(4, 1, 2, &poly1); 
	create_node(3, 1, 1, &poly1); 
	create_node(2, 1, 0, &poly1); 
	create_node(3, 0, 1, &poly1); 
	create_node(2, 0, 0, &poly1); 


	// Create second polynomial 
	create_node(3, 1, 2, &poly2); 
	create_node(4, 1, 0, &poly2); 
	create_node(2, 0, 1, &poly2); 
	create_node(6, 0, 0, &poly2); 

	
	// Function call to add 
	// two polynomial 
	add_poly(poly1, poly2, &store); 

	// Display polynomial 1 
	cout << "Polynomial 1"<< "\n"; 
	display(poly1); 

	// Display polynomial 2 
	cout << "Polynomail 2"<< "\n"; 
	display(poly2); 

	// Display final addition of 2-variable polynomial 
	cout << "Polynomial after addition"<< "\n"; 
	display(store); 

	return 0; 
} 




/*Adding two polynomials using Circular Linked List
GGiven two polynomial numbers represented by a circular linked list, the task is to add 
these two polynomials by adding the coefficients of the powers of the same variable.
Note: In given polynomials, the term containing the higher power of x will come first.

Examples:

Input:
1st Number = 5x^2 * y^1 + 4x^1 * y^2 + 3x^1 * y^1 + 2x^1
2nd Number = 3x^1 * y^2 + 4x^1
Output:
5x^2 * y^1 + 7x^1 * y^2 + 3x^1 * y^1 + 6x^1
Explanation:
The coefficient of x^2 * y^1 in 1st numbers is 5 and 0 in the 2nd number. Therefore, sum of the coffiecient of x^2 * Y^1 is 5.
The coefficient of x^1 * y^2 in 1st numbers is 4 and 3 in the 2nd number. Therefore, sum of the coefficient of x^1 * Y^2 is 7.
The coefficient of x^1 * y^1 in 1st numbers is 3 and 0 in the 2nd number. Therefore, sum of the coefficient of x^1 * Y^1 is 2.
The coefficient of x^1 * Y^0 in 1st numbers is 2 and 4 in the 2nd number. Therefore, sum of the coefficient of x^1 * Y^0 is 6.

Input:
1st Number = 3x^3 * y^2 + 2x^2 + 5x^1 * y^1 + 9y^1 + 2
2nd Number = 4x^3 * y^3 + 2x^3 * y^2 + 1y^2 + 3
Output:
4x^3 * y^3 + 5x^3 * y^2 + 2x^2 + 5x^1 * y^1 + 1y^2 + 9y^1 + 5*/