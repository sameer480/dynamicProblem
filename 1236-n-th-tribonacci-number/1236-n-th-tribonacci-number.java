class Solution {
    public int tribonacci(int n) {
        if(n==0){
            return 0;
        }
         if (n == 1 || n == 2) {
            return 1;
        }
        ArrayList<Integer> m = new ArrayList<>(Collections.nCopies(n+1,0));
        m.set(0,0);
        m.set(1,1);
        m.set(2,1);
        for(int i=3;i<=n;i++){
            m.set(i,m.get(i-1)+m.get(i-2)+m.get(i-3));
        }
        return m.get(n);
        
    }
}