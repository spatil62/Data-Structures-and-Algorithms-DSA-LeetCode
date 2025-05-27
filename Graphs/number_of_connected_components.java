class Solution {
    public int countComponents(int n, int[][] edges) {
        //tip : code both problem undirected and need to 
        //check connected component so for loop will 
        //come according to node 
        //check visited node we need vis
        //and queue to add and rotate thats it
        
        int count = 0;

        //create an adj list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

        for(int i=0;i<n;i++)
        adj.add(new ArrayList<Integer>());

        for(int i=0;i<edges.length;i++)
        {
        adj.get(edges[i][0]).add(edges[i][1]);
        adj.get(edges[i][1]).add(edges[i][0]);
        }

        int[] vis = new int[n];

        for(int i=0;i<n;i++){
            if(vis[i]==0)
            {
                count++;
                detect(adj, i, vis);
            } 
        }

        return count;
    }

    // BFS function to explore the entire connected component
    void detect(ArrayList<ArrayList<Integer>> adj, int start, int[] vis) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        vis[start] = 1; // Mark as visited

        while (!q.isEmpty()) {
            int node = q.poll(); // Remove front element from queue
            for (int neighbor : adj.get(node)) {
                if (vis[neighbor] == 0) {
                    vis[neighbor] = 1; // Mark visited
                    q.add(neighbor);  // Add to queue for further exploration
                }
            }
        }
    }
}
