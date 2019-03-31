package me.zhaoyudong;

import java.math.BigDecimal;

public class MatrixScore {
    public int matrixScore(int[][] A) {

        for (int i = 0; i < A.length; i++) {
            if (A[i][0] == 0) {
                //需要反转行
                for (int j = 0; j < A[i].length; j++) {
                    A[i][j] = 1 - A[i][j];
                }
            }
        }

        for (int j = 1; j < A[0].length; j++) {
            int tmp = 0;
            for (int[] ints : A) {
                tmp += ints[j];
            }
            if (tmp <= A.length / 2) {
                //半数以上为0，反转列
                for (int i = 0; i < A.length; i++) {
                    A[i][j] = 1 - A[i][j];
                }
            }
        }

        return computeVal(A);
    }

    private int computeVal(int[][] A) {
        int val = 0;
        for (int[] ints : A) {
            StringBuilder str = new StringBuilder();
            for (int j = 0; j < ints.length; j++) {
                str.append(ints[j]);
            }
            val += Integer.parseInt(str.toString(), 2);
        }
        return val;
    }


}
