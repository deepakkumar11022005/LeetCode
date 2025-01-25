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
    public String  dfs(TreeNode root)
    {
        if(root==null) return "#";
        String left=dfs(root.left);
        String right=dfs(root.right);
        if(!left.contains("1")) root.left=null;
        if(!right.contains("1")) root.right=null;
        String str=root.val+"->"+left+"->"+right;
        // System.out.println(str);
        return str;
    }
    public TreeNode pruneTree(TreeNode root) {
    //    String res= dfs(root);
    //    if(!res.contains("1")) return null;
    //     return root;
       if(root==null) return null;
       if(root.left==null && root.right==null && root.val==0)
       return null;
       root.left=pruneTree(root.left);
       root.right=pruneTree(root.right);
       if(root.left==null && root.right==null && root.val==0)
       return null;
       return root;

    }
}