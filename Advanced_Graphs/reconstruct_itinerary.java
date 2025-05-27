class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {

       /*// Step 1: Build the graph
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        // Iterate through the list of tickets
        for (List<String> ticket : tickets) {
            String from = ticket.get(0); // Departure airport
            String to = ticket.get(1);   // Arrival airport

            // Check if the graph already contains the departure airport
            if (!graph.containsKey(from)) {
                graph.put(from, new PriorityQueue<>()); // Initialize a new priority queue for this airport
            }

            // Add the arrival airport to the priority queue
            graph.get(from).add(to);
        }

        // Step 2: Perform BFS to reconstruct the itinerary
        LinkedList<String> itinerary = new LinkedList<>();
        Deque<String> stack = new ArrayDeque<>();
        stack.push("JFK");

        while (!stack.isEmpty()) {
            String current = stack.peek();
            if (graph.containsKey(current) && !graph.get(current).isEmpty()) {
                stack.push(graph.get(current).poll()); // Push next destination
            } else {
                itinerary.addFirst(stack.pop()); // Backtrack and add to the itinerary
            }
        }

        return itinerary;*/

        
         // Step 1: Build the graph
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        // Iterate through the list of tickets
        for (List<String> ticket : tickets) {
            String from = ticket.get(0); // Departure airport
            String to = ticket.get(1);   // Arrival airport

            // Check if the graph already contains the departure airport
            if (!graph.containsKey(from)) {
                graph.put(from, new PriorityQueue<>()); // Initialize a new priority queue for this airport
            }

            // Add the arrival airport to the priority queue
            graph.get(from).add(to);
        }

        // Step 2: Perform DFS to reconstruct the itinerary
        LinkedList<String> itinerary = new LinkedList<>();
        Stack<String> stack = new Stack<>();  // Using Stack instead of Deque
        stack.push("JFK");

        while (!stack.isEmpty()) {
            String current = stack.peek();
            if (graph.containsKey(current) && !graph.get(current).isEmpty()) {
                stack.push(graph.get(current).poll()); // Push next destination
            } else {
                itinerary.addFirst(stack.pop()); // Backtrack and add to the itinerary
            }
        }

        return itinerary;
    }

