/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] nums) {
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            ListNode head = nums[i];
            while (head != null) {
                q.offer(head.val);
                head = head.next;
            }
        }
       
        ListNode res = new ListNode();
        ListNode temp=res;
         while(!q.isEmpty()){
            temp.next=new ListNode(q.poll());
           temp=temp.next;
        //  System.out.println(q.poll());
        }
        
        return res.next;
    }
}