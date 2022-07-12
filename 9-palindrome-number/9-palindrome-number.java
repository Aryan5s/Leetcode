class Solution {
   public static boolean isPalindrome(int num){
       if(num<0){
           return false;
       }
        int temp = num;
        int rev = 0;
        while(temp != 0){
            rev = rev * 10 + temp % 10;
            temp = temp / 10;
        }
        return num == rev;
    }
}
