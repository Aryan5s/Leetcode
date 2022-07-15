
class Solution {
   
    public int findTheWinner(int n, int k) {
        int res=findthewinner(n,k);
        return res+1;
    }
    public int findthewinner(int n,int k){
        if(n==1)
            return 0;
        return (((findthewinner(n-1,k)))+k)%n;
    
    }
}