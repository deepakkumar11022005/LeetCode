/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void dfs(TreeNode root, PriorityQueue<Integer> q)
    {
        if(root!=null)
        {
          dfs(root.left,q);
          q.add(root.val);
          dfs(root.right,q);
        }
        
    }
    public int getMinimumDifference(TreeNode root) {
        if(root==null) return 0;
        PriorityQueue<Integer> q=new PriorityQueue<>();
        dfs(root,q);
        int min=Integer.MAX_VALUE;
        int n=q.size();
        for(int i=0;i<n-1;i++)
        {
            min=Math.min(min,Math.abs(q.poll()-q.peek()));
        }
        
        return min;
    }
}