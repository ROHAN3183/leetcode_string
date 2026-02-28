class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode even = head;
        ListNode odd = head.next;
        ListNode temp = odd;
        while (odd != null && odd.next != null) {
            even.next = odd.next;
            even = even.next;
            odd.next = even.next;
            odd = odd.next;
        }
        if (odd != null) {
            odd.next = null;
        }
        even.next = temp;
        return head;
    }
}