class Solution {
    public int change(int amount, int[] coins) {
        int [] way= new int [amount+1];
        way[0]=1;
        for(int coin:coins){
            for(int j=coin;j<=amount;j++){
                way[j]+=way[j-coin];
            }
        }
        return way[amount];
    }
}