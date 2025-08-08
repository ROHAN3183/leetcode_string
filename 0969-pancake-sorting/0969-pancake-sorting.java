class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer>list=new ArrayList<>();
        int pos = arr.length-1;
        while(pos>=0){
            int [] maxi=findMax(arr,pos);
            if(maxi[1]==pos){
                pos--;
                continue;
            }
            else if(maxi[1]!=pos && pos!=0){
                reverse(arr,maxi[1]);
                list.add(maxi[1]+1);
                reverse(arr,pos);
                list.add(pos+1);
            }
            else if(maxi[1]==0){
                reverse(arr,pos);
                list.add(pos+1);
            }
            pos--;
        }
        return list;

    }
    static  int [] findMax(int [] arr ,int pos){
        int max=Integer.MIN_VALUE;
        int idx =-1;
        for(int i = 0;i<=pos;i++){
            if(max<arr[i]){
                max=arr[i];
                idx=i;
            }
        }
        return new int[]{max,idx};
    }
    static void reverse(int [] arr ,int pos){
        int i=0;
        int j=pos;
        while(i<j){
            int temp = arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
    }
}