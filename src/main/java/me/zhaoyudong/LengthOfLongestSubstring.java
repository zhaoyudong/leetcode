package me.zhaoyudong;

import java.util.ArrayList;
import java.util.List;

public class LengthOfLongestSubstring {

    /**
     * 回退 cahce
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int length = 0;
        int lengthCache = 0;

        List<Character> cache = new ArrayList<>();

        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (!cache.contains(c)) {
                cache.add(c);

                length++;
            } else {

                if (length > lengthCache) {
                    lengthCache = length;
                }

                length = 0;

                int index = cache.indexOf(c);
                i = i - (cache.size() - index);
                cache.clear();
            }
        }

        return length > lengthCache ? length : lengthCache;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
