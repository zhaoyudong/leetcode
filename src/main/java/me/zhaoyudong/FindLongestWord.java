package me.zhaoyudong;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindLongestWord {

    public String findLongestWord(String s, List<String> d) {
        if (s == null || s.length() == 0) {
            return "";
        }

        if (d == null || d.size() == 0) {
            return "";
        }

        List<String> tmp = new ArrayList<>(d);

        for (char c : s.toCharArray()) {
            for (int i = 0; i < tmp.size(); i++) {
                String str = tmp.get(i);
                if ("".equals(str)) {
                    continue;
                }
                if(str.charAt(0)==c){
                    tmp.set(i, str.substring(1));
                }
            }
        }
        int maxLength = 0;
        List<String> newList = new ArrayList<>();
        for (int i = 0; i < tmp.size(); i++) {
            if ("".equals(tmp.get(i))) {
                String pre = d.get(i);
                if (pre.length() > maxLength) {
                    newList.clear();
                    newList.add(pre);
                    maxLength = pre.length();
                } else if (pre.length() == maxLength) {
                    newList.add(pre);
                }
            }
        }
        Collections.sort(newList);
        return newList.size()>0?newList.get(0):"";
    }

    public static void main(String[] args) {
        System.out.println(new FindLongestWord().findLongestWord("abpcplea", Arrays.asList("ale","apple","monkey","plea")));
    }
}
