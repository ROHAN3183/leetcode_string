public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashMap<ListNode, Boolean> map = new HashMap<>();
        ListNode temp1 = headA;
        ListNode temp2 = headB;
        while (temp1 != null || temp2 != null) {
            if (map.containsKey(temp1)) {
                return temp1;
            }
            if (temp1 != null) {
                map.put(temp1, true);
            }
            if (map.containsKey(temp2)) {
                return temp2;
            }
            if (temp2 != null) {
                map.put(temp2, true);
            }
            if (temp1 != null) {
                temp1 = temp1.next;
            }
            if (temp2 != null) {
                temp2 = temp2.next;
            }
        }
        return null;
    }
}