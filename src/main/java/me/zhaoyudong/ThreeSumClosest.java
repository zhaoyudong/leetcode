package me.zhaoyudong;

import java.util.Arrays;

public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            throw new IllegalArgumentException();
        }
        Arrays.sort(nums);
        return findMinNear(nums, 0, target, 2);
    }

    /**
     *
     * @param nums
     * @param index
     * @param target
     * @param level 此层级循环需要剩余的nums数量，比如循环第一个数，循环到最后一个可选值时，至少应该剩下2个数保证最后一个数字还能有两个值可以用于匹配
     * @return
     */
    private int findMinNear(int[] nums, int index, int target, int level) {
        if (level < 0 || nums.length == index) {
            return 0;
        }
        Integer near = null;

        for (int i = index; i < nums.length - level; i++) {
            if (i != index && nums[i] == nums[i - 1]) {
                //多次遍历到同一值
                continue;
            }
            int tmp = nums[i] + findMinNear(nums, i + 1, target - nums[i], level - 1);
            if (near == null) {
                near = tmp;
            } else {
                near = Math.abs(target - tmp) < Math.abs(target - near) ? tmp : near;
            }
        }
        return near;
    }

    public static void main(String[] args) {
        System.out.println(new ThreeSumClosest().threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }
}
