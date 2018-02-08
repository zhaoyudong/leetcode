package me.zhaoyudong;

import java.util.*;

/**
 * Created by zhaoyudong on 2018/2/8.
 */
public class ShuffleAnArray {

    private int[] origin;
    private Map<Integer, Integer> numMap = new HashMap<>();

    public ShuffleAnArray(int[] nums) {
        this.origin = nums;
        if (origin.length > 1) {
            for (int num : nums) {
                int count = numMap.getOrDefault(num, 0);
                count++;
                numMap.put(num, count);
            }
        }
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return this.origin;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        if (origin.length == 0 || origin.length == 1)
            return this.origin;
        List<Integer> indexArr = new ArrayList<>();
        for (int i = 0; i < this.origin.length; i++) {
            indexArr.add(i);
        }
        int[] result = new int[origin.length];
        this.numMap.forEach((k, v) -> {
            for (int i = 0; i < v; i++) {
                int index = indexArr.get(new Random().nextInt(indexArr.size()));
                indexArr.remove((Integer) index);
                result[index] = k;
            }
        });
        return result;
    }
}
