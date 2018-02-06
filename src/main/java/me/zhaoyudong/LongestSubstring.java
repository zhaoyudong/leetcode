package me.zhaoyudong;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaoyudong on 2018/2/6.
 */
public class LongestSubstring {
    public int longestSubstring(String s, int k) {
        if (s == null || s.length() < k)
            return 0;
        return processString(s.charAt(0), s, k, 0);
    }

    private int processString(char c, String s, int k, int index) {
        if (s == null || s.length() < k)
            return 0;
        int count = 0;
        for (char tmp : s.toCharArray()) {
            if (tmp == c)
                count++;
        }
        if (count >= k) {
            if (index == s.length() - 1)
                return s.length();
            else {
                ++index;
                return processString(s.charAt(index), s, k, index);
            }
        } else {
            List<Integer> lengthArr = new ArrayList<>();
            String[] array = s.split(String.valueOf(c));
            for (String string : array) {
                if (string == null || string.length() < k)
                    continue;
                lengthArr.add(processString(string.charAt(0), string, k, 0));
            }
            return lengthArr.size() == 0 ? 0 : lengthArr.stream().max((m, n) -> m > n ? 1 : -1).get();
        }
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubstring().longestSubstring("ababbc", 2));
    }
}
