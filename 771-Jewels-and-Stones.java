class Solution {
    public int numJewelsInStones(String j, String s) {
         int c=0;
        for(char i:s.toCharArray()){
            if(j.contains(String.valueOf(i)))
            c++;
        }
        return c;
    }
}