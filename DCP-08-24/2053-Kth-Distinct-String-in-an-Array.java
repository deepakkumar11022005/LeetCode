class Solution {
    public String kthDistinct(String[] arr, int k) {
        HashMap<String,Integer> l=new HashMap<>();
        for(String s:arr)
        if(l.containsKey(s))
        {
            l.put(s,l.get(s)+1);
        }
        else
        l.put(s,1);
         
        int distinctCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (l.get(arr[i]) == 1) {
                distinctCount++;
            }
            if (distinctCount == k) {
                return arr[i];
            }
        }
        return "";
    }
}