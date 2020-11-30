//Design and Implement Special Stack Data Structure | Added Space Optimized Version


// javac -d classes SpecialStack.java  && cd classes && java SpecialStack && cd ..

import java.util.Stack;

class SpecialStack extends Stack<Integer> {

	Stack<Integer> min = new Stack<>();

	void pushTostack(int x) {

		if (isEmpty() == true) {
			super.push(x);
			min.push(x);
		} else {
			super.push(x);
			int y = min.peek();
			if (x < y)
				min.push(x);
			else
				min.push(y);
		}
	}

/*	public Integer pop()
	{
		int x = super.pop();
		min.pop();
		return x;
	}*/

	int getMin() {
		return min.peek();
	}

	public static void main(String[] args) {

		SpecialStack s = new SpecialStack();

		s.pushTostack(10);
		s.pushTostack(20);
		s.pushTostack(30);

		System.out.println(s.getMin());

		s.pushTostack(5);

		System.out.println(s.getMin());
	}
}



/*When we insert 18, both stacks change to following.
Actual Stack
18 <--- top     
Auxiliary Stack
18 <---- top

When 19 is inserted, both stacks change to following.
Actual Stack
19 <--- top     
18
Auxiliary Stack
18 <---- top
18

When 29 is inserted, both stacks change to following.
Actual Stack
29 <--- top     
19
18
Auxiliary Stack
18 <---- top
18
18

When 15 is inserted, both stacks change to following.
Actual Stack
15 <--- top     
29
19 
18
Auxiliary Stack
15 <---- top
18
18
18

When 16 is inserted, both stacks change to following.
Actual Stack
16 <--- top     
15
29
19 
18
Auxiliary Stack
15 <---- top
15
18
18
18

The following is the implementation for SpecialStack class. 
In the below implementation, SpecialStack inherits from Stack and 
has one Stack object min which works as an auxiliary stack.
 */