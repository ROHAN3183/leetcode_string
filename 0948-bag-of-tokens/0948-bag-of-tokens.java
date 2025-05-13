class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int n=tokens.length;
        int i=0;
        int j=n-1;
        int score=0;
        int maxScore=0;
        Arrays.sort(tokens);
        while(i<=j){
            if(tokens[i]<=power){
                power=power-tokens[i];
                score++;
                i++;
            }
            else if(score>=1){
                power=power+tokens[j];
                score--;
                j--;
            }
            else{
                break;
            }
            maxScore=Math.max(maxScore,score);
        }
        return maxScore;
    }
}