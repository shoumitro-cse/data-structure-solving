//Channel Assignment Problem

import java.util.*; 

class ChannelAssignmentProblem {

	static int M = 3; 
	static int N = 3; 

	// A Depth First Search based recursive function 
	// that returns true if a matching for vertex u is possible 
	static boolean bpm(int table[][], int u, boolean seen[], int matchR[]) { 
		// Try every receiver one by one 
		for (int v = 0; v < N; v++) { 
			if (table[u][v] > 0 && !seen[v]) {

				seen[v] = true; // Mark v as visited 

				if (matchR[v] < 0 || bpm(table, matchR[v], seen, matchR)) { 
					matchR[v] = u; 
					return true; 
				} 
			} 
		} 
		return false; 
	} 


	static int maxBPM(int table[][]) { 

		int [] matchR = new int[N]; 

		// Initially all receivers are not mapped to any senders 
		Arrays.fill(matchR, -1); 

		int result = 0; // Count of receivers assigned to senders 
		for (int u = 0; u < M; u++) { 
			// Mark all receivers as not seen for next sender 
			boolean []seen = new boolean[N]; 
			Arrays.fill(seen, false); 

			// Find if the sender 'u' can be assigned to the receiver 
			if (bpm(table, u, seen, matchR)) 
				result++; 
		} 

		System.out.println("The number of maximum packets" + 
						" sent in the time slot is " + result); 

		for (int x = 0; x < N; x++) {
			if (matchR[x] + 1 != 0) {
				System.out.println("T" + (matchR[x] + 1) + "-> R" + (x + 1)); 
			}
		}

		return result; 
	} 


	public static void main(String[] args) { 

		int table[][] = {
			              {0, 2, 0}, 
						  {3, 0, 1}, 
						  {2, 4, 0}
						}; 
		
		maxBPM(table); 
	} 

} 


/*
Channel Assignment Problem


There are M transmitter and N receiver stations. Given a matrix that keeps track of the number 
of packets to be transmitted from a given transmitter to a receiver. If the (i; j)-th entry of 
the matrix is k, it means at that time the station i has k packets for transmission to station j.
During a time slot, a transmitter can send only one packet and a receiver can receive only one 
packet. Find the channel assignments so that maximum number of packets are transferred from 
transmitters to receivers during the next time slot.
Example:

0 2 0
3 0 1
2 4 0
The above is the input format. We call the above matrix M. Each value M[i; j] represents the 
number of packets Transmitter ‘i’ has to send to Receiver ‘j’. The output should be:

The number of maximum packets sent in the time slot is 3
T1 -> R2
T2 -> R3
T3 -> R1*/