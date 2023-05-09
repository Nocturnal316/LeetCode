class TimeMap {
    HashMap<String,TreeMap<Integer,String>> store;

    public TimeMap() {
        store = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!store.containsKey(key)){
            store.put(key,new TreeMap<>());
        }
        store.get(key).put(timestamp,value);
    }
    
    public String get(String key, int timestamp) {
        Integer time = timestamp;
        Integer floorKey = null;
        if(store.containsKey(key)){
           floorKey = store.get(key).floorKey(timestamp);
        }
       
        return floorKey != null ? store.get(key).get(floorKey) : "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */