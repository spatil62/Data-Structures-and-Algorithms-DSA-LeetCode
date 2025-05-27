class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        //to print path we need basic array do follow notebook its easy 
        //take parent array initially they are own parent in for loop
        //assign parent and node and then at the end just backwords like 
        //child to parent and again child to parent 

        //if shortest path is we need level by level then use queue otherwise pq


        //dont forget 
        //this is Dijkstra's algorithm 
        /*
        import java.util.*;

        class DistanceComparator implements Comparator<int[]> {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[1], b[1]); // Sort by distance (ascending order)
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(new DistanceComparator());

        */


        ArrayList<ArrayList<int []>> adj = new ArrayList<ArrayList<int []>>();

        //bcoz adj list start with 1 not 0 but confirm
        /*
        The problem states that the graph nodes are labeled from 1 to n.
In Java, arrays and lists are 0-based, meaning they start at index 0.
To make indexing simpler, many implementations allocate an extra unused slot (adj[0]).
This allows direct access to node i at adj[i] without shifting indices.
        */
        for(int i=0;i<=n;i++)
            adj.add(new ArrayList<int []>());

        for(int i=0;i<times.length;i++)
        //here we performed with 0 index so we needed above that adjustment 
            adj.get(times[i][0]).add(new int[]{times[i][1], times[i][2]});

        int[] dist = new int[n+1];

        /*for(int i=1;i<dist.length;i++)
        dist[i]=(int) 1e9;*/
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[k]=0;

        //because we need minimum time so use priority queue 
        //pq will contain src and dist
        PriorityQueue<int []> pq = new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));

        pq.add(new int[] {k,0});

        while(!pq.isEmpty())
        {
            int[] q_value = pq.poll();
            int q_src = q_value[0];
            int q_dist = q_value[1];

            for(int[] value : adj.get(q_src))
            {
                int value_src = value[0];
                int value_dist = value[1];

                if(q_dist+value_dist<dist[value_src])
                {
                    dist[value_src] = q_dist+value_dist;
                    pq.add(new int[]{value_src,q_dist+value_dist});
                }
            }
        }

        int maxTime = Integer.MIN_VALUE;

        for(int i=1;i<=n;i++)
        if(dist[i]==Integer.MAX_VALUE)
        return -1;

        for(int i=1;i<=n;i++)
        maxTime = Math.max(maxTime,dist[i]);
    
        return maxTime;
        
    }
}
