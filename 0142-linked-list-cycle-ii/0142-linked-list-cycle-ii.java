/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
# brute force
public class Solution {
    public ListNode detectCycle(ListNode head) { //In hashMap if it contain's node it means loop do exits. 
        HashMap<ListNode,Integer>map=new HashMap<>();
        ListNode temp=head;
        while(temp!=null){
            if(map.containsKey(temp)){
                return temp;
            }
            map.put(temp,1);
            temp=temp.next;
        }
    return null;
    }
}

# optimized code

public class Solution {
    public ListNode detectCycle(ListNode head) { //use slow and fast approach if slow =fast it means loop do exist's.
        ListNode slow=head;
        ListNode fast=head;
        boolean flag=false;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
              if(slow==fast){
                flag=true;
                break;
            }
        }
        ListNode temp=head;
        if(flag){
            while(temp!=slow){
                temp=temp.next;
                slow=slow.next;
            }
            return slow;
        }
        return null;
    }
}
