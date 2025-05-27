import java.util.*;

class Solution {
    public int minCostConnectPoints(int[][] points) {
        //Imp 
        /*
        Here we use prim's algorithm           cost : prims (visited array)
        so difference between Dijkstra's leetcode 753 problem and prims algorithm means this one is 

1️⃣ Prim’s Algorithm (Minimum Spanning Tree - MST) (visited array)

        🔹 Used For: Finding the Minimum Spanning Tree (MST) → Connecting all nodes with the minimum cost.
        🔹 Graph Type: Works on undirected weighted graphs.
        🔹 Goal: Find a subset of edges that connects all vertices with the least total weight (no cycles).
        🔹 Approach:
            Start with any node.
            Use a min-heap to always expand using the minimum edge.
            Add edges until all nodes are included.
        🔹 Example Use Case:
            Connecting cities with the least road cost.
            Designing efficient electrical networks.
        Time Complexity: O(E log V)
        O(ElogV) (Using a Priority Queue)

    ✅ Guarantees minimum cost to connect all nodes.
    ❌ Does not find shortest path between two nodes.

2️⃣ Dijkstra’s Algorithm (Shortest Path). (min dist array)    short dist or src to dest : dijkstra (dist array)

        🔹 Used For: Finding the shortest path from one source node to all other nodes.
        🔹 Graph Type: Works on directed or undirected weighted graphs (no negative weights).
        🔹 Goal: Find the minimum cost path from the start node to all others.
        🔹 Approach:
            Start with a single source.
            Use a min-heap to always expand using the shortest known distance.
            Update distances of neighbors and continue until all nodes are processed.
        🔹 Example Use Case:
            Google Maps → Finding shortest routes between locations.
            Network routing → Determining shortest packet paths.
        Time Complexity: O((V+E)logV)
        O((V+E)logV) (Using a Priority Queue)

    ✅ Finds shortest path from one node to others. or all nodes 
    ❌ Does not guarantee a spanning tree.

    //check out this problem to find out shortest path from source to target
    import java.util.*;

class Solution {
    public int minCostPath(int[][] points, int src, int dest) {
        int n = points.length;

        // Create adjacency list with {neighbor, cost}
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Fill adjacency list with Manhattan distances
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int cost = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                adj.get(i).add(new int[]{j, cost}); // {neighbor, cost}
                adj.get(j).add(new int[]{i, cost}); // {neighbor, cost}
            }
        }

        // Min-heap (priority queue) that orders by cost (second element)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

        int[] dist = new int[n]; // Distance array
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0; // Distance from source to itself is 0

        pq.add(new int[]{src, 0}); // {pointIndex, cost}

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int pointIndex = current[0]; // First element is pointIndex
            int cost = current[1]; // Second element is cost

            // If we reached the destination, return the cost
            if (pointIndex == dest) {
                return cost;
            }

            // Traverse neighbors
            for (int[] neighbor : adj.get(pointIndex)) {
                int nextPoint = neighbor[0];  // Neighbor (first element)
                int nextCost = neighbor[1];   // Cost (second element)

                // Relaxation step: update shortest distance
                if (dist[pointIndex] + nextCost < dist[nextPoint]) {
                    dist[nextPoint] = dist[pointIndex] + nextCost;
                    pq.add(new int[]{nextPoint, dist[nextPoint]}); // Add to PQ
                }
            }
        }

        return -1; // If no path found
    }
}
*/

        int n = points.length;

        // Create adjacency list {neighbor, cost}
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Fill adjacency list with Manhattan distances
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int cost = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                adj.get(i).add(new int[]{j, cost});  // {neighbor, cost}
                adj.get(j).add(new int[]{i, cost});  // {neighbor, cost}
            }
        }

        // Min-heap (priority queue) that orders by second value (cost)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

        boolean[] visited = new boolean[n];
        pq.add(new int[]{0, 0}); // {pointIndex, cost}

        int minCost = 0;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int pointIndex = current[0]; // First element is pointIndex
            int cost = current[1];       // Second element is cost

            if (visited[pointIndex]) {
                continue;
            }

            visited[pointIndex] = true;
            minCost += cost;

            // Add neighbors to PQ
            for (int[] neighbor : adj.get(pointIndex)) {
                int nextPoint = neighbor[0];  // Neighbor (first element)
                int nextCost = neighbor[1];   // Cost (second element)
                if (!visited[nextPoint]) {
                    pq.add(new int[]{nextPoint, nextCost}); // Keep cost as second
                }
            }
        }

        return minCost;
    }
}
