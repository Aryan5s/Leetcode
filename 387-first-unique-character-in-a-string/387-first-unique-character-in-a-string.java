class Solution {
    public int firstUniqChar(String s) {
        int[] freq = getFrequencies(s);
        int firstUniqCharIndex = -1;
        int n = s.length();
        for(int i = 0; i< n;i++){
            char ch = s.charAt(i);
            if(freq[ch-'a'] == 1){
                firstUniqCharIndex = i;
                break;
            }
        }
        return firstUniqCharIndex;
    }
    public int[] getFrequencies(String s){
        int[] freq = new int[26];
        for(char ch : s.toCharArray()){
            freq[ch-'a']++;
        }
        return freq;
    }
}