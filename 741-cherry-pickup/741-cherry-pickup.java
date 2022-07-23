class Solution {
    int [][][]dp;
    public int cherryPickup(int[][] grid) {
        int n=grid.length;
        
        dp=new int[n][n][n];
        
        int ans=cherryPickup_(grid,0,0,0,n);
        
        return ans<0?0:ans;
    }
    
    public int cherryPickup_(int [][]grid, int r1, int c1, int r2,int n){
        int c2=r1+c1-r2;
        
        if(r1<0 || r2<0 || r1>=n || r2>=n || c1<0 || c2<0 || c1>=n || c2>=n || grid[r1][c1]==-1 || grid[r2][c2]==-1){
            return -(int)(1e9);
        }
        
        if((r1==n-1 && c1==n-1) && (r2==n-1 && c2==n-1)){
            return grid[n-1][n-1];
        }
        
        if(dp[r1][c1][r2]!=0){
            return dp[r1][c1][r2];
        }
        
        int cherries=0;
        
        if(r1==r2 && c1==c2){
            cherries+=grid[r1][c1];
        }else{
            cherries+=grid[r1][c1]+grid[r2][c2];
        }
        
        int f1=cherryPickup_(grid,r1+1,c1,r2+1,n);
        int f2=cherryPickup_(grid,r1,c1+1,r2+1,n);
        int f3=cherryPickup_(grid,r1,c1+1,r2,n);
        int f4=cherryPickup_(grid,r1+1,c1,r2,n);
        
        cherries+=Math.max(Math.max(f1,f2),Math.max(f3,f4));
        
        return dp[r1][c1][r2]=cherries; 
    }
}