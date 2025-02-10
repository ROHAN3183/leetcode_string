import java.util.Stack;

class Solution {
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;

        // Step 1: Traverse the list and push nodes onto the stack
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }

        // Step 2: Maintain the maximum value seen so far (right to left)
        ListNode newHead = null;
        int maxSoFar = Integer.MIN_VALUE;

        while (!stack.isEmpty()) {
            ListNode node = stack.pop();
            if (node.val >= maxSoFar) {
                maxSoFar = node.val;
                node.next = newHead;
                newHead = node;
            }
        }

        return newHead;
    }
}
