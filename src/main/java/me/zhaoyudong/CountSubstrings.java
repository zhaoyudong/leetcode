package me.zhaoyudong;

public class CountSubstrings {
    public int countSubstrings(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int[][] matrix = new int[s.length()][s.length()];

        int count = 1;
        matrix[0][0] = 1;
        for (int i = 1; i < s.length(); i++) {
            for (int j = i; j >= 0; j--) {
                if (j == i) {
                    matrix[j][i] = 1;
                    count++;
                } else if (j + 1 == i) {
                    if (s.charAt(i) == s.charAt(j)) {
                        matrix[j][i] = 1;
                        count++;
                    }
                } else {
                    if (s.charAt(i) == s.charAt(j) && matrix[j + 1][i - 1] == 1) {
                        matrix[j][i] = 1;
                        count++;
                    }
                }
            }
        }

        return count;
    }

}
