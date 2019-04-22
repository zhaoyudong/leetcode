package me.zhaoyudong;

import java.util.ArrayList;
import java.util.List;

public class MaximumSwap {

    public int maximumSwap(int num) {
        List<Integer> array = new ArrayList<>();
        List<Integer> maxVal = new ArrayList<>();

        while (num > 0) {
            int tmp = num % 10;
            array.add(tmp);
            if (maxVal.size() > 0) {
                maxVal.add(Math.max(tmp, maxVal.get(maxVal.size() - 1)));
            } else {
                maxVal.add(tmp);
            }
            num /= 10;
        }

        int result = 0;
        int times = 1;

        for (int i = array.size() - 1; i >= 0; i--) {
            int current = array.get(i);
            int max = maxVal.get(i);
            if (times > 0 && max > current) {
                //find first
                int index = 0;
                for (int j = 0; j <= i; j++) {
                    if (maxVal.get(j) == max) {
                        index = j;
                        break;
                    }
                }
                //swap
                array.set(index, current);
                current = max;
                times--;
            }

            result = result * 10 + current;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new MaximumSwap().maximumSwap(9973));
    }
}
