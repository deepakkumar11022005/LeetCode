class Solution {

    // public void dfs(int index,int arr[],HashMap<Integer,Integer> map,int val1,int
    // val2,int count)
    // {
    // if(index>=arr.length)
    // {
    // max=Math.max(max,count);
    // return;
    // }
    // if(val1+val2==arr[index])
    // {
    // dfs(index+1,arr,map,val2,arr[index],count+1);
    // }
    // else
    // {
    // dfs(index+1,arr,map,val1,val2,count);
    // }
    // }
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++)
            set.add(arr[i]);
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int count = 0;
                int num1 = arr[i];
                int num2 = arr[j];

                // System.out.print(a+" "+b+" ");
                while (set.contains(num1+num2)) {
                    int num3 = num2 + num1;
                    num1 = num2;
                    num2 = num3;
                   count++;
                }
                max = Math.max(max, count);
                // System.out.println("");
            }
        }
        return max == 0 ? 0 : max + 2;
    }
}