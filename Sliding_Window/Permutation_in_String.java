class Solution {
    public boolean checkInclusion(String s1, String s2) {

        //so we used sliding window in earlier example so 
        //I used same pattern here as well 
        //its a sliding window pattern remember 
        //whenever there wil be sliding window pattern like below 
        //check limitations sometimes its capital letters only
        //it will reduce space and so you can use char[26]

        if (s1.length() > s2.length()) return false;

        int[] s1Freq = new int[26];
        int[] s2Freq = new int[26];

        // build s1 frequency map
        for (int i = 0; i < s1.length(); i++) {
            s1Freq[s1.charAt(i) - 'a']++;
        }

        int start = 0;
        for (int end = 0; end < s2.length(); end++) {
            s2Freq[s2.charAt(end) - 'a']++;

            // shrink window if it exceeds s1's length
            //always write down limiting condition first
            if (end - start + 1 > s1.length()) {
                s2Freq[s2.charAt(start) - 'a']--;
                start++;
            }

            // compare when window is the correct size
            if (end - start + 1 == s1.length()) {
                if (Arrays.equals(s1Freq, s2Freq)) return true;
            }
        }

        return false;

        /*
        second way of doing it
        if(s1.length()>s2.length())
        return false;

        int[] s1Freq = new int[26];
        int[] s2Freq = new int[26];

        for(int i=0;i<s1.length();i++)
        s1Freq[s1.charAt(i)-'a']++;

        for(int i=0;i<s1.length();i++)
        s2Freq[s2.charAt(i)-'a']++;

        if(Arrays.equals(s1Freq, s2Freq))
        return true;

        for(int i=s1.length();i<s2.length();i++)
        {
            s2Freq[s2.charAt(i)-'a']++;
            s2Freq[s2.charAt(i - s1.length()) - 'a']--;

            if(Arrays.equals(s1Freq, s2Freq))
            return true;
        }

        return false;*/






       /* 
       Third way of doing it
       if (s1.length() > s2.length()) {
            return false;
        }

        // Frequency array for s1 and the sliding window
        int[] s1Freq = new int[26];
        int[] windowFreq = new int[26];

        // Populate the frequency array for s1
        for (char c : s1.toCharArray()) {
            s1Freq[c - 'a']++;
        }

        // Initialize the sliding window for the first s1.length() characters
        for (int i = 0; i < s1.length(); i++) {
            windowFreq[s2.charAt(i) - 'a']++;
        }

        // Check if the initial window matches s1
        if (Arrays.equals(s1Freq, windowFreq)) {
            return true;
        }

        // Start sliding the window
        for (int i = s1.length(); i < s2.length(); i++) {
            // Add the new character to the window
            windowFreq[s2.charAt(i) - 'a']++;

            // Remove the character that goes out of the window
            windowFreq[s2.charAt(i - s1.length()) - 'a']--;

            // Check if the current window matches s1
            if (Arrays.equals(s1Freq, windowFreq)) {
                return true;
            }
        }

        // No matching permutation found
        return false;*/

    }
}

