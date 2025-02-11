import java.util.*;
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head==null){
            return null;
        }
        HashMap<ListNode,Integer>map=new LinkedHashMap<>();
        ListNode temp=head;
        while(temp!=null&&temp.next!=null){
            if(temp.val!=val){
                map.put(temp,temp.val);
            }
            temp=temp.next;
        }
        ListNode dummy=new ListNode(-1);
        ListNode prev=dummy;
        ListNode prev_null=null;
        if(map.size()>0){
            for(Map.Entry<ListNode,Integer>entry:map.entrySet()){
            prev.next=entry.getKey();
            prev_null=prev;
            prev=prev.next;
        }
          prev.next=null;
    }
        return dummy.next;
    }
}