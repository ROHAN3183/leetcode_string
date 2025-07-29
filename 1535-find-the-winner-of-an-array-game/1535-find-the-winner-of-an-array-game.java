class Solution {
    class Pair {
        int key;
        int idx;

        Pair(int key, int idx) {
            this.key = key;
            this.idx = idx;
        }
    }

    public int getWinner(int[] arr, int k) {
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.key, b.key));
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        boolean flag = true;

        while (flag) {
            minHeap.offer(new Pair(list.get(0), 0));
            minHeap.offer(new Pair(list.get(1), 1));
            Pair loose = minHeap.poll();
            Pair win = minHeap.poll();
            minHeap.clear();
            list.remove((Integer)loose.key);
            list.add(loose.key);
            map.put(win.key, map.getOrDefault(win.key, 0) + 1);
            if (map.get(win.key) >= k) {
                return win.key;
            }
        }
        return -1;
    }

}