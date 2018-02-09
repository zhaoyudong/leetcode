package me.zhaoyudong;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaoyudong on 2018/2/9.
 */
public class MaxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < k || k == 0)
            return new int[0];
        List<Integer> window = new ArrayList<>();


        int[] results = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                process(window, nums[i], null);
            } else {
                results[i - k + 1] = process(window, nums[i], i - k < 0 ? null : nums[i - k]);
            }
        }
        return results;
    }

    private int process(List<Integer> window, Integer add, Integer remove) {
        if (remove != null)
            window.remove(window.indexOf(remove));
        int index = getNextLowestIndex(window, 0, window.size() - 1, add);
        if (index == window.size()) {
            window.add(add);
        } else {
            window.add(index, add);
        }
        return window.get(window.size() - 1);
    }

    private int getNextLowestIndex(List<Integer> window, int start, int end, Integer add) {
        if (window.size() == 0)
            return 0;
        if (start == end) {
            return add < window.get(start) ? start : start + 1;
        } else if (start == end - 1) {
            return add < window.get(start) ? start : (window.get(end) < add ? end + 1 : end);
        }

        int mid = (start + end) / 2;
        if (window.get(mid) > add) {
            return getNextLowestIndex(window, 0, mid, add);
        } else {
            return getNextLowestIndex(window, mid, end, add);
        }
    }

    public static void main(String[] args) {
        System.out.println(new MaxSlidingWindow().maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));
    }
}
