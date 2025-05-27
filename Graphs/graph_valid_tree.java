    /* Note imp : 
//here need to check two thing all nodes are connected : vis array
//no cycle : parent way or bcoz its a tree modified khans algo

Modified Kahn's Algorithm Works for Trees:
It works because trees have exactly n - 1 edges and are connected.
Leaf nodes (degree 1) are processed first, and all nodes are eventually processed.
It Fails for General Cycle Detection:
In general undirected graphs, cycles can exist even if all nodes have degree > 1.
The algorithm cannot handle such cases. use parent child method.
Use the Right Tool for the Job:
For tree validation, the modified Kahn's algorithm works.
For general cycle detection, use BFS/DFS with parent tracking.
*/



/*A tree is a special type of undirected graph with the following properties:

Connected: There is exactly one path between any two nodes.
Acyclic: There are no cycles.
Exactly n−1 Edges: A tree with n nodes has exactly n−1 edges

so even though its undirected it will work bcoz of above things*/

/*Your understanding is correct: the modified Kahn's algorithm works for trees but not for general undirected graphs. For general graphs, BFS/DFS with parent tracking is the correct approach for cycle detection and connected component analysis.*/

//compare example last 4 problems except word ladder 

        //target was to check acyclic so i used khans principle 
        //logic just change is bidirectional so added both directions
        //bcoz of that queue i need to add 1 indegree thing bcoz 0 
        //will not support bcoz of bidirection

//Tip new way below using parent that to easy one
//every node just maintain its parent in a queue thats it


class Solution {
    public boolean validTree(int n, int[][] edges) {
        //edge cases is very imp these two remember 
        // Special case: A single node with no edges is a valid tree
        if (n == 1 && edges.length == 0) {
            return true;
        }

        // A valid tree must have exactly n - 1 edges
        if (edges.length != n - 1) {
            return false;
        }

        // Step 1: Build the graph and calculate the in-degrees
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[n];
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
            inDegree[edge[0]]++;
            inDegree[edge[1]]++;
        }

        // Step 2: Initialize the queue with nodes of degree 1 (leaf nodes)
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 1) {
                queue.add(i);
            }
        }

        // Step 3: Process the nodes
        int processedNodes = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            processedNodes++;

            for (int neighbor : graph.get(node)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 1) {
                    queue.add(neighbor);
                }
            }
        }

        // Step 4: Check if all nodes were processed
        return processedNodes == n;
    }
}

/*//other way 
// Build the graph using an adjacency list
         // Build the graph
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

        // Check for cycles and connectedness
        if (bfsDetectCycle(graph, 0, visited)) {
            return false; // Cycle detected, not a valid tree
        }

        // Check if all nodes are visited (graph is connected)
        for (boolean v : visited) {
            if (!v) {
                return false; // Graph is disconnected, not a valid tree
            }
        }

        return true; // No cycles and graph is connected, it's a valid tree
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
}*/

