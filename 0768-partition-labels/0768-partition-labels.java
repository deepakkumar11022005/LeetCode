class Solution {
    public List<Integer> partitionLabels(String s) {
        int n=s.length();
        int lastOccur[]=new int[28];
        Arrays.fill(lastOccur,-1);
        for(int i=0;i<n;i++)
        {
            lastOccur[s.charAt(i)-97]=i;
        }
        // System.out.println(Arrays.toString(lastOccur));
        List<Integer> res=new ArrayList<>();
        int left=0;
        int max=0;
        for(int i=0;i<n;i++)
        {
            max=Math.max(max,lastOccur[s.charAt(i)-97]);
            // System.ou
            if(i==max)
            {
              res.add(i-left+1);
              left=i+1;
            }
             
        }
        return res;
    }
}