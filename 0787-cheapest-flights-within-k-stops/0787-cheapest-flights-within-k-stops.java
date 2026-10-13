
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < flights.length; i++) {
            adj.get(flights[i][0]).add(
                new int[]{flights[i][1], flights[i][2]}
            );
        }

        return bfs(adj, src, dst, k + 1);
    }

    int bfs(List<List<int[]>> adj, int src, int dst, int k) {
        Queue<int[]> queue = new LinkedList<>();
        int[] distance = new int[adj.size()];

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;

        queue.add(new int[]{src, 0, 0});

        while (!queue.isEmpty()) {
            int[] node = queue.poll();

            int u = node[0];
            int cost = node[1];
            int d = node[2];

            for (int[] neighbour : adj.get(u)) {
                int v = neighbour[0];
                int w = neighbour[1];

                if (cost + w < distance[v] && d + 1 <= k) {
                    distance[v] = cost + w;
                    queue.add(new int[]{v, distance[v], d + 1});
                }
            }
        }

        if (distance[dst] == Integer.MAX_VALUE) {
            return -1;
        }

        return distance[dst];
    }
}
