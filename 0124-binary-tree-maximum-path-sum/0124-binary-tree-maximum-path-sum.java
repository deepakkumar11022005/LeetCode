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
    HashSet<Integer> set;

    public int pathSum(TreeNode root) {
        if (root == null)
            return 0;
        int left = Math.max(0, pathSum(root.left));
        int right = Math.max(0, pathSum(root.right));
        set.add(left + right + root.val);
        return Math.max(left , right) + root.val;
    }

    public int maxPathSum(TreeNode root) {
        set = new HashSet<>();
        pathSum(root);
        System.out.println(set);
        int max = Integer.MIN_VALUE;
        for (int i : set)
            max = Math.max(max, i);
        return max;
    }
}