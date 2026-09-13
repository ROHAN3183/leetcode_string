public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA != null && headB!=null) {
            HashMap<ListNode, Integer> map = new HashMap<>();
            ListNode temp = headA;
            while (temp != null) {
                map.put(temp, map.getOrDefault(temp, 0) + 1);
                temp = temp.next;
            }
            temp = headB;
            while (temp != null) {
                if (map.containsKey(temp)) {
                    return temp;
                }
                temp = temp.next;
            }
        }
        else if(headA!=null){
            return headA;
        }
        else if(headB!=null){
            return headB;
        }
        return null;
    }
}