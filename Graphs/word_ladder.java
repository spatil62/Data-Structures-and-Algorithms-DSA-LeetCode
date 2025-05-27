class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Queue<String> q = new LinkedList<>();

        HashSet<String> set = new HashSet<>(wordList);

        if(!set.contains(endWord))
        return 0;

        q.add(beginWord);
        int level = 1;

        while(!q.isEmpty())
        {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                String q_string = q.poll();

            for(int j=0;j<q_string.length();j++)
            {
                //String q_string = q.poll();  
                char[] Converted_char_array = q_string.toCharArray();     

                for(char value = 'a'; value<='z' ; value++)
                {
                    Converted_char_array[j]=value;
                    String Converted_back_string = new String(Converted_char_array);

                    if (Converted_back_string.equals(endWord)) 
                        return level+1; // Found the shortest path
        
                    if(set.contains(Converted_back_string))
                    {
                        q.add(Converted_back_string);
                        set.remove(Converted_back_string);
                    }
                }
            }

        }
            level++;
    }
    return 0;
    }
}
