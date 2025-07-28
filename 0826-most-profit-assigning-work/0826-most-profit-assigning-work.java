***************************************TWO POINTER*****************************************************************************
class Solution {

    class Pair {
        int difficult;
        int profit;

        Pair(int difficult, int profit) {
            this.difficult = difficult;
            this.profit = profit;
        }
    }

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        List<Pair> list = new ArrayList<>();
        int ans = 0;

        for (int i = 0; i < difficulty.length; i++) {
            list.add(new Pair(difficulty[i], profit[i]));
        }

        Collections.sort(list, (a, b) -> a.difficult - b.difficult);
        Arrays.sort(worker);

        int j = 0;
        int best = 0;

        for (int i = 0; i < worker.length; i++) {
            int value = worker[i];

            while (j < list.size() && list.get(j).difficult <= value) {
                best = Math.max(best, list.get(j).profit);
                j++;
            }

            ans += best;
        }

        return ans;
    }
}
*******************************************BINARY SEARCH***********************************************************************
class Solution {
    class Pair {
        int difficult;
        int profit;

        Pair(int difficult, int profit) {
            this.difficult = difficult;
            this.profit = profit;
        }
    }

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < difficulty.length; i++) {
            list.add(new Pair(difficulty[i], profit[i]));
        }
        Collections.sort(list, (a, b) -> a.difficult - b.difficult);
        Arrays.sort(worker);
        int result = 0;
        for (int i = 0; i < worker.length; i++) {
            int value = worker[i];
            result += binarySearch(list, value);
        }
        return result;
    }

    int binarySearch(List<Pair> list, int value) {
        int low = 0;
        int high = list.size() - 1;
        int max = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (list.get(mid).difficult <= value) {
                max = Math.max(max, list.get(mid).profit);
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return max;
    }
}
