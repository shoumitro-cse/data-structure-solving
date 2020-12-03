
//LRU Cache Implementation

// javac -d classes LRUCache.java  && cd classes && java LRUCache && cd ..

import java.util.Deque;
import java.util.HashSet; 
import java.util.LinkedList; 
import java.util.Iterator;
 
public class LRUCache {
 
    // store keys of cache
    private Deque<Integer> doublyQueue;
 
    // store references of key in cache
    private HashSet<Integer> hashSet;
 
    // maximum capacity of cache 
    private final int CACHE_SIZE;
 
    LRUCache(int capacity) {
        doublyQueue = new LinkedList<>();
        hashSet = new HashSet<>();
        CACHE_SIZE = capacity;
    }
 
     // Refer the page within the LRU cache 
    public void refer(int page) {
        
        if (!hashSet.contains(page)) {
            
            if (doublyQueue.size() == CACHE_SIZE) {
                int last = doublyQueue.removeLast();
                hashSet.remove(last);
                // System.out.println("entry: "+page);
                // System.out.println("last: "+last);
            } 
        } else {
            doublyQueue.remove(page);
        } 

        doublyQueue.push(page);
        hashSet.add(page);
    }
 
    // display contents of cache
    public void display() {
        Iterator<Integer> itr = doublyQueue.iterator();
        while (itr.hasNext()) { 
            System.out.print(itr.next() + " "); 
        } 
        System.out.println(""); 
    }
 
    public static void main(String[] args) {

        LRUCache cache = new LRUCache(4);
        cache.refer(1);
        cache.refer(2);
        cache.refer(3);
        cache.refer(1); // it remove above 1 and insert itself means 1
        cache.refer(4);

        cache.refer(5); // it remove above 2 and insert 5. because doublyQueue.size() == CACHE_SIZE is true
        cache.refer(2); // it remove above 3 and insert 2. because doublyQueue.size() == CACHE_SIZE is true

        cache.refer(2); // it remove above 2 and insert itself means 2
        cache.refer(1); // it remove above 1 and insert itself means 1
        cache.display();
    }

    
} 




/* We can use Java inbuilt Deque as a double
   ended queue to store the cache keys, with
   the descending time of reference from front
   to back and a set container to check presence
   of a key. But remove a key from the Deque using
   remove(), it takes O(N) time. This can be
   optimized by storing a reference (iterator) to
   each key in a hash map. */