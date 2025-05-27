class Solution {
    public boolean isHappy(int n) {
        int sum = 0;
        HashSet<Integer> set = new HashSet<>();

        while(n!=1)
        {
        for(;n!=0;n=n/10)
        {
            int digit = n%10;
            sum = sum + (digit*digit);
        }

        if(set.contains(sum))
        return false;
        else
            {
            set.add(sum);
            n=sum;
            sum=0;
            }     
        }
        return true;
        
    }
}
