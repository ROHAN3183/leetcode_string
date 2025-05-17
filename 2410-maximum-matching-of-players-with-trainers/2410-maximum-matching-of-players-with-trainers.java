class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        
        int no_players=players.length;
        int no_trainers=trainers.length;
        int ans=0;

        PriorityQueue<Integer>heap=new PriorityQueue<>();
        Arrays.sort(players);

        for(int i=0;i<no_trainers;i++){

            heap.add(trainers[i]);

        }

        int i=0;

        while(i<no_players && !heap.isEmpty()){


            if(!heap.isEmpty() && players[i]<=heap.peek()){
                heap.poll();
                ans++;
                i++;
            }
            else if(!heap.isEmpty()){
                heap.poll();
            }

        }
        return ans;

    }
}