package me.zhaoyudong;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length <= 1) {
            return new int[]{};
        }
        int[] results = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            int tmp = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (tmp + nums[j] == target) {
                    results[0] = i;
                    results[1] = j;
                    break;
                }
            }
        }
        return results;
    }

    public static void main(String[] args) {
        int[] res = twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(res[0] + " " + res[1]);
    }
}
