class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0 || strs == null) return new ArrayList<>();
        HashMap<String, List<String>> groupsMap = new HashMap<>();
        
        for(String str : strs) {
            String hashCode = stringifyWord(str);
            
            groupsMap.putIfAbsent(hashCode, new ArrayList<>());
            groupsMap.get(hashCode).add(str);
        }
        
        return new ArrayList<>(groupsMap.values());
    }
    
    private String stringifyWord(String word) {
        int[] freqMap = new int[26];
		
        for(int c : word.toCharArray())
            freqMap[c - 'a']++;
			
        StringBuilder sb = new StringBuilder();
		
        for(int count : freqMap)
            sb.append(count).append(',');
			
        return sb.toString();
    }
}