class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int maxFreq = 0;
        int maxLength = 0;
        
        int[] charCount = new int[26]; // Array to count each character's frequency
        
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            charCount[currentChar - 'A']++; // Increment the count of the current character
            maxFreq = Math.max(maxFreq, charCount[currentChar - 'A']); // Update max frequency in the window
            
            // If more than `k` characters need to be replaced, shrink the window
            if ((right - left) - maxFreq >= k) {
                charCount[s.charAt(left) - 'A']--; // Reduce the frequency of the leftmost character
                left++; // Move the left pointer to shrink the window
            }
            
            // Update maxLength to be the maximum size of the window
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;


        //with extra space using hashmaps
        /*int start = 0;
        int maxFreq = 0;
        int maxLength = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        for(int end=0;end<s.length();end++){
            map.put(s.charAt(end),map.getOrDefault(s.charAt(end),0)+1);
            maxFreq = Math.max(maxFreq, map.get(s.charAt(end)));

            if((end-start+1)-maxFreq>k){
                map.put(s.charAt(start),map.get(s.charAt(start))-1);
                start++;
            }
        
          maxLength = Math.max(maxLength, end-start+1);

        }
        return maxLength;*/
    }
}
