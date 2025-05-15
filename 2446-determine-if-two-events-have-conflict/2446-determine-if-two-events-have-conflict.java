class Solution {
    public boolean haveConflict(String[] event1, String[] event2) {
        int n=event1.length;
        
        
            String[] timeE1 =event1[1].split(":");

            int endTimeE1Hour=Integer.parseInt(timeE1[0]);
            int endTimeE1Minute=Integer.parseInt(timeE1[1]);

            String[] timeE2=event2[0].split(":");

            int startTimeE2Hour=Integer.parseInt(timeE2[0]);
            int startTimeE2Minute=Integer.parseInt(timeE2[1]);

            if(endTimeE1Hour > startTimeE2Hour){
                return true;
            }
            else if(endTimeE1Hour == startTimeE2Hour && endTimeE1Minute >= startTimeE2Minute){
                return true;
            }
            

        
        return false;
        
    }
}