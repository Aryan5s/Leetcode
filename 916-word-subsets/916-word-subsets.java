class Solution {
   public List<String> wordSubsets(String[] words1, String[] words2) {
    List<String> result=new ArrayList<>();      
    int[] freq2=new int[26];                    //to count the frequency of that common word of words2
    
    for(String word : words2){
        int[] temp=new int[26];                 //to count the frequency of each string (word) of words2
        for(char ch:word.toCharArray()){        
            temp[ch-'a']++;
            freq2[ch-'a']=Math.max(freq2[ch-'a'],temp[ch-'a']);         //store the maximum freq of that char in freq2 to generate a common word frequency
        }
    }
    
    for(String word : words1){
        int[] freq1=new int[26];            //count the frequency of each word in words1
        for(char ch:word.toCharArray()){
            freq1[ch-'a']++;
        }
        
        if(isSubset(freq1,freq2)){          //check whether words2 (common word) is subset of words1 or not
            result.add(word);
        }
    }
    
    return result;
}

private boolean isSubset(int[] words1Freq, int[] words2Freq){           
    for(int i=0;i<26;i++){
        if(words1Freq[i] < words2Freq[i])           //frequency of words1Freq is less than required count(freq) of common word of words2 then return false, Because it must be greater or equal
            return false;
    }
    return true;
}
}