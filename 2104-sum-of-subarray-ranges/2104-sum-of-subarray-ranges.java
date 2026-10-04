class Solution { 
    public long subArrayRanges(int[] nums) { 
        return maxSubarray(nums) - minSubarray(nums); 
    } 

    long minSubarray(int[] nums) { 
        int[] left = LNSE(nums); 
        int[] right = RNSE(nums); 
        long sum = 0; 
        for (int i = 0; i < nums.length; i++) { 
            sum = sum + (long)nums[i] * (i - left[i]) * (right[i] - i); 
        } 
        return sum; 
    } 

    long maxSubarray(int[] nums) { 
        int[] left = LNGE(nums); 
        int[] right = RNGE(nums); 
        long sum = 0; 
        for (int i = 0; i < nums.length; i++) { 
            sum = sum + (long)nums[i] * (i - left[i]) * (right[i] - i); 
        } 
        return sum; 
    } 

    int[] LNSE(int[] nums) { 
        Stack<Integer> stack = new Stack<>(); 
        int[] left = new int[nums.length]; 
        for (int i = 0; i < nums.length; i++) { 
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) { 
                stack.pop(); 
            } 
            if (stack.isEmpty()) {
                left[i] = -1;
            } else {
                left[i] = stack.peek();
            }
            stack.push(i); 
        } 
        return left; 
    } 

    int[] RNSE(int[] nums) { 
        Stack<Integer> stack = new Stack<>(); 
        int[] right = new int[nums.length]; 
        for (int i = nums.length - 1; i >= 0; i--) { 
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) { 
                stack.pop(); 
            } 
            if (stack.isEmpty()) {
                right[i] = nums.length;
            } else {
                right[i] = stack.peek();
            }
            stack.push(i); 
        } 
        return right; 
    } 

    int[] LNGE(int[] nums) { 
        Stack<Integer> stack = new Stack<>(); 
        int[] left = new int[nums.length]; 
        for (int i = 0; i < nums.length; i++) { 
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) { 
                stack.pop(); 
            } 
            if (stack.isEmpty()) {
                left[i] = -1;
            } else {
                left[i] = stack.peek();
            }
            stack.push(i); 
        } 
        return left; 
    } 

    int[] RNGE(int[] nums) { 
        Stack<Integer> stack = new Stack<>(); 
        int[] right = new int[nums.length]; 
        for (int i = nums.length - 1; i >= 0; i--) { 
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) { 
                stack.pop(); 
            } 
            if (stack.isEmpty()) {
                right[i] = nums.length;
            } else {
                right[i] = stack.peek();
            }
            stack.push(i); 
        } 
        return right; 
    } 
}
