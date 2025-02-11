                                    BRUTE FORCE LOGIC
1. The code iterates through the linked list and stores nodes (excluding those with the given value) in a **LinkedHashMap** to maintain order.  
2. It initializes a dummy node to construct the modified linked list.  
3. It links the stored nodes sequentially to form the final list.  
4. The last node's `next` is set to `null` to terminate the list.  
5. Finally, it returns the new head of the modified list (`dummy.next`).
    
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head==null){
            return null;
        }
        HashMap<ListNode,Integer>map=new LinkedHashMap<>();
        ListNode temp=head;
        while(temp!=null){
            if(temp.val!=val){
                map.put(temp,temp.val);
            }
            temp=temp.next;
        }
        ListNode dummy=new ListNode(-1);
        ListNode prev=dummy;
        if(map.size()>0){
            for(Map.Entry<ListNode,Integer>entry:map.entrySet()){
            prev.next=entry.getKey();
            prev=prev.next;
        }
          prev.next=null;
    }
        return dummy.next;
    }
}
                                      OPTIMIAZED LOGIC OF THIS CODE
1. A dummy node is created and linked to the head to handle edge cases.  
2. `prev` is initialized to `dummy` and `temp` is set to `head` for iteration.  
3. The loop traverses the list, checking each node’s value.  
4. If `temp.val == val`, the node is skipped by updating `prev.next`.  
5. Otherwise, `prev` moves forward, and finally, `dummy.next` is returned as the new head. 
    
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy =new ListNode(-1);
        dummy.next=head;
        ListNode prev=dummy;
        ListNode temp=head;
        while(temp!=null){
            if(temp.val==val){
                prev.next=temp.next;
            }
            else{
                prev=temp;
            }
            temp=temp.next;
        }
        return dummy.next;
    }
}
