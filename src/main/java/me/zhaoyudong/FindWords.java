package me.zhaoyudong;

import java.util.ArrayList;
import java.util.List;

public class FindWords {
    public String[] findWords(String[] words) {


        List<String> result = new ArrayList<>();

        for (String w : words) {
            if (w == null || w.length() == 0) {
                continue;
            }

            String line = findLine(w);

            if (match(w.toLowerCase(), line)) {
                result.add(w);
            }
        }

        return result.toArray(new String[0]);
    }

    private String findLine(String word) {
        String line1 = "qwertyuiop";
        String line2 = "asdfghjkl";
        String line3 = "zxcvbnm";

        String first = word.toLowerCase().charAt(0) + "";
        if (line1.contains(first)) {
            return line1;
        } else if (line2.contains(first)) {
            return line2;
        } else {
            return line3;
        }
    }

    private boolean match(String word, String line) {
        for (char c : word.toCharArray()) {
            if (!line.contains(c + "")) {
                return false;
            }
        }
        return true;
    }
}
