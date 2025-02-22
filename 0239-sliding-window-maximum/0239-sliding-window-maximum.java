class Solution {
    public int[] maxSlidingWindow(int[] nums, int h) {
        int n=nums.length;
        int res[]=new int[n-h+1];
        Deque<Integer> q=new LinkedList<>();
        int ans=0;
        for(int i=0;i<n;i++)
        {
            if(!q.isEmpty() && q.peekFirst()==i-h)
            {
                q.pollFirst();
            }
            while(!q.isEmpty() && nums[q.peekLast()]<=nums[i])
            {
                q.pollLast();
            }
            q.offerLast(i);
            if(i>=h-1)
            {
                res[ans++]=nums[q.peekFirst()];
            }
            // System.out.println(q);
        }
        // System.out.println(Arrays.toString(res));
        return res;
    }
}