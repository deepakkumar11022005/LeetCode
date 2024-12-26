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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right)
            return head;
        ListNode prev, curr, next, first;
        first = head;
        for (int i = 1; i < left - 1 && first != null; i++) {
            
            first = first.next;
        }
        if (left == 1)
            curr = head;
        else
            curr = first.next;
        prev = next = null;
        right -= left;
        ListNode temp = curr;
        for (int i = 1; i <= right + 1 && curr != null; i++) {
           
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        first.next = prev;
       
         if (left == 1) head = prev;
        else first.next = prev;
        temp.next = curr;
        return head;
    }
}