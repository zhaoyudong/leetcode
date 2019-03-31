package me.zhaoyudong;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SumArray3 {

    public static List<List<Integer>> combinationSum3(int k, int n) {
        if (k <= 0 || n <= 0) {
            return new ArrayList<>();
        }


        return buildArray(1, k, n);
    }

    private static List<List<Integer>> buildArray(int start, int k, int n) {
        if (k <= 0 || n <= 0 || start > n) {
            return new ArrayList<>();
        }
        if (k == 1 && n < 10) {
            return Collections.singletonList(Collections.singletonList(n));
        }
        List<List<Integer>> combination = new ArrayList<>();
        for (int j = start; j < 10; j++) {
            if (j >= n) {
                break;
            }
            List<List<Integer>> array = buildArray(j + 1, k - 1, n - j);
            if (array.size() > 0) {
                for (List<Integer> list : array) {
                    List<Integer> result = new ArrayList<>();
                    result.add(j);
                    result.addAll(list);
                    combination.add(result);
                }
            }

        }

        return combination;
    }

    public static void main(String[] args) {
        System.out.printf(combinationSum3(2, 18).toString());
    }
}
