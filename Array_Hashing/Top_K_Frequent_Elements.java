/*Very Important 
 What is (a, b) -> Integer.compare(b[1], a[1])?

This is a custom comparator written using a lambda expression.

✅ Breakdown:
a and b are two int[] arrays being compared.
b[1] and a[1] refer to the second elements of those arrays.
Integer.compare(b[1], a[1]):
    Returns a negative number if b[1] < a[1]
    Returns 0 if they are equal
    Returns a positive number if b[1] > a[1]
So it sorts in descending order based on the second element (arr[1]) of the array.
This means the array with the higher second value gets higher priority.

Look below solution for custom comparator and remember notes and this 

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[k];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(b[1],a[1]));

        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        for(int val : map.keySet())
        pq.add(new int[]{val,map.get(val)});

        for(int i=0;i<k;i++)
        res[i]=pq.poll()[0];

        return res;
    }
}*/

import java.util.*;

class Solution {
    // Custom comparator to sort by frequency in descending order
    static class FrequencyComparator implements Comparator<int[]> {
        public int compare(int[] a, int[] b) {
            return Integer.compare(b[1], a[1]); // Higher frequency first
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[k];
        
        // Use custom comparator for priority queue
        PriorityQueue<int[]> pq = new PriorityQueue<>(new FrequencyComparator());

        // Count frequency of each number
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Add (num, frequency) pairs to the priority queue
        for (int val : map.keySet()) {
            pq.add(new int[]{val, map.get(val)});
        }

        // Poll top k elements (most frequent)
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll()[0];
        }

        return res;
    }
}



   

