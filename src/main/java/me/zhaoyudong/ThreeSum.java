package me.zhaoyudong;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhaoyudong on 2018/2/10.
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3)
            return new ArrayList<>();
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int a = nums[i];
            if (a > 0)
                break;
            int bi = i + 1;
            int ci = nums.length - 1;
            while (bi < ci) {
                int sum = a + nums[bi] + nums[ci];
                if (sum == 0) {
                    results.add(Arrays.asList(a, nums[bi], nums[ci]));
                    // 去除重复
                    while (nums[bi] == nums[++bi] & bi < ci) ;
                    while (nums[ci--] == nums[ci] & bi < ci) ;
                } else if (sum < 0) {
                    ++bi;
                } else {
                    --ci;
                }
            }
            while (nums[i] == nums[i + 1] && i < nums.length - 2)
                i++;
        }
        return results;
    }
}
