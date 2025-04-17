class Solution {
    public int climbStairs(int n) {
        if(n<1){
            return 1;
        }
        ArrayList<Integer>m = new ArrayList<>(Collections.nCopies(n+1,0));
        m.set(0,1);
        m.set(1,1);
        for(int i=2;i<=n;i++){
            m.set(i,(m.get(i-1)+m.get(i-2)));
        }
        return m.get(n);

        
    }
}