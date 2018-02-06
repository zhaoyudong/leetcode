package me.zhaoyudong;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhaoyudong on 2018/2/6.
 */
public class FourSumCount {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if (A.length == 0 || B.length == 0 || C.length == 0 || D.length == 0)
            return 0;
        Map<Integer, Integer> ab = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int value = A[i] + B[j];
                Integer val = ab.getOrDefault(value, 0);
                val++;
                ab.put(value, val);
            }
        }
        int totalCount = 0;
        for (int m = 0; m < C.length; m++) {
            for (int n = 0; n < D.length; n++) {
                int value = -1 * (C[m] + D[n]);
                if (!ab.containsKey(value))
                    continue;
                Integer val = ab.get(value);
                totalCount += val;
            }
        }
        return totalCount;
    }

    public static void main(String[] args) {
        System.out.println(new FourSumCount().fourSumCount(new int[]{1, 1, -1, -1},
                new int[]{-1, -1, 1, 1},
                new int[]{1, -1, 0, -1},
                new int[]{1, 1, -1, 1}));
    }
}
