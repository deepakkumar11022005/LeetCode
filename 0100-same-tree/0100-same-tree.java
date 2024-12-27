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
    public boolean dfs(TreeNode left, TreeNode right)
    {
        if(left==null && right==null) return true;
        if(left==null && right!=null) return false;
        if(left!=null && right==null) return false;
        if(left.val!=right.val) return false;
        return dfs(left.left ,right.left) && dfs(left.right ,right.right);
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // if(p==null && q==null) return true;
        // if(p.val!=q.val) return false;
        return dfs(p,q);
    }
}