package me.zhaoyudong;

public class MinMoves {

    /**
     *  n-1个数同时加一，就好比每次有一个数自身减一
     * @param nums
     * @return
     */
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for(int num:nums){
            sum+=num;
            min = Math.min(min, num);
        }
        return sum - min*nums.length;
    }
}
