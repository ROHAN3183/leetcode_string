import java.util.*;

class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;   // Number of rows
        int n = mat[0].length; // Number of columns

        // HashMap to store diagonal elements with key = (i - j)
        Map<Integer, List<Integer>> map = new HashMap<>();

        // Step 1: Populate the HashMap with diagonal elements
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map.putIfAbsent(i - j, new ArrayList<>());
                map.get(i - j).add(mat[i][j]);
            }
        }

        // Step 2: Sort the diagonals
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            Collections.sort(entry.getValue());
        }

        // Step 3: Place the sorted elements back into the matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = map.get(i - j).remove(0);
            }
        }

        return mat;
    }
}
