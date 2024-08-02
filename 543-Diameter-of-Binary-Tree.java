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
    HashSet<Integer> set=new HashSet<>();
    public int diameterOfBinaryTree(TreeNode root) {
         check(root);
         int max=Integer.MIN_VALUE;
         for(Integer i:set)
         max=Math.max(max,i);
        return max;
    }
    public int check(TreeNode root){
        if(root==null) return 0;
       int  lh=check(root.left);
       int  rh=check(root.right);
       set.add(lh+rh);
       return 1+Math.max(lh,rh);
    }
}