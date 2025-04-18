class Solution {
    public int deleteAndEarn(int[] nums) {
        int [] m= new int [10005];
      Arrays.fill(m, 0);
        for(int i=0;i<nums.length;i++){
            m[nums[i]]+=nums[i];
        } 
        int [] dp= new int [10005];
        dp[1]=m[1];
        dp[2]= Math.max(m[1],m[2]);
        for(int i=3;i<10005;i++){
            dp[i]= Math.max(m[i]+dp[i-2],dp[i-1]);
        }
        return Math.max(dp[10004],dp[10003]);

        
    }
}