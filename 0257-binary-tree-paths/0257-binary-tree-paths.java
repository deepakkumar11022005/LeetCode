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
    public void dfs(TreeNode root, List<String> res,StringBuilder str)
    {
        if(root==null) return;
        int len=str.length();
        if(root.left==null && root.right==null)
        {
            str.append(root.val);
            res.add(str.toString());
             str.setLength(len);
            return;
        }
        str.append(root.val+"->");
        dfs(root.left,res,str);
        dfs(root.right,res,str);
        str.setLength(len);
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res=new ArrayList<>();
        StringBuilder str=new StringBuilder();
         
        dfs(root,res,str);
        return res;
    }
}