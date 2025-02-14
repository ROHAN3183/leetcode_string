class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer>stack=new Stack<>();
        HashMap<Integer,Integer>map=new HashMap<>();
        int n=nums1.length;
        int m=nums2.length;
        int []result=new int[n];
        int j=m-1;
        while(j>=0){
             while(!stack.isEmpty()&&stack.peek()<=nums2[j]){
                    stack.pop();
                }
            if(stack.isEmpty()){
                map.put(nums2[j],-1);
            }
            else{
                map.put(nums2[j],stack.peek());
            }
            stack.push(nums2[j]);
            j--;
        }
        for(int i=0;i<n;i++){
            if(map.containsKey(nums1[i])){
              result[i]=map.get(nums1[i]);
            }
        }
        return result;
    }
}