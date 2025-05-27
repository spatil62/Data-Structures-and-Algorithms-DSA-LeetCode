import java.util.*;
//I know this is relevant and i want you to remember bcoz here also we need to check cycle but last one
/*how to find cycle detection in undirected graph using parent and child way 
no khans does work here other than trees. but 

class CycleDetection {
    public boolean hasCycle(int n, int[][] edges) {
        // Build the graph using an adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // Visited array to keep track of visited nodes
        boolean[] visited = new boolean[n];

        // Perform BFS from each unvisited node (to handle disconnected graphs)
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (bfsDetectCycle(graph, i, visited)) {
                    return true; // Cycle detected
                }
            }
        }

        return false; // No cycle found
    }

    // BFS to detect cycle
    private boolean bfsDetectCycle(List<List<Integer>> graph, int start, boolean[] visited) {
        Queue<int[]> queue = new LinkedList<>(); // Queue stores [current node, parent node]
        queue.offer(new int[]{start, -1}); // Start BFS with the initial node and no parent
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0];
            int parent = current[1];

            // Traverse all neighbors
            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(new int[]{neighbor, node}); // Add neighbor to queue with current node as parent
                } else if (neighbor != parent) {
                    // If the neighbor is visited and not the parent, a cycle exists
                    return true;
                }
            }
        }

        return false; // No cycle detected in this component
    }

    public static void main(String[] args) {
        CycleDetection detector = new CycleDetection();
        int n = 3;
        int[][] edges = {{0, 1}, {1, 2}, {2, 0}}; // Triangle (cycle)
        System.out.println("Does the graph contain a cycle? " + detector.hasCycle(n, edges));
    }
}*/

//VIMP note 
//usually union find/disjount set used where If you need to determine whether 
//adding an edge between two nodes creates a cycle, Union-Find is a natural choice.
//so we can solve this problem using bfs offcourse bcoz at the end 
//of the day we need to detect cycle but time complexity will be different 
//so to optimise solution we can use union find 

/*class Solution {
    public int[] findRedundantConnection(int[][] edges) {

        int n = edges.length;
        List<List<Integer>> graph = new ArrayList<>();

        // Initialize the graph
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // Process each edge
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            // Temporarily add the edge
            graph.get(u).add(v);
            graph.get(v).add(u);

       /* IMP
        When we add an edge [u, v] to the graph, we are essentially 
        connecting two nodes u and v. To check if this edge creates a cycle, 
        we need to determine if u and v are already connected in the graph 
        before adding this edge. If they are already connected, adding this 
        edge will create a cycle.
        */



/*


            // Check if the edge creates a cycle
            if (hasCycle(graph, u, new boolean[n + 1])) {
                return edge; // Update the redundant edge
            }
        }

        return new int[0]; // No redundant edge found
    }

    // BFS to detect cycle
    private boolean hasCycle(List<List<Integer>> graph, int start, boolean[] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start, -1});
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0];
            int parent = current[1];

            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(new int[]{neighbor, node});
                } else if (neighbor != parent) {
                    // If the neighbor is visited and not the parent, it's a cycle
                    return true;
                }
            }
        }

        return false;
    }
}*/

//see video you will understand its easy neetcode 
class Solution {
    // Parent and Rank arrays
    private int[] par;
    private int[] rank;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        par = new int[n + 1];
        rank = new int[n + 1];

        // Initialize parent and rank arrays
        for (int i = 0; i <= n; i++) {
            par[i] = i;  // Initially, each node is its own parent
            rank[i] = 1; // Initially, rank of each node is 1
        }

        // Process each edge
        for (int[] edge : edges) {
            int n1 = edge[0];
            int n2 = edge[1];
            if (union(n1, n2)==false) {
                return edge; // Return the redundant edge
            }
        }

        return new int[0]; // Return an empty array if no redundant edge is found
    }

    // Find function with path compression
    private int find(int n) {
        if (par[n] != n) {
            par[n] = find(par[n]); // Path compression
        }
        return par[n];
    }

    // Union function with rank
    private boolean union(int n1, int n2) {
        int p1 = find(n1);
        int p2 = find(n2);
        if (p1 == p2) {          
            return false; // They are already in the same component
        }
        if (rank[p1] > rank[p2]) {
            par[p2] = p1; // Union by rank
            rank[p1] += rank[p2];   
        } else {
            par[p1] = p2;
            rank[p2] += rank[p1];
        }
        return true;
    }
}

/*Example: When Union by Size is Necessary : remember to check example

Consider a problem where you need to find the largest connected component in a graph. Here, Union by Size is the better choice because it directly tracks the size of each component.

Problem:

Given a list of edges, find the size of the largest connected component in the graph.

Solution Using Union by Size:

Initialize the parent and size arrays.
For each edge, perform a union operation using Union by Size.
Keep track of the maximum size encountered during the union operations.
Example: When Union by Rank is Sufficient

Consider the problem of finding a redundant edge in a graph (the sample problem I provided earlier). Here, Union by Rank is sufficient because we only need to detect cycles, not track component sizes.

Solution Using Union by Rank:

Initialize the parent and rank arrays.
For each edge, perform a union operation using Union by Rank.
If adding an edge creates a cycle, return that edge*/
