class Solution {
    public long subArrayRanges(int[] nums) {
        return maxSubarray(nums) - minSubarray(nums);
    }

    long minSubarray(int[] nums) {

        int[] left = PSE(nums);
        int[] right = NSEEqual(nums);

        long sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum = sum + (long) nums[i]
                    * (i - left[i])
                    * (right[i] - i);
        }

        return sum;
    }

    long maxSubarray(int[] nums) {

        int[] left = PGE(nums);
        int[] right = NGEEqual(nums);

        long sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum = sum + (long) nums[i]
                    * (i - left[i])
                    * (right[i] - i);
        }

        return sum;
    }

    // Previous Smaller Element
    int[] PSE(int[] nums) {

        Stack<Integer> stack = new Stack<>();
        int[] left = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {

            while (!stack.isEmpty() &&
                    nums[stack.peek()] >= nums[i]) {
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

    // Next Smaller or Equal Element
    int[] NSEEqual(int[] nums) {

        Stack<Integer> stack = new Stack<>();
        int[] right = new int[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {

            while (!stack.isEmpty() &&
                    nums[stack.peek()] > nums[i]) {
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

    // Previous Greater Element
    int[] PGE(int[] nums) {

        Stack<Integer> stack = new Stack<>();
        int[] left = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {

            while (!stack.isEmpty() &&
                    nums[stack.peek()] <= nums[i]) {
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

    // Next Greater or Equal Element
    int[] NGEEqual(int[] nums) {

        Stack<Integer> stack = new Stack<>();
        int[] right = new int[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {

            while (!stack.isEmpty() &&
                    nums[stack.peek()] < nums[i]) {
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