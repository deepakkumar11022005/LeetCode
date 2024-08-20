class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(Character c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
       
        // List<Map.Entry<Character,Integer>> l=new LinkedList<>(map.entrySet());
        // Collections.sort(l,(e1,e2)-> e2.getValue().compareTo(e1.getValue()));
        List<Character> l=new ArrayList<>(map.keySet());
        l.sort((e1,e2)-> map.get(e2)-map.get(e1));
       StringBuilder sb = new StringBuilder(\\);
        for(char ch:l)
        {
            for(int j=0;j<map.get(ch);j++)
              sb.append(ch);
        }
        return sb.toString();
    }
}