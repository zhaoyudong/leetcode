package me.zhaoyudong;

import java.util.Arrays;

public class CanConstruct {

    public boolean canConstruct(String ransomNote, String magazine) {
        char[] a1 = ransomNote.toCharArray();
        char[] a2 = magazine.toCharArray();

        Arrays.sort(a1);
        Arrays.sort(a2);

        int s1 = 0;
        int s2 = 0;

        int match = 0;

        for (; ; ) {
            if (s1 == a1.length || s2 == a2.length) {
                break;
            }

            if (a1[s1] > a2[s2]) {
                s2++;
            } else if (a1[s1] < a2[s2]) {
                s1++;
            } else {
                s1++;
                s2++;
                match++;
            }
        }

        return match == a1.length;
    }

}
