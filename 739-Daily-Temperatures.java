class Solution {
    public int[] dailyTemperatures(int[] nums) {
       int n=nums.length;
        int arr[]=new int[n];
        Stack<Integer> l=new Stack<>();
        int j=0;
        l.push(0);
        for(int i=1;i<n;i++)
        {
            if(l.isEmpty())
            {
                l.push(i);
                continue;
            }
            while(!l.isEmpty() && nums[l.peek()]<nums[i])
            {
                arr[l.peek()]=i-l.peek();
            //    System.out.println(i-l.peek());
                // System.out.println(l.peek()+" ---- "+(i-res.indexOf(l.peek()))+"========="+nums[i]);
                l.pop();
            }
            l.push(i);
        }
        return arr;
    }
}