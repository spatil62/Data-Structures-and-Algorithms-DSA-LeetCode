class Solution {
    public List<Integer> partitionLabels(String s) {
        int end = 0;
        int size = 0;

        HashMap<Character, Integer> map = new HashMap<>();
        List<Integer> output = new ArrayList<Integer>();

        for(int i=0;i<s.length();i++)
        map.put(s.charAt(i), i);
        
        end = map.get(s.charAt(0));

        for(int i=0;i<s.length();i++)
        {
            int newchar_count = map.get(s.charAt(i));

            if(i>end)
            {
                output.add(size);
                size=0;
            }

            size++;

            if(newchar_count>end)
            end = newchar_count;
        }
        output.add(size);

        return output;
        
    }
}
