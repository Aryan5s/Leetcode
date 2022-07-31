class Solution {
    public int reverse(int x) {
        
       	int reminder;
	long num = 0;
	int max = Integer.MAX_VALUE;
	int min = Integer.MIN_VALUE;

	while(x != 0) {
		reminder = x %10;
		num = num*10 + reminder;
		x = x/10;
	}

	if(num >= min && num < max) {
		return (int)num;
	} 

        return 0;

      
    }
}