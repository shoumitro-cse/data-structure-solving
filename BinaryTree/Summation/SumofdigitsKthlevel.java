// Sum of nodes at k-th level in a tree represented as string

//javac -d classes SumofdigitsKthlevel.java  && cd classes && java SumofdigitsKthlevel && cd ..

class SumofdigitsKthlevel { 

	// Function to find sum of digits of elements at k-th level 
	static int sumAtKthLevel(String tree, int k) { 
		int level = -1; 
		int sum = 0; // Initialize result 
		int n = tree.length(); 

		for (int i=0; i<n; i++) { 
			// increasing level number 
			if (tree.charAt(i) == '(') 
				level++; 
			// decreasing level number 
			else if (tree.charAt(i) == ')') 
				level--; 
			else { 
				// check if current level is the desired level or not 
				if (level == k) 
					sum += (tree.charAt(i)-'0'); 
			} 
		} 
		// required sum 
		return sum; 
	} 

	// Driver program to test above 
	public static void main(String[] args) { 
		String tree = "(0(5(6()())(4()(9()())))(7(1()())(3()())))"; 
		int k = 2; 
		System.out.println(sumAtKthLevel(tree, k)); 
	} 
} 

/*
Sum of nodes at k-th level in a tree represented as string

Given an integer ‘K’ and a binary tree in string format. Every node of a tree has value in range from 0 to 9. We need to find sum of elements at K-th level from root. The root is at level 0.
Tree is given in the form: (node value(left subtree)(right subtree))

Examples:

          0
        /   \
       5     7
      / \   / \
     6   4 1   3
          \
           9  

Input : tree = "(0(5(6()())(4()(9()())))(7(1()())(3()())))" 
        k = 2
Output : 14
Its tree representation is shown below
TREE
Elements at level k = 2 are 6, 4, 1, 3
sum of the digits of these elements = 6+4+1+3 = 14 


Input : tree = "(8(3(2()())(6(5()())()))(5(10()())(7(13()())())))" 
        k = 3
Output : 9
Elements at level k = 3 are 5, 1 and 3
sum of digits of these elements = 5+1+3 = 9





algorithm:

1. Input 'tree' in string format and level k
2. Initialize level = -1 and sum = 0
3. for each character 'ch' in 'tree'
   3.1  if ch == '(' then
        --> level++
   3.2  else if ch == ')' then
        --> level--
   3.3  else
        if level == k then
           sum = sum + (ch-'0')
4. Print sum
C++*/