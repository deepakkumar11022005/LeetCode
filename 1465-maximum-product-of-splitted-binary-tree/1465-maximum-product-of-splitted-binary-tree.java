/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    long sum = 0;
    int mod = 1000000007;
    long max=0;
    public int Sum(TreeNode root) {
        if (root == null)
            return 0;
        return root.val += Sum(root.left) + Sum(root.right);
    }
    public void dfs(TreeNode root)
    {
        if(root==null) return;
        max=Math.max(max,root.val*(sum-root.val));
        dfs(root.left);
        dfs(root.right);
    }
    public int maxProduct(TreeNode root) {
        sum = Sum(root);
        dfs(root);
        return (int) (max % mod);

    }
}