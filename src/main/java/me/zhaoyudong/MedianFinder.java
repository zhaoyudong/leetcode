package me.zhaoyudong;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaoyudong on 2018/2/9.
 */
public class MedianFinder {

    private List<Integer> nums;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        this.nums = new ArrayList<>();
    }

    public void addNum(int num) {
        if (nums.size() == 0) {
            nums.add(num);
            return;
        }
        int index = getNextLowest(num, 0, nums.size() - 1);
        if (index == nums.size()) {
            nums.add(num);
        } else {
            nums.add(index, num);
        }

    }

    private int getNextLowest(int num, int start, int end) {
        if (start == end) {
            return nums.get(start) > num ? start : end + 1;
        } else if (end == start + 1) {
            return nums.get(start) > num ? start : (nums.get(end) < num ? end + 1 : end);
        }

        int mid = (start + end) / 2;
        if (nums.get(mid) == num)
            return mid;
        if (nums.get(mid) > num) {
            return getNextLowest(num, start, mid);
        } else {
            return getNextLowest(num, mid, end);
        }
    }


    public double findMedian() {
        if (nums.size() == 0)
            return -1;
        if (nums.size() == 1)
            return nums.get(0);
        int remainder = nums.size() % 2;
        int mid = nums.size() / 2;
        if (remainder == 1) {
            return nums.get(mid);
        } else {
            return (double) (nums.get(mid - 1) + nums.get(mid)) / 2;
        }
    }
}
