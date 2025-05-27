class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        /*VIMP
        Summary of Decision Logic

        Use a PriorityQueue:
            When you need to find the globally minimum cost/distance (e.g., Dijkstra's or Prim's algorithm).
            When there are no constraints on the number of steps.
        Use a Queue:
            When you need to respect a constraint on the number of steps (e.g., k stops in findCheapestPrice).
            When you need to explore all possible paths level by level (e.g., BFS).
        */

        ArrayList<ArrayList<int[]>> adj = new ArrayList<ArrayList<int[]>>();

        for(int i=0;i<n;i++)
        adj.add(new ArrayList<int []>());

        for(int i=0;i<flights.length;i++)
        adj.get(flights[i][0]).add(new int[]{flights[i][1], flights[i][2]});

        int[] dist = new int[n];

        for(int i=0;i<n;i++)
        dist[i]=(int) 1e9;

        dist[src]=0;

        //imp no priorityqueue used .... only queue used here
        Queue<int[]> q = new LinkedList<>();

        //to make sure always we remember this "k" 
        q.add(new int[]{0,src,0});

        while(!q.isEmpty())
        {
            int[] value = q.poll();
            int q_stop = value[0];
            int q_src = value[1];
            int q_cost = value[2];

            if(q_stop>k)
            continue;

            for(int [] adj_value : adj.get(q_src))
            {
                int neighbor_src = adj_value[0];
                int neighbor_cost = adj_value[1];

                if(dist[neighbor_src]> q_cost+ neighbor_cost)
                {
                    dist[neighbor_src]=q_cost+ neighbor_cost;
                    q.add(new int []{q_stop+1, neighbor_src, q_cost+ neighbor_cost});
                }
            }
        }

        if(dist[dst]==(int) 1e9)
        return -1;

        return dist[dst];
    }
}
