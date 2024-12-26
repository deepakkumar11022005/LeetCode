class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;

        ListNode prev = null, curr = head, next = null, first = head;

        for (int i = 1; i < left - 1 && first != null; i++) {
            first = first.next;
        }

        if (left == 1) curr = head;
        else curr = first.next;

        prev = null;
        ListNode temp = curr;

        for (int i = 1; i <= right - left + 1 && curr != null; i++) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        if (left == 1) {
            head = prev;
        } else {
            first.next = prev;
        }
        temp.next = curr;

        return head;
    }
}
