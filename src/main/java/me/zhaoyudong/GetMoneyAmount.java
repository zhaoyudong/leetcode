package me.zhaoyudong;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GetMoneyAmount {

    public static void main(String[] args) {
        System.out.println(new GetMoneyAmount().getMoneyAmount(7));
    }

    public int getMoneyAmount(int n) {
        //使用[i][j]表示从i到j需要的最小金额
        //问题就转化为了a[i][j] = min( max(a[i][mid-1] + mid, mid + a[mid+1][j]) )
        int[][] array = new int[n + 1][n + 1];

        for (int large = 1; large <= n; large++) {
            for (int lower = large; lower > 0; lower--) {
                if (lower == large) {
                    array[lower][large] = 0;
                } else if (lower == large - 1) {
                    array[lower][large] = lower;
                } else {
                    List<Integer> tmp = new ArrayList<>();
                    for (int mid = large - 1; mid > lower; mid--) {
                        tmp.add(Math.max(array[lower][mid - 1] + mid, mid + array[mid + 1][large]));
                    }
                    Collections.sort(tmp);
                    array[lower][large] = tmp.get(0);
                }
            }
        }

        return array[1][n];
    }
}
