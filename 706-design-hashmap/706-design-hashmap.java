class MyHashMap {
    
    HashMap<Integer , Integer> hash = new HashMap<>();

    public MyHashMap() {
      hash = new HashMap<>();
    }
    
   public void put(int key, int value) {
    hash.put(key,value);
}

public int get(int key) {
    if(hash.containsKey(key))
    return hash.get(key);
    return -1;
}

public void remove(int key) {
    hash.remove(key);
}
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */