class Solution {
    public int findKthLargest(int[] nums, int k) {

        //I refer aditya verma's video do read notes from notebook back side 
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int num : nums){
            pq.add(num);
            if(pq.size()>k)
            pq.poll();
        }
        return pq.poll();
    }
}
