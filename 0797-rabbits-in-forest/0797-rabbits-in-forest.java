class Solution {
    public int numRabbits(int[] answers) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int countRabbits=0;
        for(int i:answers) map.put(i,map.getOrDefault(i,0)+1);
        for(int i:map.keySet()){
            if(i==0) countRabbits+=map.get(i);
            else if(map.get(i)<=i+1) countRabbits+=i+1;
            else{
                countRabbits+=map.get(i)/(i+1)*(i+1);
                countRabbits+=map.get(i)%(i+1)!=0 ? i+1:0;
            }
        }
        return countRabbits;
    }
}