class Solution {
    public int leastInterval(char[] tasks, int n) {

        //So I used Neetcode solution for this.
        //pretty easy logic is we need to use higher frequecy task first
        //then make sure to keep count so we are using queue as well
        //queue contains two int. first one is remaining freq count and 
        //second one is after what time we can consider using them

        //logic is everytime once we done with using task from priorityqueue 
        //we will add that to queue with as we discuss earlier 
        //and check queue is there anything equals to current time then we 
        //add back to priority queue if confused do watch neetcode solution.
        
        int time = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        // Count frequency of tasks
        for (char value : tasks)
        map.put(value, map.getOrDefault(value, 0) + 1);

        // Max heap to store task counts
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        for (char c : map.keySet())
        pq.add(map.get(c));

        // Queue to handle cooldowns
        Queue<int[]> q = new LinkedList<>();

        // Process tasks
        while (!pq.isEmpty() || !q.isEmpty()) {
            time++;

            if (!pq.isEmpty()) {
                int pqValue = pq.poll();

                if (pqValue - 1 > 0) 
                q.add(new int[]{pqValue - 1, time + n});
            }

        // Bring tasks back from cooldown if their cooldown ends
            if (!q.isEmpty() && q.peek()[1] == time) {
                pq.add(q.poll()[0]);
            }
        }

    return time;
    }
}

