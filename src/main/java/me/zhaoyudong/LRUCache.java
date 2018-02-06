package me.zhaoyudong;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhaoyudong on 2018/2/5.
 */
public class LRUCache {

    private Map<Integer, Integer> cache;
    private List<Integer> keys;
    private Integer capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.keys = new ArrayList<>();
        this.cache = new HashMap<>();
    }

    public int get(int key) {
        if (this.cache.containsKey(key)) {
            keys.remove((Integer) key);
            keys.add(key);
        }
        return this.cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        keys.remove((Integer) key);
        keys.add(key);
        this.cache.put(key, value);
        if (keys.size() > capacity) {
            List<Integer> removedKey = new ArrayList<>(keys.subList(0, keys.size() - capacity));
            this.keys.removeAll(removedKey);
            for (int i = 0; i < removedKey.size(); i++) {
                this.cache.remove(removedKey.get(i));
            }
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.get(1);
        lruCache.put(3, 3);
        lruCache.get(2);
        lruCache.put(4, 4);
        lruCache.get(1);
        lruCache.get(3);
        lruCache.get(4);
    }
}
