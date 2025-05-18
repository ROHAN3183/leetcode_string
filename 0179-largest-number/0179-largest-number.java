class Solution {
    public String largestNumber(int[] nums) {
        int n=nums.length;
        String[]strArray=new String[n];
        for(int i=0;i<n;i++){
            strArray[i]=Integer.toString(nums[i]);
        }

        Arrays.sort(strArray,(a,b)->(b+a).compareTo(a+b));

        StringBuilder result=new StringBuilder();

        for(int i=0;i<n;i++){

            if(strArray[0]=="0"){
                return "";
            }

            result.append(strArray[i]);

        }
        return result.toString();
        
    }
}