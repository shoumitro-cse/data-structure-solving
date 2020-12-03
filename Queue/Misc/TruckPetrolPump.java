//Find the first circular tour that visits all petrol pumps

//Java program to find circular tour for a truck 

//javac -d classes TruckPetrolPump.java  && cd classes && java TruckPetrolPump && cd ..

public class TruckPetrolPump {

	// A petrol pump has petrol and distance to next petrol pump 
	static class PetrolPump { 
		int petrol; 
		int distance; 
		// constructor 
		public PetrolPump(int petrol, int distance) { 
			this.petrol = petrol; 
			this.distance = distance; 
		} 
	} 
	
	// The function returns starting point if there is a possible solution, otherwise returns -1 
	static int printTour(PetrolPump arr[], int n) {

		int start = 0; 
		int end = 1; 
		int curr_petrol = arr[start].petrol - arr[start].distance; 
		
		while(start != end || curr_petrol < 0) { 

			while(curr_petrol < 0 && start != end) { 
				curr_petrol -= arr[start].petrol - arr[start].distance; 
				start = (start + 1) % n; 
				if(start == 0) {
				  return -1; 
				}
			} 

			curr_petrol += arr[end].petrol - arr[end].distance; 
			end = (end + 1)%n; 
		} 
		
		// Return starting point 
		return start; 
	} 
	
	// Driver program to test above functions 
	public static void main(String[] args) { 
		
		PetrolPump[] arr = {new PetrolPump(6, 4), new PetrolPump(3, 6), new PetrolPump(7, 3)}; 
		
		int start = printTour(arr, arr.length); 
		
		System.out.println(start == -1 ? "No Solution" : "Starting point = " + (start)); 

	} 

} 


/*

Time Complexity: Seems to be more than linear at first look. 
If we consider the items between start and end as part of a circular queue, 
we can observe that every item is enqueued at most two times to the queue. 
The total number of operations is proportional to the total number of enqueue operations. 
Therefore the time complexity is O(n).

Auxiliary Space: O(1)

Find the first circular tour that visits all petrol pumps

Suppose there is a circle. There are n petrol pumps on that circle. You are given two sets of data.

1. The amount of petrol that every petrol pump has.
2. Distance from that petrol pump to the next petrol pump.

Calculate the first point from where a truck will be able to complete the circle (The truck will 
stop at each petrol pump and it has infinite capacity). Expected time complexity is O(n). 
Assume for 1-litre petrol, the truck can go 1 unit of distance.

For example, let there be 4 petrol pumps with amount of petrol and distance to next petrol pump 
value pairs as {4, 6}, {6, 5}, {7, 3} and {4, 5}. The first point from where the truck can make a 
circular tour is 2nd petrol pump. Output should be “start = 1” (index of 2nd petrol pump).*/