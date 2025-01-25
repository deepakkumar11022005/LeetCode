class pair {
    int val;
    int index;

    public pair(int v, int in) {
        val = v;
        index = in;
    }
}

class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        pair sorted[] = new pair[n];
        for (int i = 0; i < n; i++) {
            sorted[i] = new pair(nums[i], i);
        }
        Arrays.sort(sorted, (a, b) -> (a.val - b.val));

        List<PriorityQueue<Integer>> list = new ArrayList<>();
        int c = 0;
        int index[] = new int[n];

        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        
        q.add(sorted[0].val);
        index[sorted[0].index] = c;

        for (int i = 1; i < n; i++) {
            
            if (sorted[i].val - sorted[i-1].val <= limit) {
                q.add(sorted[i].val);
                index[sorted[i].index] = c;
                // groupMax = Math.max(groupMax, sorted[i].val);  
            } else {
                c++;
                list.add(new PriorityQueue<>(q));  
                q.clear();
                q.add(sorted[i].val);
                // groupMax = sorted[i].val; 
                index[sorted[i].index] = c;
            }
        }

        if (!q.isEmpty()) {
            list.add(new PriorityQueue<>(q));
        }

        // System.out.println(Arrays.toString(index) + " " + list);

        int res[]=new int[n];
        for(int i=0;i<n;i++)
        {
        int component=index[i];
        int lexo=list.get(component).poll();
        // System.out.println(lexo);
        res[i]=lexo;

        }
        return res;
    }
}