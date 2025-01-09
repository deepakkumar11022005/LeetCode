class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; i++)
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        int sum = 0;
        boolean f = true;
        for (Character c : map.keySet()) {
            int count = map.get(c);
            if ((count & 1) == 0 ) {
                sum += count;
            }
            else
            {
                if(count>1)
                {
                    sum+=count-1;
                }
                 f=false;
            }
           
               
        }
        return sum + (!f ? 1 : 0);

    }
}