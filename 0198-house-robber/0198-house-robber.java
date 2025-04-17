class Solution {
    public int memo(int[] nums,int i,int [] m){
        if(i>=nums.length){
            return 0;
        }
        if(m[i]!=-1){
            return m[i];
        }
    int inc=nums[i] + memo(nums, i + 2, m);
    int exc= memo(nums,i+1,m);
    return m[i]= Math.max(inc,exc);

    }
    public int rob(int[] nums) {
        int n =nums.length;
        int [] m= new int [n];
         Arrays.fill(m, -1);
        return memo(nums,0,m);
        
    }
}