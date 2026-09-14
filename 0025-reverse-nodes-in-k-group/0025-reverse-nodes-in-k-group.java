class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (!isvalid(head, k)) {
            return head;
        }
        ListNode curr = head;
        ListNode prev = null;
        for (int i = 0; i < k; i++) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        head.next = reverseKGroup(curr, k);
        return prev;
    }

    boolean isvalid(ListNode head, int k) {
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length >= k;
    }
}