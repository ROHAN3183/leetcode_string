public class Solution {
    public ListNode detectCycle(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            if (list.contains(temp)) {
                return temp;
            }
            list.add(temp);
            temp = temp.next;
        }
        return null;
    }
}