#BRUTE CODE
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        HashMap<Integer,Integer>map=new LinkedHashMap<>();
        ListNode dummy=new ListNode(-1);
        ListNode prev=dummy;
        ListNode temp=head;
        while(temp!=null){
            map.put(temp.val,map.getOrDefault(temp.val,0)+1);
            temp=temp.next;
        }
        temp=head;
        while(temp!=null){
            if(map.containsKey(temp.val)){
                if(map.get(temp.val)==1){
                    prev.next=new ListNode(temp.val);
                    prev=prev.next;
                }
            }
            temp=temp.next;
        }
        return dummy.next;
    }
}
#OPTIMIZED CODE
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }

        ListNode dummy=new ListNode(-1);
        ListNode temp=dummy;
        ListNode prev=head;
        ListNode current=head.next;
        int dublicate=Integer.MIN_VALUE;
        while(current!=null){
            if(current.val!=prev.val &&prev.val!=dublicate){
                temp.next=prev;
                temp=temp.next;
            }
            else{
                dublicate=prev.val;
            }
            if(current.next==null&&current.val!=dublicate){
                temp.next=current;
                temp=temp.next;
            }
            prev=prev.next;
            current=current.next;
        }
        temp.next=null;
        return dummy.next;
    }
}
