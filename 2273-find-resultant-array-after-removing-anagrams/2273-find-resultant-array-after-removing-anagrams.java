class Solution {
    public List<String> removeAnagrams(String[] words) {
        Stack<String> stack = new Stack<>();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (stack.isEmpty()) {
                stack.push(words[i]);
                continue;
            }
            if (!isValid(stack.peek(), words[i])) {
                stack.push(words[i]);
            }
        }
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        Collections.reverse(list);
        return list;

    }

    boolean isValid(String oldString , String newString){
        int [] first=new int [26];
        int [] second=new int [26];

        for(int i=0;i<oldString.length();i++){
            char ch =oldString.charAt(i);
            first[ch-'a']++;
        }
        for(int i=0;i<newString.length();i++){
            char ch=newString.charAt(i);
            second[ch-'a']++;
        }

        for(int i=0;i<26;i++){
            if(first[i]!=second[i]){
                return false;
            }
        }
        return true;
    }
}