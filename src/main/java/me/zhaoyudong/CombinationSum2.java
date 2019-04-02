package me.zhaoyudong;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CombinationSum2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return new ArrayList<>();
        }

        Arrays.sort(candidates);

        return findArray(candidates, 0, target);
    }

    public List<List<Integer>> findArray(int[] candidates, int index, int target) {
        List<List<Integer>> array = new ArrayList<>();
        for (int i = index; i < candidates.length; i++) {
            if (i!=index && candidates[i] == candidates[i - 1]) {
                //不是第一次尝试，还和上一次值相同，跳过（上一次的尝试包含了这次的结果，没必要继续操作）
                continue;
            }
            if (candidates[i] > target) {
                break;
            }
            int tmpVal = candidates[i];
            List<List<Integer>> tmp = findArray(candidates, i + 1, target - tmpVal);
            if (tmp.size() > 0) {
                for (List<Integer> list : tmp) {
                    List<Integer> integers = new ArrayList<>();
                    integers.add(tmpVal);
                    integers.addAll(list);
                    array.add(integers);
                }
            } else if (tmpVal == target) {
                array.add(Collections.singletonList(tmpVal));
            }

        }

        return array;
    }

}
