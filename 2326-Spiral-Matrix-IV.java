/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int top=0;
        int bottom=m-1;
        int left=0;
        int right=n-1;
        int nums[][]=new int[m][n];
        for(int i=0;i<m;i++)
        Arrays.fill(nums[i],-1);
        while(left <= right && top <= bottom){
            int l=left;
            while(l<=right&& head!=null){
                nums[top][l++]=head.val;
                head=head.next;
            
            }
            top++;
           int t=top;
            while(t<=bottom && head!=null){
                 nums[t++][right]=head.val;
                head=head.next;
            }
            right--;
            int r=right;
             if (top <= bottom) {
            while(r>=left && head!=null){
                nums[bottom][r--]=head.val;
                head=head.next;
            }
            bottom--;}
            if (left <= right) {
            int b=bottom;
            while(b>=top&& head!=null){
                nums[b--][left]=head.val;
                head=head.next;
            }
            left++;}
        }
        return nums;
        
    }
}