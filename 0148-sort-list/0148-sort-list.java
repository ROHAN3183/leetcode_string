class Solution {
    class info {
        ListNode node;
        int data;

        info(ListNode node, int data) {
            this.node = node;
            this.data = data;
        }
    }

    public ListNode sortList(ListNode head) {
        List<info> list = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            list.add(new info(temp, temp.val));
            temp = temp.next;
        }
        Collections.sort(list, (a, b) -> Integer.compare(a.data, b.data));
        ListNode prev = new ListNode();
        ListNode result = prev;
        for (int i = 0; i < list.size(); i++) {
            ListNode curr = list.get(i).node;
            prev.next = curr;
            prev = curr;
        }
        prev.next = null;
        return result.next;
    }
}