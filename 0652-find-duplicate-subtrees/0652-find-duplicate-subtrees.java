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
    HashMap<String,Integer> map=new HashMap<>();
    List<TreeNode> res=new ArrayList<>();
    public String dfs(TreeNode root)
    {
        if(root==null) return "#";
        StringBuilder str=new StringBuilder();
        str.append(root.val+",");
        str.append(dfs(root.left)+",");
        str.append(dfs(root.right));
        // String str=""+root.val+","+dfs(root.left)+","+dfs(root.right);
        // System.out.println(str);
        map.put(str.toString(),map.getOrDefault(str.toString(),0)+1);
        if(map.get(str.toString())==2)
        {
            // System.out.println(map);
            res.add(root);
        }
        return str.toString();
    }
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return res;
    }
}