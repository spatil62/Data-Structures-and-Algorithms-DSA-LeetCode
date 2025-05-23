class Solution {
    public String minWindow(String s, String t) {
        /*int need = 0;
        int have = t.length();
        int min = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;

        if(t.length()>s.length())
        return "";

        HashMap<Character, Integer> t_map = new HashMap<>();
        HashMap<Character, Integer> s_map = new HashMap<>();


        for(int i=0;i<t.length();i++)
        t_map.put(t.charAt(i), t_map.getOrDefault(t.charAt(i),0)+1);

        int first = 0;
        int second = 0;

        for(int i=0;i<s.length();i++)
        {
            if(t_map.containsKey(s.charAt(second)))
            {
            s_map.put(s.charAt(second),s_map.getOrDefault(s.charAt(second), 0)+1);
                if(s_map.get(s.charAt(second))<=t_map.get(s.charAt(second)))
                {
                    need += 1;
                     while(need==have)
                    {
                        int len = second-first+1;
                        if(min>len)
                        {
                            start = first;
                            end = second;
                            System.out.println("start :  " + first + "  end : " + second );
                        }

                        if(t_map.containsKey(s.charAt(first))){
                            s_map.put(s.charAt(first), s_map.get(s.charAt(first))-1);
                                if(t_map.get(s.charAt(first))>s_map.get(s.charAt(first))){
                                    need--;
                                }
                            }
                        first = first+1;
                    }
                }   
            }
            second++;
        }

        return s.substring(start, end + 1);
    }
}
*/

 
 // The result array stores the start and end indexes of the minimum window
        int[] result = new int[2];
        // Initialize the result to an invalid window (negative length)
        result[0] = result[1] = -1;
        
        int start = 0;  // Start index of the window
        int len = Integer.MAX_VALUE;  // Minimum length of the valid window
        int have = 0;  // Number of valid characters in the current window
        int need = t.length();  // Total number of characters we need to match
        
        // Maps to count the frequency of characters in t and the current window
        HashMap<Character, Integer> tMap = new HashMap<>();
        HashMap<Character, Integer> sMap = new HashMap<>();
        
        // Build the frequency map for characters in t
        for (int i = 0; i < t.length(); i++) 
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        
        // Start sliding window technique
        for (int end = 0; end < s.length(); end++) {
            char endChar = s.charAt(end);
            
            // If the character is in t, update the window map
            if (tMap.containsKey(endChar)) {
                sMap.put(endChar, sMap.getOrDefault(endChar, 0) + 1);
                
                // If the character count in the window matches or exceeds the count in t
                if (sMap.get(endChar) <= tMap.get(endChar)) 
                    have++;
            }
            
            // Shrink the window until it no longer satisfies the condition
            while (have == need) {
                // Update the result if the current window is smaller
                if (end - start + 1 < len) {
                    result[0] = start;
                    result[1] = end;
                    len = end - start + 1;
                }
                
                // Try to reduce the size of the window from the left
                char startChar = s.charAt(start);
                if (tMap.containsKey(startChar)) {
                    sMap.put(startChar, sMap.get(startChar) - 1);
                    // If the window no longer satisfies the condition for this character, decrement `have`
                    if (sMap.get(startChar) < tMap.get(startChar)) 
                        have--;
                }
                
                start++;
            }
        }
        
        // If no valid window was found, return an empty string
        if (result[0] == -1) {
            return "";
        }
        
        // Return the substring representing the minimum window
        return s.substring(result[0], result[1] + 1);
    }
}




