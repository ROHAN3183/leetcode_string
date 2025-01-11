#BRUTE FORECE
    
    class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        ArrayList<String>list=new ArrayList<>();
        int n=words1.length;
        int m=words2.length;
        for(int i=0;i<n;i++){
            String s1=words1[i];
            int len1= s1.length();
            int [] character=new int[26];
            for(int j=0;j<len1;j++){
                char ch1=s1.charAt(j);
                character[ch1-'a']+=1;
            }
            int length=0;
            for(int k=0;k<m;k++){
                String s2=words2[k];
                int len2= s2.length();
                int count=0;
            int[] temp = character.clone();
                for(int l=0;l<len2;l++){
                    char ch2=s2.charAt(l);
                    if(temp[ch2-'a']>=1){
                        count++;
                        temp[ch2-'a']-=1;
                    }
                    else{
                        break;
                    }
                }
                if(count==len2){
                        length++;
                }
            }
             if(length==m){
                    list.add(s1);
            }

        }
        return list;
    }
}

    # OPTIMIZED  
        
class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> result = new ArrayList<>();
        
        // Step 1: Calculate the maximum frequency requirement for words2
        int[] freq2 = new int[26]; // Frequency array for all characters
        for (String word : words2) {
            int[] temp = new int[26]; // Temporary frequency array for the current word
            for (char ch : word.toCharArray()) {
                temp[ch - 'a']++;
                freq2[ch - 'a'] = Math.max(freq2[ch - 'a'], temp[ch - 'a']);
            }
        }
        
        // Step 2: Check each word in words1
        for (String word : words1) {
            int[] temp = new int[26]; // Frequency array for the current word
            for (char ch : word.toCharArray()) {
                temp[ch - 'a']++;
            }
            
            // Check if the word satisfies the universal condition
            if (isSubset(freq2, temp)) {
                result.add(word);
            }
        }
        
        return result;
    }
    
    // Helper method to check if freq2 is a subset of temp
    private boolean isSubset(int[] freq2, int[] temp) {
        for (int i = 0; i < 26; i++) {
            if (temp[i] < freq2[i]) {
                return false; // Not a subset
            }
        }
        return true;
    }
}
