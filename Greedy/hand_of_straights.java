class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {

        // Edge case: if the length of the hand isn't divisible by groupSize, it's impossible to rearrange
        if (hand.length % groupSize != 0) {
            return false;
        }

        // PriorityQueue to act as a min-heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        // Map to store the frequency of each card
        Map<Integer, Integer> map = new HashMap<>();
        
        // Fill the map with the frequency of each card
        for (int i = 0; i < hand.length; i++) {
            map.put(hand[i], map.getOrDefault(hand[i], 0) + 1);
            pq.add(hand[i]);
        }

        // Process each card in the min-heap and try to form groups
        while (!pq.isEmpty()) {
            // Get the smallest card in the priority queue
            int start = pq.poll();

            // If the card is already used (i.e., frequency is 0), skip it
            if (map.get(start) == 0) {
               continue;
            }

            // Try to form a group starting from 'start'
            for (int i = 0; i < groupSize; i++) {
                // Check if the card i+start exists and is available
                if (map.getOrDefault(start + i, 0) == 0) {
                    return false;
                }

                // Decrease the frequency of the current card
                map.put(start + i, map.get(start + i) - 1);
            }
        }

        return true;
    }
}
