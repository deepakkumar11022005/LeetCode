/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        while(head!=null)
        {
            
            if(head.val!=Integer.MIN_VALUE){head.val=Integer.MIN_VALUE;}
            else return true;
            head=head.next;
        }
        return  false;
    }
}