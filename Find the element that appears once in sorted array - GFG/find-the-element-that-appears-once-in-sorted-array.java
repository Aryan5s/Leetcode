//{ Driver Code Starts
//Initial Template for Java

import java.util.*;

public class GFG 
{
    public static void main(String args[]) 
    {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while (t-- > 0) 
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0;i < n;i++)
            {
                arr[i] = sc.nextInt();
            }
            
            Solution sol = new Solution();
            System.out.println(sol.findOnce(arr, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    int findOnce(int arr[], int n)
    {
        
     if(n == 1) return arr[0];   
        
       boolean duplicate = false;
       int index =  0;
       while(index < arr.length - 1){
           if(arr[index] != arr[index + 1] && duplicate == true){
               duplicate = false;
           }else if(arr[index] != arr[index + 1]){
               return arr[index];
           }else{
               duplicate = true;
           }
           index++;
       }
       
       if(arr[index] != arr[index - 1]) return arr[index];
       
       return -1;
    }
}