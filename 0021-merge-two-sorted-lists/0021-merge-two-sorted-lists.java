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
#Brute force
    
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ArrayList<Integer>list=new ArrayList<>();
        while(list1!=null){
            list.add(list1.val);
            list1=list1.next;
        }
        while(list2!=null){
            list.add(list2.val);
            list2=list2.next;
        }
        Collections.sort(list);
        ListNode dummy =new ListNode(-1);
        ListNode prev=dummy;
        for(int i=0;i<list.size();i++){
            prev.next=new ListNode(list.get(i));
            prev=prev.next;
        }
        return dummy.next;
    }
}

# Optimized code
    
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2){
        ListNode dummy=new ListNode(0);
        ListNode prev=dummy;
        while(list1!=null && list2!=null){

            if(list1.val<=list2.val){
                prev.next=list1;
                list1=list1.next;
            }
            else{
                prev.next=list2;
                list2=list2.next;
            }
            prev=prev.next;
        }
        if(list1!=null){
            prev.next=list1;
        }
        else{
            prev.next=list2;
        }

        return dummy.next;
    }
}
