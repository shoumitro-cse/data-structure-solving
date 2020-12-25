// Merge Two Binary Trees by doing Node Sum (Recursive and Iterative)

//javac -d classes MergeTwoBTSum.java  && cd classes && java MergeTwoBTSum && cd ..

class MergeTwoBTSum {

  static class Node {
		int data;
		Node left, right;
		
		public Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
	/* Helper method that allocates a new node with the
	given data and NULL left and right pointers. */
	static Node newNode(int data)
	{
		return new Node(data, null, null);
	}
	
	/* Given a binary tree, print its nodes in inorder*/
	static void inorder(Node node)
	{
		if (node == null)
			return;
		/* first recur on left child */
		inorder(node.left);
		/* then print the data of node */
		System.out.printf("%d ", node.data);
		/* now recur on right child */
		inorder(node.right);
	}
	
	/* Method to merge given two binary trees*/
	static Node MergeTrees(Node t1, Node t2)
	{
		if (t1 == null)
			return t2;
		if (t2 == null)
			return t1;
		t1.data += t2.data;
		t1.left = MergeTrees(t1.left, t2.left);
		t1.right = MergeTrees(t1.right, t2.right);
		return t1;
	}
	
	// Driver method
	public static void main(String[] args)
	{
       
         Node root1 = newNode(1);
         root1.left = newNode(2);
         root1.right = newNode(3);
         root1.left.left = newNode(4);
         root1.left.right = newNode(5);
         root1.right.right = newNode(6);
         /* Let us construct the first Binary Tree
                 1
               /   \
              2     3
             / \     \
            4   5     6
         */
       
         Node root2 = newNode(4);
         root2.left = newNode(1);
         root2.right = newNode(7);
         root2.left.left = newNode(3);
         root2.right.left = newNode(2);
         root2.right.right = newNode(6);
       
         /* Let us construct the second Binary Tree
                4
              /   \
             1     7
            /     /  \
           3     2    6   */

         Node root3 = MergeTrees(root1, root2);
         
         System.out.printf("The Merged Binary Tree is:\n");
         
         inorder(root3);
		System.out.printf("\n");
	}
}


/*
Merge Two Binary Trees by doing Node Sum (Recursive and Iterative)

Given two binary trees. We need to merge them into a new binary tree. 
The merge rule is that if two nodes overlap, then sum node values up as 
the new value of the merged node. Otherwise, the non-null node will be 
used as the node of new tree.

Example: 
 

Input: 
     Tree 1            Tree 2                  
       2                 3                             
      / \               / \                            
     1   4             6   1                        
    /                   \   \                      
   5                     2   7                  

Output: Merged tree:
         5
        / \
       7   5
      / \   \ 
     5   2   7
Note: The merging process must start from the root nodes of both trees. 

Complexity Analysis: (c++)
 
Time complexity : O(n) 
A total of n nodes need to be traversed. Here, n represents the minimum number of nodes from the two given trees.
Auxiliary Space : O(n) 
The depth of the stack can go upto n in case of a skewed tree.
 

*/



/*// C++ program to Merge Two Binary Trees
#include <bits/stdc++.h>
using namespace std;


struct Node
{
	int data;
	struct Node *left, *right;
};

struct snode
{
	Node *l, *r;
};

Node *newNode(int data)
{
	Node *new_node = new Node;
	new_node->data = data;
	new_node->left = new_node->right = NULL;
	return new_node;
}

void inorder(Node * node)
{
	if (! node)
		return;
	inorder(node->left);
	printf("%d ", node->data);
	inorder(node->right);
}


Node* MergeTrees(Node* t1, Node* t2)
{
	if (! t1)
		return t2;
	if (! t2)
		return t1;
	stack<snode> s;
	snode temp;
	temp.l = t1;
	temp.r = t2;
	s.push(temp);
	snode n;
	while (! s.empty())
	{
		n = s.top();
		s.pop();
		if (n.l == NULL|| n.r == NULL)
			continue;
		n.l->data += n.r->data;
		if (n.l->left == NULL)
			n.l->left = n.r->left;
		else
		{
			snode t;
			t.l = n.l->left;
			t.r = n.r->left;
			s.push(t);
		}
		if (n.l->right == NULL)
			n.l->right = n.r->right;
		else
		{
			snode t;
			t.l = n.l->right;
			t.r = n.r->right;
			s.push(t);
		}
	}
	return t1;
}

// Driver code
int main()
{

	Node *root1 = newNode(1);
	root1->left = newNode(2);
	root1->right = newNode(3);
	root1->left->left = newNode(4);
	root1->left->right = newNode(5);
	root1->right->right = newNode(6);


	Node *root2 = newNode(4);
	root2->left = newNode(1);
	root2->right = newNode(7);
	root2->left->left = newNode(3);
	root2->right->left = newNode(2);
	root2->right->right = newNode(6);

	Node *root3 = MergeTrees(root1, root2);
	printf("The Merged Binary Tree is:\n");
	inorder(root3);
	return 0;
}
*/