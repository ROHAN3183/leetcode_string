
class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        
        // Map to store diagonals
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        // Fill the map using (i + j) as the key
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // If the map doesn't contain the diagonal index, initialize it
                if (!map.containsKey(i + j)) {
                    map.put(i + j, new ArrayList<>());
                }
                map.get(i + j).add(mat[i][j]);
            }
        }
        
        List<Integer> result = new ArrayList<>();
        boolean flip = true;
        
        // Traverse the map and fill the result list
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> diagonal = entry.getValue();
            if (flip) {
                Collections.reverse(diagonal);  // Reverse the diagonal list
            }
            result.addAll(diagonal);
            flip = !flip;
        }
        
        // Convert List<Integer> to int[] array
        int[] resultArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }
        
        return resultArray;
    }
}
