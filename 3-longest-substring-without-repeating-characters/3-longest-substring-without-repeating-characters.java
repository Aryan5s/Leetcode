class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        
        int left = 0, right = 0, res = 0;
        
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            
            window.put(c, window.getOrDefault(c, 0) + 1);
            
            // shrink
            while (window.get(c) > 1) {
                char d = s.charAt(left);
                left++;
                
                window.put(d, window.getOrDefault(d, 0) - 1);
            }
            
            res = Math.max(res, right - left);
        }
        return res;
    }
}