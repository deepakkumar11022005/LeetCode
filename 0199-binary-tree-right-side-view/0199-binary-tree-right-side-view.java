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
    List<Integer> node;
    public void dfs(TreeNode root,int level)
    {
        if(root==null) return;
        if(node.size()==level) node.add(root.val);
        dfs(root.right,level+1);
        dfs(root.left,level+1);
    }
    public List<Integer> rightSideView(TreeNode root) {
        node=new ArrayList<>();
        if(root==null) return node;
        dfs(root,0);
        return node;
    }
}