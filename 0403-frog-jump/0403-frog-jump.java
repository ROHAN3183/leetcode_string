/*logic of the code:
if the last jump +stones[current_position] do exit in the map then it is valid return true.
Also use the memo to store the dead or the reapeated path.
*/
***********************************************OPTIMIZED CODE*********************************************************************
    class Solution {
    Set<String> memo = new HashSet<>();

    public boolean canCross(int[] stones) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            map.put(stones[i], i);
        }
        return solve(stones, map, 0, 0);
    }

    boolean solve(int[] stones, Map<Integer, Integer> map, int current_index, int last_jump) {
        if (current_index == stones.length - 1) {
            return true;
        }
        boolean result = false;
        String key = current_index + "," + last_jump;
        if (memo.contains(key)) {
            return false;
        }

        for (int next_jump = last_jump - 1; next_jump <= last_jump + 1; next_jump++) {
            if (next_jump > 0) {
                int next_position = stones[current_index] + next_jump;
                if (map.containsKey(next_position)) {
                    result = result || solve(stones, map, map.get(next_position), next_jump);

                }
            }
        }
        memo.add(key);
        return result;
    }
}
