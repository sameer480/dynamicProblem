class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n= cost.length;
        int [] m= new int[n];
        m[0]=cost[0];
        m[1]= cost[1];
        for(int i=2;i<n;i++){
            m[i]=cost[i]+Math.min(m[i-1],m[i-2]);
        }
        return Math.min(m[n-1],m[n-2]);
      
        
    }
}