class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        //This logic will only check first 
        //occurance of word in thev dictionary 
        //does not check other possibilities so use dp
        /*int start = 0;
        int end = 0;

        HashSet<String> set = new HashSet<>();

        for(int i=0;i<wordDict.size();i++)
        set.add(wordDict.get(i));

        for(int i=0;i<=s.length();i++)
        {
            if(set.contains(s.substring(start,end)))
            start=end;

            end++;
        }

        System.out.println("   start : " + start + "  s.length() : " + s.length());

        if(start!=s.length())
        return false;

        return true;*/

        // Create a DP array to track valid word segmentations
        boolean[] dp = new boolean[s.length() + 1];
        dp[s.length()] = true; // Base case: an empty string is always valid

        // Iterate from the end of the string to the start
        for (int i = s.length() - 1; i >= 0; i--) {
            for (String word : wordDict) {
                
                // Check if the current substring matches the word and is valid
                if (i + word.length() <= s.length()) {
                    String sub = s.substring(i, i + word.length());
                    if (sub.equals(word)) 
                        dp[i] = dp[i + word.length()];
                }
                if (dp[i]==true) 
                    break; // No need to check further if we found a valid segmentation
            }
        }

        // Return whether the entire string can be segmented
        return dp[0];
    }
}
