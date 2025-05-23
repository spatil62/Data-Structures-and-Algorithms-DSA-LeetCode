class Solution {
    public int lengthOfLongestSubstring(String s) {
        //always for sliding window pattern make sure three things 
        //when to slide window from start
        //when to end window
        //normal other than these two what should loop do 
        
        //This is my assumption whenever we see logest string mentioned 
        //most of the time sliding window works well with it
        int maxLength = 0;
        int left = 0;
        int right = 0;

        HashSet<Character> set = new HashSet<>(); 

        while(right<s.length())
        {
            //dont forget its a while loop
            while(set.contains(s.charAt(right)))
            {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(s.charAt(right));
        
            //just dont forget to calculate length all the time 
            //not only when you encounter double char bcoz
            //what if any string does not contain any double char
            maxLength = Math.max(maxLength, right - left + 1);

            right++;
        }
        return maxLength;
    }
}


