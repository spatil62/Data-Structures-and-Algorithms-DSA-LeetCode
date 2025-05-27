class Solution {
    public boolean isAnagram(String s, String t) {
        /*char[] s_array = s.toCharArray();
        char[] t_array = t.toCharArray();

        Arrays.sort(s_array);
        Arrays.sort(t_array);

        return Arrays.equals(s_array, t_array);*/

        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0;i<s.length();i++)
        map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);

        for(int i=0;i<t.length();i++)
        {
        if(map.containsKey(t.charAt(i)))
        map.put(t.charAt(i),map.get(t.charAt(i))-1);
        else
        return false;
        }

        for(int check: map.values())
        if(check != 0)
        return false;

        return true;
    }
}
