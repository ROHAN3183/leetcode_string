/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
#BRUTE CODE
    
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        Set<Integer>set=new LinkedHashSet<>();
        ListNode temp=head;
        while(temp!=null){
            set.add(temp.val);
            temp=temp.next;
        }
        temp=head;
        ListNode prev=null;
      for(int i:set){
        temp.val=i;
        prev=temp;
        temp=temp.next;
      }
      prev.next=null;
      return head;
    }
}
# OTIMIZED CODE
    
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        
        if(head==null || head.next==null){
            return head;
        }
        ListNode current=head.next;
        ListNode prev=head;
        while(current!=null){
            if(current.val!=prev.val){
                prev.next=current;
                prev=current;
            }
            current=current.next;
        }
        prev.next=null;
        return head;
    }
}
