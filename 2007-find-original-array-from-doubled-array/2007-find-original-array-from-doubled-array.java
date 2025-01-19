class Solution {
    public int[] findOriginalArray(int[] changed) {
        int n=changed.length;
        if(n%2!=0){
            return new int[0];
        }
        HashMap<Integer,Integer>map=new HashMap<>();
        int [] result=new int[n/2];
        for(int i=0;i<n;i++){    //To fill the frequency of the changed;
            map.put(changed[i],map.getOrDefault(changed[i],0)+1);
        }
        int idx=0;
        Arrays.sort(changed);
        for(int i=0;i<n;i++){
           int nums=changed[i];
            if(map.get(nums)==0){ //if already used means frequency has became zero. then move for next iteration;
                continue;
            }
            if(map.getOrDefault(2*nums,0)>0){ //if  double of frequency is still there means has not used; 
                result[idx++]=nums;
                map.put(nums,map.get(nums)-1);
                map.put(2*nums,map.get(2*nums)-1);
            }
            else{
                return new int[0];
            }

        }
        return result;
    }
}
