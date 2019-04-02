package me.zhaoyudong;

import java.util.*;

public class MinFallingPathSum {

    public int minFallingPathSum(int[][] A) {
        if (A.length == 1) {
            return A[0][0];
        }
        Integer min = null;

        for (int i = A.length - 2; i >= 0; i--) {
            for (int j = 0; j < A[i].length; j++) {
                A[i][j] += min(A, i + 1, j);
                if (i == 0) {
                    min = min == null ? A[i][j] : Math.min(min, A[i][j]);
                }
            }
            System.out.println(Arrays.toString(A[i]));
        }

        return min;
    }

    public Integer min(int[][] A, int x, int y) {
        if (x >= A.length) {
            return 0;
        }

        Integer min = null;

        for (int j = -1; j <= 1; j++) {
            if (y + j < 0 || y + j == A.length) {
                continue;
            }

            int tmp = A[x][y + j];

            if (min == null) {
                min = tmp;
            } else {
                min = Math.min(min, tmp);
            }
        }

        return min;
    }

    //[[-51,-35,74],[-62,14,-53],[94,61,-10]]
    public static void main(String[] args) {
        System.out.println(new MinFallingPathSum().minFallingPathSum(new int[][]{
                new int[]{-51, -35, 74}, new int[]{-62, 14, -53}, new int[]{94, 61, -10}
        }));
    }
}
