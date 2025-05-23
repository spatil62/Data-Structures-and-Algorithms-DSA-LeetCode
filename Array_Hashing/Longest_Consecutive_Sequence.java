
class Solution {
    public int longestConsecutive(int[] nums) {
        //brute force just to tell them 
        /*
        import java.util.Arrays;

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        Arrays.sort(nums); // Step 1: sort the array
        int longest = 1;
        int currentStreak = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue; // Skip duplicates
            } else if (nums[i] == nums[i - 1] + 1) {
                currentStreak++; // Consecutive
            } else {
                longest = Math.max(longest, currentStreak);
                currentStreak = 1; // Reset streak
            }
        }

        return Math.max(longest, currentStreak); // Return the max streak found
    }
}

        */
        HashSet<Integer> set = new HashSet<>();

        // Add all elements to the set
        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;

        // Check for the start of a sequence
        for (int num : set) {
            if (!set.contains(num - 1)) { // Only start from the beginning of a sequence
                int currentNum = num;
                int currentStreak = 1;

                // Count the streak
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                longest = Math.max(longest, currentStreak);
            }
        }

        return longest;
    }
}

