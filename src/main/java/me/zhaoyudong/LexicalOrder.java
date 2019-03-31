package me.zhaoyudong;

import java.util.ArrayList;
import java.util.List;

public class LexicalOrder {

    public List<Integer> lexicalOrder(int n) {
        if (n <= 0) {
            return new ArrayList<>();
        }

        //共多少位
        int length = String.valueOf(n).length();

        List<Integer> result = new ArrayList<>();

        for (int i = 1; i < 10; i++) {
            if (i > n) {
                break;
            }
            result.add(i);
            fillArray(result, i, length - 1, n);
        }

        return result;
    }

    private void fillArray(List<Integer> result, int prefix, int remainLength, int n) {
        if (remainLength <= 0) {
            return;
        }
        prefix *= 10;
        for (int i = 0; i < 10; i++) {
            int tmp = prefix + i;
            if (tmp > n) {
                break;
            }

            result.add(tmp);

            fillArray(result, tmp, remainLength - 1, n);
        }
    }

    public static void main(String[] args) {
        System.out.println(new LexicalOrder().lexicalOrder(13));
    }
}
