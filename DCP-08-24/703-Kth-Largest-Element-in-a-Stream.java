class KthLargest {
    PriorityQueue<Integer> q;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k=k;
        this.q=new PriorityQueue<>();
        for(int i=0;i<nums.length;i++)
        {
            // if(i<k)
            // this.q.offer(nums[i]);
            // else
            add(nums[i]);
        }
    }
    
    public int add(int val) {
        if(q.size()<k)
        q.offer(val);
        else if(this.q.peek()<val){
            this.q.poll();
           this.q.offer(val);
        }
        return q.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */