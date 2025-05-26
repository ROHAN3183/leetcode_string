class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        
        int[] start = new int[26];
        int[] end = new int[26];
        Arrays.fill(start, -1);
        Arrays.fill(end, -1);

        // Record first and last positions of each character
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (start[ch - 'a'] == -1) {
                start[ch - 'a'] = i;
            }
            end[ch - 'a'] = i;
        }

        List<Integer> result = new ArrayList<>();
        
        // Collect all non-empty intervals
        List<int[]> intervals = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (start[i] != -1) {
                intervals.add(new int[]{start[i], end[i]});
            }
        }
        
        // Sort intervals by start time
        intervals.sort((a, b) -> Integer.compare(a[0], b[0]));

        // Merge intervals
        if (!intervals.isEmpty()) {
            int currentStart = intervals.get(0)[0];
            int currentEnd = intervals.get(0)[1];
            
            for (int i = 1; i < intervals.size(); i++) {
                int[] interval = intervals.get(i);
                if (interval[0] <= currentEnd) { // Overlapping
                    currentStart = Math.min(currentStart, interval[0]);
                    currentEnd = Math.max(currentEnd, interval[1]);
                } else {
                    result.add(currentEnd - currentStart + 1);
                    currentStart = interval[0];
                    currentEnd = interval[1];
                }
            }
            // Add the last interval
            result.add(currentEnd - currentStart + 1);
        }
        
        return result;
    }
}