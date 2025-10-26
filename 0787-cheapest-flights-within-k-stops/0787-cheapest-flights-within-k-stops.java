class Solution {
    class Pair {
        int node0;
        int cost0;

        Pair(int node0, int cost0) {
            this.node0 = node0;
            this.cost0 = cost0;

        }
    }

    class Info {
        int node1;
        int cost1;
        int step;

        Info(int node1, int step, int cost1) {
            this.node1 = node1;
            this.step = step;
            this.cost1 = cost1;

        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] distance = new int[n];
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : flights) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adj.get(u).add(new Pair(v, w));

        }
        return bfs(adj, src, dst, k);

    }

    int bfs(ArrayList<ArrayList<Pair>> adj, int src, int dst, int k) {
        Queue<Info> queue = new LinkedList<>();
        int [] distance = new int [adj.size()];
        Arrays.fill(distance,Integer.MAX_VALUE);
        queue.offer(new Info(src, -1, 0));
        distance[src]=0;
        int min = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            Info X = queue.poll();
            if (X.node1 == dst && X.step <= k) {
                min = Math.min(min, X.cost1);
                continue;
            }
            if (X.step >= k) {
                continue;
            }
            for (Pair neibour : adj.get(X.node1)) {
                if(X.cost1+neibour.cost0<distance[neibour.node0]){
                    distance[neibour.node0]=X.cost1+neibour.cost0;
                    queue.offer(new Info(neibour.node0, X.step + 1, X.cost1 + neibour.cost0));
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

}