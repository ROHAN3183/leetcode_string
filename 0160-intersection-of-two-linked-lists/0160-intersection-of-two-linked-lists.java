/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashMap<ListNode,Integer> map=new HashMap<>();
        ListNode temp1=headA;
        ListNode temp2=headB;
        while(temp1!=null){
            if(!map.containsKey(temp1)){
                map.put(temp1,temp1.val);
            }
            temp1=temp1.next;
        }
        while(temp2!=null){
            if(!map.containsKey(temp2)){
                map.put(temp2,temp2.val);
            }
            else{
                return temp2;
            }
            temp2=temp2.next;
        }
        return null;
    }
}