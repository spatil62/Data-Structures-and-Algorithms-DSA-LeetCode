import java.util.*;

class MedianFinder {
    private PriorityQueue<Integer> small; // max heap (using min heap with negative values)
    private PriorityQueue<Integer> large; // min heap

    public MedianFinder() {
        //PriorityQueue<Integer> small = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        // Or equivalently:
        small = new PriorityQueue<>(Collections.reverseOrder());
        large = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        //anyway initially add it in a small and manage afterwards 
        //its a min heap so newly added value is in place or its increasing order last element
        //that we compare after. if it belongs to max so below below line 
        small.add(num);
        
        //watch video of neetcode easy 
        //Two things we have to make sure always 
        //1. Make sure every num in small <= every num in large
        //2. Make sure both PQ has equal number of elements in it 
        if (!small.isEmpty() && !large.isEmpty() && small.peek() > large.peek()) {
            int val = small.poll();
            large.add(val);
        }
        
        // Balance sizes
        if (small.size() > large.size() + 1) {
            int val = small.poll();
            large.add(val);
        }
        if (large.size() > small.size() + 1) {
            int val = large.poll();
            small.add(val);
        }
    }
    
    public double findMedian() {
        if (small.size() > large.size()) {
            return small.peek();
        }
        if (large.size() > small.size()) {
            return large.peek();
        }
        return (small.peek() + large.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
