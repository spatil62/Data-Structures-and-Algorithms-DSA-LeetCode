class Solution {

    public String encode(List<String> strs) {
        StringBuilder st = new StringBuilder();
        for(String str : strs){
            st.append(str.length());
            st.append("#");
            st.append(str);
        }
        return st.toString();
    }

    // Decodes a single string to a list of strings
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        int i = 0;

        while (i < s.length()) {
            // Find the position of the next '#'
            int j = i;
            while (s.charAt(j) != '#') {
                j++;
            }
            // Get the length of the next string
            int length = Integer.parseInt(s.substring(i, j));
            // Extract the string based on the length
            res.add(s.substring(j + 1, j + 1 + length));
            // Move to the next encoded string
            i = j + 1 + length;
        }

        return res;
    }
}

