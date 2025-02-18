                                LOGIC OF THIS CODE
1) USE HASHMAP TO STORE THE PREFIX SUM SUCH THAT TREAT O AS THE -1;
2) CHECK THE MAP IF IT CONTAIN KEY ALREADY THEN GET THE VALUE AS IT WILL BE THE INDEX JUST END WILL BE YOUR CURRENT INDEX WHERE AS 
    START WILL BE THE LAST SEEN INDEX STORED IN THE MAP.
    
# BRUTE FORCE
    class Solution {
    public int findMaxLength(int[] nums) {
        int n=nums.length;

        int max_length=0;
        for(int i=0;i<n;i++){
            int count_one=0;
            for(int j=i;j<n;j++){
                if(nums[j]==1){
                    count_one++;
                }
                else{
                    count_one--;
                }
                if(count_one==0){
                    max_length=Math.max(j-i+1,max_length);
                }
            }
        }
        return max_length;
    }
}

# OPTIMIZED CODE
class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer>map=new HashMap<>();
        int n=nums.length;
        int sum=0;
        int max_length=0;
        map.put(0,-1);
        for(int i=0;i<n;i++){
            if(nums[i]!=0){
                sum=sum+nums[i];
            }
            else{
                sum=sum-1;
            }

            if(map.containsKey(sum)){
                int end=i;
                int start=map.get(sum);
                max_length=Math.max(end-start,max_length);
            }
            else{
                map.put(sum,i);
            }
        }
        return max_length;
    }
}
