package me.zhaoyudong;

public class TitleToNumber {
    public int titleToNumber(String s) {
        if (s == null) {
            return 0;
        }
        int col = 0;
        for (int i = 0; i < s.length(); i++) {
            col += (((int) s.charAt(i) - 64) * Math.pow(26, s.length() - i - 1));
        }
        return col;
    }
}
