// Iterative Postorder Traversal (Using Two Stacks)

//javac -d classes PostorderTraversalUsingStacksIterative.java  && cd classes && java PostorderTraversalUsingStacksIterative && cd ..

import java.util.*; 

public class PostorderTraversalUsingStacksIterative { 

	static class Node { 
		int data; 
		Node left, right; 

		public Node(int data) 
		{ 
			this.data = data; 
			 left=right=null;
		} 
	} 

	// Two stacks as used in explanation 
/*	static void postOrderIterative(Node root) 
	{ 
		// Create two stacks 
	    Stack<Node> stack1, stack2; 
		stack1 = new Stack<>(); 
		stack2 = new Stack<>(); 

		if (root == null) 
			return; 

		// push root to first stack 
		stack1.push(root); 

		// Run while first stack is not empty 
		while (!stack1.isEmpty()) { 
			// Pop an item from stack1 and push it to stack2 
			Node temp = stack1.pop(); 
			stack2.push(temp); 

			// Push left and right children of removed item to stack1 
			if (temp.left != null) 
				stack1.push(temp.left); 
			if (temp.right != null) 
				stack1.push(temp.right); 
		} 

		// Print all elements of second stack 
		while (!stack2.isEmpty()) { 
			System.out.print(stack2.pop().data + " "); 
		} 
		System.out.println(" "); 
	} */

/*   // Iterative Postorder Traversal | Set 2 (Using One Stack)
	static void postOrderIterative(Node root) { 
        
        Stack<Node> stack = new Stack<>(); 

        while(true) { 
            
            while(root != null) { 
                stack.push(root); 
                stack.push(root); 
                root = root.left; 
            } 
              
            // Check for empty stack 
            if(stack.empty()) { 
              return; 
            }

            root = stack.pop(); 
              
            if(!stack.empty() && stack.peek() == root) {
            	root = root.right; 
            } else { 
                System.out.print(root.data + " "); 
                root = null; 
            } 
        } 
    }*/

    public static void postOrderIterative(Node node) {

        ArrayList<Integer> list = new ArrayList<Integer>();  
        Stack<Node> S = new Stack<Node>(); 
           
        // Check for empty tree 
        if (node == null) 
            return ; 

        S.push(node); 
        Node prev = null; 

        while (!S.isEmpty()) {

            Node current = S.peek(); 
             // go down the tree in search of a leaf an if so process it
              // and pop stack otherwise move down 
            if (prev == null || prev.left == current || prev.right == current) {

                if (current.left != null) {
                    S.push(current.left); 
                } else if (current.right != null) {
                    S.push(current.right); 
                } else { 
                    S.pop(); 
                    list.add(current.data); 
                } 
            } else if (current.left == prev) {

                if (current.right != null) {
                    S.push(current.right); 
                } else { 
                    S.pop(); 
                    list.add(current.data); 
                } 
            } else if (current.right == prev) { 
                S.pop(); 
                list.add(current.data); 
            } 
   
            prev = current; 
        } 

		System.out.println(list); 
    } 

	public static void main(String[] args) 
	{ 
		// Let us construct the tree 
		// shown in above figure 

		Node root = null; 

		root = new Node(1); 

		root.left = new Node(2); 
		root.right = new Node(3); 

		root.left.left = new Node(4); 
		root.left.right = new Node(5); 

		root.right.left = new Node(6); 
		root.right.right = new Node(7); 

        System.out.println(" "); 
		postOrderIterative(root); 
		System.out.println(" "); 
	} 
} 


/*Algorithm:

1. Push root to first stack.
2. Loop while first stack is not empty
   2.1 Pop a node from first stack and push it to second stack
   2.2 Push left and right children of the popped node to first stack
3. Print contents of second stack




Following are the steps to print postorder traversal of the above tree using two stacks.
1. Push 1 to first stack.
      First stack: 1
      Second stack: Empty

2. Pop 1 from first stack and push it to second stack. 
   Push left and right children of 1 to first stack
      First stack: 2, 3
      Second stack: 1

3. Pop 3 from first stack and push it to second stack. 
   Push left and right children of 3 to first stack
      First stack: 2, 6, 7
      Second stack: 1, 3

4. Pop 7 from first stack and push it to second stack.
      First stack: 2, 6
      Second stack: 1, 3, 7

5. Pop 6 from first stack and push it to second stack.
      First stack: 2
      Second stack: 1, 3, 7, 6

6. Pop 2 from first stack and push it to second stack. 
   Push left and right children of 2 to first stack
      First stack: 4, 5
      Second stack: 1, 3, 7, 6, 2

7. Pop 5 from first stack and push it to second stack.
      First stack: 4
      Second stack: 1, 3, 7, 6, 2, 5

8. Pop 4 from first stack and push it to second stack.
      First stack: Empty
      Second stack: 1, 3, 7, 6, 2, 5, 4

The algorithm stops here since there are no more items in the first stack. 
Observe that the contents of second stack are in postorder fashion. Print them.*/












/*Iterative Postorder Traversal | Set 2 (Using One Stack)

Algorithm:

1.1 Create an empty stack
2.1 Do following while root is not NULL
    a) Push root's right child and then root to stack.
    b) Set root as root's left child.
2.2 Pop an item from stack and set it as root.
    a) If the popped item has a right child and the right child 
       is at top of stack, then remove the right child from stack,
       push the root back and set root as root's right child.
    b) Else print root's data and set root as NULL.
2.3 Repeat steps 2.1 and 2.2 while stack is not empty.


1. Right child of 1 exists. 
   Push 3 to stack. Push 1 to stack. Move to left child.
        Stack: 3, 1

2. Right child of 2 exists. 
   Push 5 to stack. Push 2 to stack. Move to left child.
        Stack: 3, 1, 5, 2

3. Right child of 4 doesn't exist. '
   Push 4 to stack. Move to left child.
        Stack: 3, 1, 5, 2, 4

4. Current node is NULL. 
   Pop 4 from stack. Right child of 4 doesn't exist. 
   Print 4. Set current node to NULL.
        Stack: 3, 1, 5, 2

5. Current node is NULL. 
    Pop 2 from stack. Since right child of 2 equals stack top element, 
    pop 5 from stack. Now push 2 to stack.     
    Move current node to right child of 2 i.e. 5
        Stack: 3, 1, 2

6. Right child of 5 doesn't exist. Push 5 to stack. Move to left child.
        Stack: 3, 1, 2, 5

7. Current node is NULL. Pop 5 from stack. Right child of 5 doesn't exist. 
   Print 5. Set current node to NULL.
        Stack: 3, 1, 2

8. Current node is NULL. Pop 2 from stack. 
   Right child of 2 is not equal to stack top element. 
   Print 2. Set current node to NULL.
        Stack: 3, 1

9. Current node is NULL. Pop 1 from stack. 
   Since right child of 1 equals stack top element, pop 3 from stack. 
   Now push 1 to stack. Move current node to right child of 1 i.e. 3
        Stack: 1

10. Repeat the same as above steps and Print 6, 7 and 3. 
    Pop 1 and Print 1.
    */