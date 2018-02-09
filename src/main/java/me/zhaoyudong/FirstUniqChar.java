package me.zhaoyudong;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by zhaoyudong on 2018/2/9.
 */
public class FirstUniqChar {
    public int firstUniqChar(String s) {
        if (s == null)
            return -1;
        List<Character> characters = new ArrayList<>();
        Set<Character> duplicate = new HashSet<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (characters.contains(c)) {
                duplicate.add(c);
            }
            characters.add(c);
        }
        characters.removeAll(duplicate);
        return characters.size() == 0 ? -1 : s.indexOf(characters.get(0));
    }
}
