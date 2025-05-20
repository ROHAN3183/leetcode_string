class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {

        int n=arr.length;
        Arrays.sort(arr);
        int maxElement=1;
        arr[0]=1;
        if(n<=1){
            return arr[0];
        }
        for(int i=1;i<n;i++){

            if(Math.abs(arr[i]-arr[i-1])>1){
                arr[i]=arr[i-1]+1;

            }
            maxElement=Math.max(arr[i],maxElement);

        }
        return maxElement;
        
    }
}