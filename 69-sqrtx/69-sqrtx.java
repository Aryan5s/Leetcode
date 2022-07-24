class Solution {
    public int mySqrt(int x) {
         // O(log n) time | O(1) space
        if(x == 0 || x == 1)    return x;
        
        long left = 0, right = x / 2;
        long pivot;
        
        while(left <= right)
        {
            pivot = left + (right - left) / 2;
            
            if(pivot * pivot == x)    return (int) pivot;
            
            if(pivot * pivot < x && (pivot + 1) * (pivot + 1) > x)
                return (int) pivot;
            else if(pivot * pivot > x)
                right = pivot - 1;
            else
                left = pivot + 1;
        }
        return -1;
    }
}