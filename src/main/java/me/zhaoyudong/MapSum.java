package me.zhaoyudong;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapSum {

    private Map<String, Integer> dataMap;

    /**
     * Initialize your data structure here.
     */
    public MapSum() {
        this.dataMap = new HashMap<>();
    }

    public void insert(String key, int val) {
        this.dataMap.put(key, val);
    }

    public int sum(String prefix) {
        int count = 0;
        for (Map.Entry<String, Integer> entry : this.dataMap.entrySet()) {
            if (entry.getKey().startsWith(prefix)) {
                count += entry.getValue();
            }
        }
        return count;
    }
}
