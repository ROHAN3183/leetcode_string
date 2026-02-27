class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) {
            slow = slow.next;
        }
        ListNode prev = reverse(slow);
        return isvalid(head, prev);

    }

    ListNode reverse(ListNode head) {
        ListNode next = null;
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    boolean isvalid(ListNode temp1, ListNode temp2) {
        while (temp1 != null && temp2 != null) {
            if (temp1.val != temp2.val) {
                return false;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return true;
    }
}