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
    public List<Integer> largestValues(TreeNode root) {
        if(root==null)
        return new ArrayList<>();
        List<Integer> res=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.add( root);
        while(!q.isEmpty()){
            int n=q.size();
            int max=Integer.MIN_VALUE;
            for(int i=0;i<n;i++){
                TreeNode temp=q.poll();
                if(temp.left!=null)
                q.add(temp.left);
                if(temp.right!=null)
                q.add(temp.right);
                max=Math.max(max,temp.val);
            }
            res.add(max);
        }
         return res;
    }
   

}