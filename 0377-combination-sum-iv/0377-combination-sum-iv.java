class Solution {
    int solve(int [] nums,int t,int [] dp){
        if(nums.length<=0||t<0){
            return 0;
        }
        if(t==0){
            return 1;
        }
        if(dp[t]!=-1){
            return dp[t];
        }
        int ans=0;
        for(int i=0;i<nums.length;i++){
            ans+=solve(nums,t-nums[i],dp);
        }
     return   dp[t]=ans;
    }
    public int combinationSum4(int[] nums, int t) {
        int [] dp= new int [t+1];
        Arrays.fill(dp,-1);
        return solve(nums,t,dp);
        
    }
}