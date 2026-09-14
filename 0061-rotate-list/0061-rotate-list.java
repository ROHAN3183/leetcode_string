class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head;
        int n = 0;
        ListNode tail = null;
        while (temp != null) {
            n++;
            tail = temp;
            temp = temp.next;
        }
        k = k % n;
        if (k <= 0) {
            return head;
        }
        int pos = n - k;
        temp = head;
        ListNode prev = null;
        while (pos > 0) {
            pos--;
            prev = temp;
            temp = temp.next;
        }
        prev.next = null;
        tail.next = head;
        return temp;
    }
}