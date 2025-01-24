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
        String str=""+root.val+","+dfs(root.left)+","+dfs(root.right);
        // System.out.println(str);
        map.put(str,map.getOrDefault(str,0)+1);
        if(map.get(str)==2)
        {
            System.out.println(map);
            res.add(root);
        }
        return str;
    }
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return res;
    }
}