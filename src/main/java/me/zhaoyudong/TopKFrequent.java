package me.zhaoyudong;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhaoyudong on 2018/2/10.
 */
public class TopKFrequent {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 1;
        int val = nums[0];
        List<Integer> res = new ArrayList<>();
        List<Integer> countArray = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            if (i == nums.length || nums[i] != val) {
                int index = getIndex(countArray, 0, countArray.size() - 1, count);
                if (index == -1) {
                    res.add(val);
                    countArray.add(count);
                } else {
                    countArray.add(index, count);
                    res.add(index, val);
                }
                if (i < nums.length) {
                    count = 1;
                    val = nums[i];
                }
            } else {
                count++;
            }
        }
        return res.subList(0, k);
    }

    private int getIndex(List<Integer> countArray, int start, int end, int count) {
        if (start > end)
            return -1;
        if (start == end)
            return countArray.get(start) < count ? start : start + 1;
        if (start == end - 1)
            return countArray.get(start) < count ? start : (countArray.get(end) > count ? end + 1 : end);
        int mid = (start + end) / 2;
        if (countArray.get(mid) < count)
            return getIndex(countArray, 0, mid, count);
        else if (countArray.get(mid) > count)
            return getIndex(countArray, mid, end, count);
        else
            return mid;
    }
}
