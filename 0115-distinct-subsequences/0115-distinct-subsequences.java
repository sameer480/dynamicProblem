class Solution {
    int [][] dp=new int [1001][1001];

public int ok(int i,int j,String s,String t){
    int n= s.length();
    int m= t.length();
    if(j==m)return 1;
    if(i==n) return 0;
    if(dp[i][j]!=-1){
        return dp[i][j];
    }
    int ans=0;
    if(s.charAt(i)==t.charAt(j)){
        ans=ok(i+1,j+1,s,t)+ok(i+1,j,s,t);
    }else{
        ans=ok(i+1,j,s,t);
    }
    return dp[i][j]= ans;
}
    public int numDistinct(String s, String t) {
            for (int i = 0; i < 1001; i++) {
    Arrays.fill(dp[i], -1);
}
        return ok(0,0,s,t);
        
        
    }
}