#BRUTE FORCE
    
    class Solution {
    public List<String> stringMatching(String[] words) {
        int n=words.length;
        ArrayList<String>list=new ArrayList<>();
        for(int i=0;i<n;i++){
            String x=words[i];
            for(int j=0;j<n;j++){
                String str=words[j];
                if(i!=j){
                    if(isValid(str,x)){
                        if(!list.contains(str)){
                            list.add(str);
                        }
                    }
                }
            }
        }
        return list;
    }
    boolean isValid(String str,String x){
        return (x).indexOf(str)!=-1;
    }
}

# OPTIMIZED 
    
class Solution {
    public List<String> stringMatching(String[] words) {
        int n = words.length;
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String S = words[i];
            for (int j = 0; j < n; j++) {
                if (j != i) {
                    String str = words[j];
                    int m = str.length();
                    int[] lps = new int[m];
                    lps = lps_function(str, lps); // Generate the LPS array
                    if (KMP(S, str, lps)) {
                        if (!list.contains(str)) { // Add `str` instead of `S`
                            list.add(str);
                        }
                    }
                }
            }
        }
        return list;
    }

    boolean KMP(String S, String str, int[] lps) {
        int n = S.length();
        int m = str.length();
        int i = 0; // Pointer for S
        int j = 0; // Pointer for str

        while (i < n) {
            if (j < m && S.charAt(i) == str.charAt(j)) {
                i++;
                j++;
            }
            if (j == m) {
                return true; // Match found
            }
            if (i < n && j < m && S.charAt(i) != str.charAt(j)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return false;
    }

    int[] lps_function(String str, int[] lps) {
        int m = str.length();
        int length = 0; // Length of the previous longest prefix suffix
        int i = 1;

        lps[0] = 0; // LPS of the first character is always 0

        while (i < m) {
            if (str.charAt(i) == str.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}
