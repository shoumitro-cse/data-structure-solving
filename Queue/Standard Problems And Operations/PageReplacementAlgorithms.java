//Program for Page Replacement Algorithms | Set 2 (FIFO)

// Java implementation of FIFO page replacement in Operating Systems. 

//javac -d classes PageReplacementAlgorithms.java  && cd classes && java PageReplacementAlgorithms && cd ..


import java.util.HashSet; 
import java.util.LinkedList; 
import java.util.Queue; 


class PageReplacementAlgorithms {

	// Method to find page faults using FIFO 
	static int pageFaults(int pages[], int n, int capacity) { 

		HashSet<Integer> s = new HashSet<>(capacity);
		// To store the pages in FIFO manner 
		Queue<Integer> indexes = new LinkedList<>() ; 
		// Start from initial page 
		int page_faults = 0; 
		for (int i=0; i<n; i++) { 
			// Check if the set can hold more pages 
			if (s.size() < capacity) { 
				// Insert it into set if not present already which represents page fault 
				if (!s.contains(pages[i])) { 
					s.add(pages[i]); 
					// increment page fault 
					page_faults++; 
					// Push the current page into the queue 
					indexes.add(pages[i]); 
				} 
			} else { 
				// Check if current page is not already present in the set 
				if (!s.contains(pages[i])) { 
					//Pop the first page from the queue 
					int val = indexes.poll(); 
					// Remove the indexes page 
					s.remove(val); 
					// insert the current page 
					s.add(pages[i]); 
					// push the current page into the queue 
					indexes.add(pages[i]); 
					// Increment page faults 
					page_faults++; 
				} 
			} 
		} 
	
		return page_faults; 
	} 
	
	// Driver method 
	public static void main(String args[]) { 
		int pages[] = {7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2}; 
		int capacity = 4; 
		System.out.println(pageFaults(pages, pages.length, capacity)); 
	} 
} 

/*Program for Page Replacement Algorithms | Set 2 (FIFO)
Prerequisite : Page Replacement Algorithms

In operating systems that use paging for memory management, page replacement algorithm are 
needed to decide which page needed to be replaced when new page comes in. Whenever a new 
page is referred and not present in memory, page fault occurs and Operating System replaces 
one of the existing pages with newly needed page. Different page replacement algorithms suggest 
different ways to decide which page to replace. The target for all algorithms is to reduce number 
of page faults.

First In First Out (FIFO) page replacement algorithm –
This is the simplest page replacement algorithm. In this algorithm, operating system keeps track of
all pages in the memory in a queue, oldest page is in the front of the queue. When a page needs 
to be replaced page in the front of the queue is selected for removal.

Example -1. Consider page reference string 1, 3, 0, 3, 5, 6 and 3 page slots.

Initially all slots are empty, so when 1, 3, 0 came they are allocated to the empty slots —> 3 Page Faults.
when 3 comes, it is already in memory so —> 0 Page Faults.
Then 5 comes, it is not available in memory so it replaces the oldest page slot i.e 1. —>1 Page Fault.
Finally 6 comes, it is also not available in memory so it replaces the oldest page slot i.e 3 —>1 Page Fault.

So total page faults = 5.


Algorithm:

Implementation – Let capacity be the number of pages that memory can hold. Let set be the current set of pages in memory.

1- Start traversing the pages.
 i) If set holds less pages than capacity.
   a) Insert page into the set one by one until 
      the size  of set reaches capacity or all
      page requests are processed.
   b) Simultaneously maintain the pages in the
      queue to perform FIFO.
   c) Increment page fault
 ii) Else 
   If current page is present in set, do nothing.
   Else 
     a) Remove the first page from the queue
        as it was the first to be entered in
        the memory
     b) Replace the first page in the queue with 
        the current page in the string.
     c) Store current page in the queue.
     d) Increment page faults.

2. Return page faults.

*/