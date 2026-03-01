class Solution {
    public void nextPermutation(int[] arr) {
        int n=arr.length;
        int idx=-1;
        for(int i=n-2;i>=0;i--){
            if(arr[i]<arr[i+1]){
                 idx=i;
                break;
            }
        }
        if(idx==-1){
            reverse(arr,idx+1,n-1);
            return ;
        }
        for(int i=n-1;i>=idx;i--){
            if(arr[idx]<arr[i]){
                int temp=arr[idx];
                arr[idx]=arr[i];
                arr[i]=temp;
                break;
            }
        }
     reverse(arr,idx+1,n-1);
        
    }
    void reverse(int []arr,int i,int j ){
        while(i<j){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
    }
}