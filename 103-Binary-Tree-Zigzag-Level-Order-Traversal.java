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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
         List<List<Integer>> res=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
          if(root==null) return res;
        q.add(root);
       
       int flag=1;
        while(!q.isEmpty()){
            List<Integer> ds=new ArrayList<>();
            int n=q.size();
           
            for(int i=0;i<n;i++)
            {
                if(q.peek().left!=null) q.add(q.peek().left);
                if(q.peek().right!=null) q.add(q.peek().right);
                ds.add(q.poll().val);
            }
             if(flag==1){
                 res.add(ds);
                 flag=0;
            }
            else
            {
                Collections.reverse( ds);
                res.add(ds);
                flag=1;
            }
           
        }
        return res;
    }
}