class Solution {
    public Node flatten(Node head) {
        if (head == null) {
            return head;
        }
        if (head.child == null && head.next == null) {
            return head;
        }
        Node temp = head;
        while (temp != null) {
            if (temp.child != null) {

                Node nextNode = temp.next;
                temp.next = flatten(temp.child);
                temp.next.prev = temp;
                temp.child = null;

                while (temp.next != null) {
                    temp = temp.next;
                }
                
                if (nextNode != null) {
                    temp.next = nextNode;
                    nextNode.prev = temp;
                }
            }
            temp = temp.next;
        }
        return head;
    }
}