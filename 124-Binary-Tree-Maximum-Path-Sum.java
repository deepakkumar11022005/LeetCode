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
    HashSet<Integer> set =new HashSet<>();
    public int maxPathSum(TreeNode root) {
        check(root);
        int max=Integer.MIN_VALUE;  
        for(Integer i:set)
        max=Math.max(i,max);
        return max;
    }
    public int check(TreeNode root)
    {
        if(root==null) return 0;
         int lh=Math.max(0,check(root.left));
        int rh=Math.max(0,check(root.right));
        set.add(lh+rh+root.val);
        return  root.val+Math.max(rh,lh);
    }
}