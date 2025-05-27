class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int[] res = new int[queries.length];

        for(int i=0;i<queries.length;i++)
        {
        int diff = 0;
        int minimum_val = Integer.MAX_VALUE;
        for(int j=0;j<intervals.length;j++)
            {
            if(intervals[j][0]<=queries[i] && intervals[j][1]>=queries[i])
                {
                    diff = intervals[j][1]-intervals[j][0]+1;
                    //minimum_val = Math.min(minimum_val,diff);
                }
            }
            if(minimum_val==Integer.MAX_VALUE)
            res[i]=-1;
            else
            res[i]=minimum_val;
        }
        return res;
    }
}

        // Sort intervals based on their starting points
        /*Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        // Prepare a result map to store the result for each query
        Map<Integer, Integer> res = new HashMap<>();
        int[] result = new int[queries.length];
        
        // Min heap to store intervals based on their size and end point
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]); // Sort by size
            }
            return Integer.compare(a[1], b[1]); // Sort by end point if size is the same
        });
        
        int i = 0;
        int n = intervals.length;
        
        // Make a copy of queries and sort them to process in order
        int[] sortedQueries = Arrays.copyOf(queries, queries.length);
        Arrays.sort(sortedQueries);
        
        // Iterate through sorted queries
        for (int q : sortedQueries) {
            // Add all intervals where the start <= current query
            while (i < n && intervals[i][0] <= q) {
                int l = intervals[i][0];
                int r = intervals[i][1];
                minHeap.offer(new int[]{r - l + 1, r}); // Store interval size and end point
                i++;
            }
            
            // Remove all intervals where the end < current query
            while (!minHeap.isEmpty() && minHeap.peek()[1] < q) {
                minHeap.poll();
            }
            
            // Assign the smallest valid interval size or -1 if none
            res.put(q, minHeap.isEmpty() ? -1 : minHeap.peek()[0]);
        }
        
        // Map the results back to the original query order
        for (int j = 0; j < queries.length; j++) {
            result[j] = res.get(queries[j]);
        }
        
        return result;
    }
}*/

/* Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int[] result = new int[queries.length];
        int[] sortedQueries = queries.clone();
        Arrays.sort(sortedQueries);
        
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));
        Map<Integer, Integer> queryToResult = new HashMap<>();
        int i = 0;

        for (int q : sortedQueries) {
            while (i < intervals.length && intervals[i][0] <= q) {
                int size = intervals[i][1] - intervals[i][0] + 1;
                minHeap.offer(new int[]{size, intervals[i][1]});
                i++;
            }
            while (!minHeap.isEmpty() && minHeap.peek()[1] < q) {
                minHeap.poll();
            }
            queryToResult.put(q, minHeap.isEmpty() ? -1 : minHeap.peek()[0]);
        }

        for (int j = 0; j < queries.length; j++) {
            result[j] = queryToResult.get(queries[j]);
        }
        return result;
    }
}*/
