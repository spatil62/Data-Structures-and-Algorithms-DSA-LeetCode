class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for(String str : strs){
            char[] string_to_array = str.toCharArray();
            Arrays.sort(string_to_array);
            String new_str = new String(string_to_array);
            if(!map.containsKey(new_str))
            map.put(new_str, new ArrayList<>());

            map.get(new_str).add(str);
        }
        
        return new ArrayList<>(map.values());
    }
}
