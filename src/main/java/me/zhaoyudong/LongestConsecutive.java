package me.zhaoyudong;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutive {

    public int longestConsecutive(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length <= 1) {
            return nums.length;
        }
        int max = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            if (countMap.containsKey(num)) {
                //已处理过num跳过，否则会干扰结果
                continue;
            }

            int left = countMap.getOrDefault(num + 1, 0);
            int right = countMap.getOrDefault(num - 1, 0);

            int count = left + 1 + right;
            countMap.put(num, count);
            //下面两步很关键，将长度扩散到边界处而不是左右邻接
            countMap.put(num + left, count);
            countMap.put(num - right, count);
            max = Math.max(max, count);
        }
        return max;
    }
}
