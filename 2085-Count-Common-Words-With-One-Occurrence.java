class Solution {
    public int countWords(String[] words1, String[] words2) {
        HashMap<String ,Integer> map1=new HashMap<>();
         HashMap<String ,Integer> map2=new HashMap<>();
         int c=0;
         for(String k:words1)
         map1.put(k,map1.getOrDefault(k,0)+1);
         for(String k:words2)
         map2.put(k,map2.getOrDefault(k,0)+1);
         for(String key :map1.keySet())
         {
            if(map1.get(key)==1 ){
                if(map2.containsKey(key)){
                    if(map2.get(key)==1)
                    c++;
                }
            }
         }
         return c;
    }
}