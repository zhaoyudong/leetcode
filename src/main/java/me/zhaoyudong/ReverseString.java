package me.zhaoyudong;

/**
 * Created by zhaoyudong on 2018/2/9.
 */
public class ReverseString {
    public String reverseString(String s) {
        if (s == null)
            return s;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i == chars.length / 2)
                break;
            char tmp = chars[i];
            chars[i] = chars[chars.length - i - 1];
            chars[chars.length - i - 1] = tmp;
        }
        return new String(chars);
    }
}
