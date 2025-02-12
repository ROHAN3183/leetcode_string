                                            LOGIC OF THIS CODE(REFTER CODEWITHMIK)
1) Traverse the original_list and just copy the value and also put the list_random value in the HashMap.
2) During the putting in map put original_list as the key where as the newnode_list respectively in map.
3) After that again start traversing in the original_list seach in map that is map.contains original_list.next then put it in the newnode_list respectively.
    
#BRUTE FORCE
    
class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node,Node>map=new HashMap<>();
        Node current=head;
        Node dummy=new Node(-1);
        Node prev=dummy;
        Node newnode=null;
        while(current!=null){
            newnode= new Node(current.val);
            prev.next=newnode;
            map.put(current,newnode);
            prev=prev.next;
            current=current.next;
        }
        Node temp_original=head;
        Node temp_copy=dummy.next;
        while(temp_original!=null){
            if(map.containsKey(temp_original.random)){
                temp_copy.random=map.get(temp_original.random);
            }
            else{
                temp_copy.random=null;
            }
            temp_original=temp_original.next;
            temp_copy=temp_copy.next;
        }
        return dummy.next;
    }
}
