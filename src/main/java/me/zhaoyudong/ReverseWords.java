package me.zhaoyudong;

/**
 * Created by zhaoyudong on 2018/2/5.
 */
public class ReverseWords {
    public String reverseWords(String s) {
        if (s == null || s.equals(""))
            return s;
        s = s.trim().replaceAll("\\s+", " ");
        String[] arr = s.split(" ");
        if (arr.length == 0)
            return s;
        int n = arr.length % 2 > 0 ? arr.length / 2 : arr.length / 2 - 1;
        for (int i = 0; i <= n; i++) {
            String tmp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = tmp;
        }
        return String.join(" ", arr);
    }
}
