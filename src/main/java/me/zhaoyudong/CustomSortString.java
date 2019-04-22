package me.zhaoyudong;

public class CustomSortString {

    public String customSortString(String S, String T) {
        if (T == null || T.trim().length() == 0) {
            return T;
        }
        char[] tarr = T.toCharArray();

        int start = 0;
        for (char c : S.toCharArray()) {
            for (int i = start; i < tarr.length; i++) {
                if (tarr[i] == c) {
                    tarr[i] = tarr[start];
                    tarr[start] = c;
                    start++;
                }
            }
        }

        return new String(tarr);
    }

}
