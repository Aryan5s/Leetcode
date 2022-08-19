class Solution {
    public String convert(String s, int numRows) {
       if(numRows == 1 || numRows > s.length())
			return s;
		int jump= numRows + (numRows -2);
		StringBuilder result = new StringBuilder();
		for(int i=0; i<numRows;i++){
			int currentIndex= i;
			result.append(s.charAt(i));
            int firstJump = jump - (i *2);
            int secondJump = jump - firstJump ;
			while(currentIndex < s.length()){
				if(firstJump!=0){
                    currentIndex = currentIndex + firstJump;
                    if(currentIndex >= s.length())
                        continue;
                    result.append(s.charAt(currentIndex));
				}
				if(secondJump!=0){
                    currentIndex = currentIndex + secondJump;
                    if(currentIndex >= s.length())
                        continue;
                    result.append(s.charAt(currentIndex));
				}
			}
	
		}
		return result.toString();
        
        
    }
}