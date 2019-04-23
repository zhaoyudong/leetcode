package me.zhaoyudong;

/**
 * https://leetcode-cn.com/problems/best-sightseeing-pair/
 */
public class MaxScoreSightseeingPair {
    public int maxScoreSightseeingPair(int[] A) {
        if (A == null || A.length < 2) {
            return 0;
        }
        int max = 0;
        int maxLeft = 0;
        for (int i = 0; i < A.length; i++) {
            max = Math.max(maxLeft + A[i] - i, max);
            maxLeft = Math.max(maxLeft, A[i] + i);
        }
        return max;
    }
}
