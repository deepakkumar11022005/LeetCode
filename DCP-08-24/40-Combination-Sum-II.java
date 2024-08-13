class Solution {
    public void   com( Set<List<Integer>> res, int[]  arr,int i,int k, List<Integer> ds){
            if(i==arr.length)
            {
                 if( k==0){
                res.add(new ArrayList<>(ds ));
                          }
                return;
            }
            if(k==0){
            res.add(new ArrayList<>(ds));
            return;
            }
           
           for (int j = i; j < arr.length; j++) {
            if (j > i && arr[j] == arr[j - 1]) continue;  

            if (arr[j] > k) break;  

            ds.add(arr[j]);
            com(res, arr, j + 1, k - arr[j], ds);
            ds.remove(ds.size() - 1);  
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        Set<List<Integer>> res =new HashSet<>();
        com(res,candidates,0,target,new ArrayList<>());
        return new ArrayList<>(res);
    }
}