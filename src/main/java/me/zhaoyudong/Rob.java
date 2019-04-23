package me.zhaoyudong;

public class Rob {

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(rob(nums, 1, nums.length - 1),
                rob(nums, 0, nums.length - 2));
    }

    public int rob(int[] nums, int start, int end) {
        //上一步的最优解
        int a = nums[start];
        //当前最优解
        //关键。b第一次不参与参操作，但是要在尝试一次之后用于设置a的value
        int b = Math.max(a, nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            //b更大的情况下不rob i，标记start-(i-1)的最优解是曾经的b，用于决定是否选取i+1，b是新的最优解
            int t = Math.max(b, a + nums[i]);
            a = b;
            b = t;
        }

        return Math.max(a, b);
    }

    public int rob2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int a = nums[0];
        int b = Math.max(a, nums[1]);

        for (int i = 2; i < nums.length; i++) {
            int tmp = Math.max(a + nums[i], b);
            a = b;
            b = tmp;
        }

        return b;
    }

}
