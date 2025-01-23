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
 class pair{
    int min;
    int max;
    public pair(int mi,int ma)
    {
        min=mi;
        max=ma;
    }
 }
class Solution {
  int res;
   public pair dfs(TreeNode root)
   {
    if(root==null) return new pair(Integer.MAX_VALUE,Integer.MIN_VALUE);
    pair left=dfs(root.left);
    pair right=dfs(root.right);
    int min=Math.min(root.val,Math.min(left.min,right.min));
    int max=Math.max(root.val,Math.max(left.max,right.max));
    // System.out.println(root.val+" ** "+min+" "+max);
    res=Math.max(res,Math.max(Math.abs(root.val-min),Math.abs(root.val-max)));
    return new pair(min,max);
   }
    public int maxAncestorDiff(TreeNode root) {
        res=Integer.MIN_VALUE;
        dfs(root);
        return res;
    }
}