class Solution {
    public int fib(int n) {
        if(n==0){
            return 0;
        }
        ArrayList<Integer> m= new ArrayList<>(Collections.nCopies(n+1,0));
        m.set(0,0);
        m.set(1,1);
        for(int i=2;i<=n;i++){
            m.set(i,(m.get(i-2)+m.get(i-1)));
        }
        return m.get(n);
        
    }
}