class Solution {
    public int countGoodRectangles(int[][] rectangles) {
        int maxSide = 0;
    int countMax = 0;
    for ( int[]  a: rectangles){
        int smallerSide  = Math.min(a[0], a[1]);
        if (smallerSide > maxSide){

            maxSide = smallerSide;
            countMax = 1;
        } else if (smallerSide == maxSide ){
            countMax += 1;
        }
    }
    return countMax;
    }
}