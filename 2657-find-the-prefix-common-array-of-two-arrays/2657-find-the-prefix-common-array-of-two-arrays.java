class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n1=A.length;
        int n2=B.length;
        int [] res=new int[n1];
        HashMap<Integer,Integer>map = new HashMap<>();
        for(int i=0;i<n1;i++){
            map.put(A[i],i);
        }
        int idx=0;
        for(int i=0;i<n2;i++){
            int count=0;
            for(int j=0;j<=i;j++){
                if(map.containsKey(B[j])){
                    if(map.get(B[j])<=i){
                        count++;
                    }
                }
            }
            res[idx++]=count;
        }
        return res;
    }
}