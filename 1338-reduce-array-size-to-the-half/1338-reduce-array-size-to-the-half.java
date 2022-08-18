class Solution {
    public int minSetSize(int[] arr) {
        int n = arr.length;
        HashMap<Integer, Integer> map=  new HashMap<>();
        for(int i:arr)map.put(i,map.getOrDefault(i,0)+1);
        if(map.size()==1)return 1;
        int minval = 0;
        int minkey = 0;
        // sorting the list of map type in the reverse order in order to find the minimum value set
        ArrayList<Map.Entry<Integer,Integer>>list = new ArrayList<Map.Entry<Integer,Integer>>(map.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<Integer,Integer>>(){
            public int compare(Map.Entry<Integer,Integer>o1, Map.Entry<Integer,Integer>o2){
                    return o2.getValue().compareTo(o1.getValue());
            }
        });
        // putting the list in the new map
        LinkedHashMap<Integer,Integer> newmap = new LinkedHashMap<>();
        for(Map.Entry<Integer,Integer>aa : list){
            newmap.put(aa.getKey(), aa.getValue());
        }        
        for(Map.Entry<Integer,Integer>entry:newmap.entrySet()){
            if(minval >= n/2) break;
            else {
                minval+=entry.getValue();
                minkey++;
            }
        }
        return minkey;
    }
}