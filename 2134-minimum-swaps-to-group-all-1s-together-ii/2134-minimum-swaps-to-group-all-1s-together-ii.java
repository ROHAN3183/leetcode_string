/*
first find the count of the number of the 1's in the array .
find the subarray where the minimum no. of the zero are the 
Also initilize the Extra array with the size of the 2*n of the original size.
for filling the Extra array use the modulus operator  
*/
***************************************************LOGIC OF THE CODE************************************************************
class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int[] extra = new int[2 * n];
        int ones = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                ones++;
            }
        }
        for (int i = 0; i < 2 * n; i++) {
            extra[i] = nums[i % n];
        }
        int i = 0;
        int j = 0;
        int zeroCount = 0;
        int minSwap = Integer.MAX_VALUE;

        while (j - i + 1 <= ones) {
            if (extra[j] == 0) {
                zeroCount++;
            }
            j++;
        }
        minSwap = zeroCount;

        while (j < 2 * n) {
            if (extra[i] == 0) {
                zeroCount--;
            }
            if (extra[j] == 0) {
                zeroCount++;
            }
            minSwap = Math.min(minSwap, zeroCount);
            i++;
            j++;
        }
        return minSwap;

    }
}
****************************************WITHOUT SPACE **************************************************************************
/*Use the modulus oprator an keep the base case as i because in the circular array it can start from the any where and it can end 
at the anywhere.*/
********************************************************************************************************************************
class Solution {
    public int minSwaps(int[] arr) {
        int n = arr.length;
        int i = 0;
        int j = 0;
        int k = 0;
        for (int l = 0; l < n; l++) {
            if (arr[l] == 1) {
                k++;
            }
        }
   
        int minSwap = Integer.MAX_VALUE;
        int zeroCount = 0;
        while (j - i + 1 <= k) {
            if (arr[j%n] == 0) {
                zeroCount++;
            }
            j++;
        }
        minSwap = zeroCount;
        while (i < n) {
            if (arr[i%n] == 0) {
                zeroCount--;
            }
            if (arr[j%n] == 0) {
                zeroCount++;
            }

            minSwap = Math.min(minSwap, zeroCount);
            j++;
            i++;

        }
        return minSwap;
    }
}
