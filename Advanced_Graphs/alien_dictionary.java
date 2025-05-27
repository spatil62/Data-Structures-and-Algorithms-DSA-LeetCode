class Solution {
    public String foreignDictionary(String[] words) {
/*
        // Step 1: Create a graph
        Map<Character, List<Character>> graph = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();
        
        // Initialize the graph
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new ArrayList<>());
                inDegree.putIfAbsent(c, 0);
            }
        }
        
        // Step 2: Build the graph
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            
            // Check if the order is invalid
            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return ""; // Invalid order
            }
            
            // Find the first difference
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                char parent = word1.charAt(j);
                char child = word2.charAt(j);
                if (parent != child) {
                    graph.get(parent).add(child);
                    inDegree.put(child, inDegree.get(child) + 1);
                    break;
                }
            }
        }
        
        // Step 3: Perform BFS
        Queue<Character> queue = new LinkedList<>();
        StringBuilder order = new StringBuilder();
        
        // Add all nodes with in-degree 0 to the queue
        for (char c : inDegree.keySet()) {
            if (inDegree.get(c) == 0) {
                queue.offer(c);
            }
        }
        
        while (!queue.isEmpty()) {
            char current = queue.poll();
            order.append(current);
            for (char neighbor : graph.get(current)) {
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                if (inDegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        
        // Check if all characters are included
        if (order.length() < inDegree.size()) {
            return ""; // Cycle detected
        }
        
        return order.toString();
    }
}*/

/*
 // Step 1: Initialize the adjacency list and in-degree array
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        int[] inDegree = new int[26];
        boolean[] present = new boolean[26]; // To track which characters are in the input
        
        for (int i = 0; i < 26; i++) {
            adjList.add(new ArrayList<>());
        }
        
        // Step 2: Populate the adjacency list based on the words
        for (String word : words) {
            for (char c : word.toCharArray()) {
                present[c - 'a'] = true; // Mark the character as present
            }
        }
        
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            
            // Check if the order is invalid
            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return ""; // Invalid order
            }
            
            // Find the first difference
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                char parent = word1.charAt(j);
                char child = word2.charAt(j);
                if (parent != child) {
                    adjList.get(parent - 'a').add(child - 'a');
                    inDegree[child - 'a']++;
                    break;
                }
            }
        }
        
        // Step 3: Perform BFS
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder order = new StringBuilder();
        
        // Add all nodes with in-degree 0 to the queue
        for (int i = 0; i < 26; i++) {
            if (present[i] && inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            order.append((char) (current + 'a'));
            for (int neighbor : adjList.get(current)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        
        // Check if all characters are included
        for (int i = 0; i < 26; i++) {
            if (present[i] && inDegree[i] > 0) {
                return ""; // Cycle detected
            }
        }
        
        return order.toString();
    }
}*/

    //1. Graph create
    //2. graph fill adj list 
    //3. topo sort 

    //instead of adj list created graph easy to access char 
    HashMap<Character, List<Character>> graph = new HashMap<Character, List<Character>>();
    HashMap<Character, Integer> inDegree = new HashMap<Character, Integer>();

    for(String word:words)
        for(Character C : word.toCharArray())
        {
            graph.putIfAbsent(C, new ArrayList<>());
            inDegree.putIfAbsent(C, 0);
        }

    //creation of adj list
    for(int i=0;i<words.length-1;i++)
        {
            String word1 = words[i];
            String word2 = words[i+1];

            if(word1.length()>word2.length() && word1.startsWith(word2))
            return "";

            for(int j=0;j<Math.min(word1.length(), word2.length());j++)
                {
                    char parent = word1.charAt(j);
                    char child = word2.charAt(j);
                    if(parent!= child)
                        {
                            graph.get(parent).add(child);
                            inDegree.put(child, inDegree.get(child)+1);
                            break;
                        }
                }

        }

    //Topo sort 
    Queue<Character> q = new LinkedList<>();
    StringBuilder st = new StringBuilder();

    for(char c : inDegree.keySet())
        if(inDegree.get(c)==0)
            q.add(c);

    while(!q.isEmpty())
    {
        char Value = q.poll();
        st.append(Value);

        for(char neighbor : graph.get(Value))
        {
            inDegree.put(neighbor, inDegree.get(neighbor)-1);
            if(inDegree.get(neighbor)==0)
                q.add(neighbor);
        }
    }       

    if(st.length()<inDegree.size())
        return "";

    return st.toString();
    }
}
