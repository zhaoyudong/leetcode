package me.zhaoyudong;

import java.util.Arrays;
import java.util.Collections;

public class LargestSumAfterKNegations {

    public int largestSumAfterKNegations(int[] A, int K) {
        Arrays.sort(A);

        int absMin = 0;

        int sum = 0;

        for (int i = 0; i < A.length; i++) {
            if (K > 0 && A[i] <= 0) {
                A[i] = -A[i];
                absMin = i;
                K--;
            }

            sum += A[i];
        }

        if (K % 2 == 1) {
            int min = A[absMin];
            if (absMin < A.length - 1) {
                min = Math.min(A[absMin], A[absMin + 1]);
            }

            sum -= 2 * min;
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new LargestSumAfterKNegations().largestSumAfterKNegations(new int[]{4, 2, 3}, 1));
        System.out.println(new LargestSumAfterKNegations().largestSumAfterKNegations(new int[]{3, -1, 0, 2}, 3));
        System.out.println(new LargestSumAfterKNegations().largestSumAfterKNegations(new int[]{2, -3, -1, 5, -4}, 2));
    }
}
