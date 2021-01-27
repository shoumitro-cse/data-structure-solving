// Count items common to both the lists but with different prices


class CountItems {

	// details of an item
	static class item {
		String name;
		int price;
		public item(String name, int price) {
			this.name = name;
			this.price = price;
		}
	};

	// function to count items common to both the lists but with different prices
	static int countItems(item list1[], int m, item list2[], int n) {
		int count = 0;
		// for each item of 'list1' check if it is in 'list2' but with a different price
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if ((list1[i].name.compareTo(list2[j].name) == 0) &&
					(list1[i].price != list2[j].price)) {
					count++;
			    }	 
			}
		}
		
		// required count of items
		return count;
	}

	// Driver code
	public static void main(String[] args) {

		item list1[] = {new item("apple", 60), new item("bread", 20),
					new item("wheat", 50), new item("oil", 30)};
		item list2[] = {new item("milk", 20), new item("bread", 15),
					new item("wheat", 40), new item("apple", 60)};
		
		int m = list1.length;
		int n = list2.length; 
		
		System.out.print("Count = "+ countItems(list1, m, list2, n));
			
	}	 
} 

/*
Source: Cognizant Interview Experience | Set 5.

Count items common to both the lists but with different prices


Given two lists list1 and list2 containing m and n items respectively. 
Each item is associated with two fields: name and price. The problem is to count 
items that are in both the lists but with different prices.

Examples: 

Input : list1[] = {{"apple", 60}, {"bread", 20}, 
                   {"wheat", 50}, {"oil", 30}}
    list2[] = {{"milk", 20}, {"bread", 15}, 
                   {"wheat", 40}, {"apple", 60}}
Output : 2
bread and wheat are the two items common to both the
lists but with different prices.
*/