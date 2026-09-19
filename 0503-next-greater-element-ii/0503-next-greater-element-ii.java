class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 2 * nums.length - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                result[i % nums.length] = -1;
            } else if (stack.peek() > nums[i % nums.length]) {
                result[i % nums.length] = stack.peek();
            } else {
                while (!stack.isEmpty() && stack.peek() <= nums[i % nums.length]) {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    result[i % nums.length] = stack.peek();
                } else if (stack.isEmpty()) {
                    result[i % nums.length] = -1;
                }
            }
            stack.push(nums[i % nums.length]);
        }
        return result;
    }
}