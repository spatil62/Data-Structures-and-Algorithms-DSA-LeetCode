class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->Integer.compare(b,a));

        for(int stone : stones){
            pq.add(stone);
        }

        while(pq.size()!=1){
            int after = 0;
            int first = pq.poll();
            int second = pq.poll();

            if(first!=second){
                after = first-second;
                pq.add(after);
            }

            if(pq.size()==0)
            return 0;
        }

        return pq.poll();
    }
}
