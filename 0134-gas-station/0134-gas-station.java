class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int currGas = 0;
        int startIdx = 0;
        int totalGas = 0;
        int totalCost = 0;
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }
        if (totalGas < totalCost) {
            return -1;
        }
        for (int i = 0; i < gas.length; i++) {
            currGas = currGas + gas[i] - cost[i];
            if (currGas < 0) {
                currGas = 0;
                startIdx = i + 1;
            }
        }
        return startIdx;
    }
}
