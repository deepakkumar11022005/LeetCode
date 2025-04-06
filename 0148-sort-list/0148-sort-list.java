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
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode prev=null , slow=head,past=head;
        while(past!=null && past.next!=null)
        {
            prev=slow;
            slow=slow.next;
            past=past.next.next;
        }
        prev.next=null;
        ListNode l1=sortList(head);
        ListNode l2=sortList(slow);
        return merge(l1,l2);
    }
    public ListNode merge(ListNode l1,ListNode l2)
    {
        ListNode head=new ListNode(0);
        ListNode temp=head;
        while(l1!=null && l2!=null)
        {
            if(l1.val<=l2.val)
            {
                temp.next=l1;
                l1=l1.next;
            }
            else{
                temp.next=l2;
                l2=l2.next;
            }
            temp=temp.next;
        }
        while(l1!=null)
        {
            temp.next=l1;
            l1=l1.next;
            temp=temp.next;
        }
        while(l2!=null)
        {
            temp.next=l2;
            l2=l2.next;
            temp=temp.next;
        }
        return head.next;
    }
}