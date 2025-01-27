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
 class pair{
    int index;
    TreeNode node;
    public pair(TreeNode n,int i){
        node=n;
        index=i;
    }
 }
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int res=0;
        Queue<pair> q=new LinkedList<>();
        q.add(new pair(root,0));
        while(!q.isEmpty())
        {
            int n=q.size();
            int min=q.peek().index;
            int first=0,last=0;
            for(int i=0;i<n;i++)
            {
                pair tmp=q.poll();
                int start=tmp.index-min;
                if(i==0)
                first=start;
                if(i==n-1)
                last=start;
                if(tmp.node.left!=null)
                q.add(new pair(tmp.node.left,2*start+1));
                if(tmp.node.right!=null)
                q.add(new pair(tmp.node.right,2*start+2));
            }
            res=Math.max(res,last-first+1);
        }
        return res;
    }
}