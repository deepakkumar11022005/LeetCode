class Solution {
    public int minimumPushes(String s) {
        
        int n=s.length();
        LinkedHashMap<Character,Integer> map =new LinkedHashMap<>();
        for(int i=0;i<n;i++)
        {
             map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        List<Map.Entry<Character, Integer>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));
        int sum=0;
        int i=0;
        int pop=1;
        for (Map.Entry<Character, Integer> entry : entryList) {
            if(i>=8)
            {
                pop++;
                i=0;
            }
           int c=entry.getKey();
           int v=entry.getValue();
            sum+=v*pop;
            i++;

        }
        return sum;
    }
}