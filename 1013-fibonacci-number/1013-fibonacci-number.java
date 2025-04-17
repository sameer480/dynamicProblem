class Solution {
    public int memo(int n,ArrayList<Integer> m){
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (m.get(n) != -1) {
            return m.get(n);
        }
        int fibNMinus1 = memo(n - 1, m);
        int fibNMinus2 = memo(n - 2, m);
        m.set(n, fibNMinus1 + fibNMinus2);
        return m.get(n);
    }
    public int fib(int n) {
        if(n==0){
            return 0;
        }
        ArrayList<Integer> m= new ArrayList<>(Collections.nCopies(n+1,-1));
      return memo(n,m);
        
    }
}