package me.zhaoyudong;

/**
 * 递增的三元子序列
 */
public class IncreasingTriplet {

    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int min = Integer.MAX_VALUE;
        int mid = Integer.MAX_VALUE;
        //贪心算法，永远保证min，mid是相对较小的增序列，如果再出现一个比mid大的就找到了
        for (int i = 0; i < nums.length; i++) {
            if (min >= nums[i]) {
                min = nums[i];
            } else if (min < nums[i] && mid >= nums[i]) {
                mid = nums[i];
            } else if (mid < nums[i]) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new IncreasingTriplet().increasingTriplet(new int[]{5,4,3,2,11}));
    }

}
