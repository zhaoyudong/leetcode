package me.zhaoyudong;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by zhaoyudong on 2018/2/6.
 */
public class StrongPasswordChecker {
    public int strongPasswordChecker(String s) {
        int count = 0;
        boolean remove = false;
        if (s.length() < 6) {
            count = 6 - s.length();
        } else if (s.length() > 20) {
            remove = true;
            count = s.length() - 20;
        }
        int uppercase = 0;
        int lowercase = 0;
        int digit = 0;
        List<Integer> repeat = new ArrayList<>();
        char tmp = 0;
        int tmpCount = 0;
        for (char c : s.toCharArray()) {
            if (c <= 'z' && c >= 'a') {
                lowercase++;
            } else if (c <= 'Z' && c >= 'A') {
                uppercase++;
            } else if (c <= '9' && c >= '0') {
                digit++;
            }
            if (tmp == 0) {
                tmp = c;
                tmpCount = 1;
            } else {
                if (tmp != c) {
                    if (tmpCount >= 3) {
                        repeat.add(tmpCount);
                    }
                    tmp = c;
                    tmpCount = 1;
                } else {
                    tmpCount++;
                }
            }
        }
        if (tmpCount >= 3) {
            repeat.add(tmpCount);
        }
        return calculateFinalCount(repeat, uppercase, lowercase, digit, count, remove);
    }

    private int calculateFinalCount(List<Integer> repeat, int uppercase, int lowercase,
                                    int digit, int count, boolean remove) {
        int modified = 0;
        int cachedCount = count;
        //优先处理移除%3余1的数字效率最高。
        Collections.sort(repeat, (o1, o2) -> o1 % 3 < o2 % 3 ? 1 : -1);
        for (Integer r : repeat) {
            if (remove) {
                if (count >= r - 2) {
                    count -= (r - 2);
                } else {
                    int reminder = r % 3 + 1;
                    if (count >= reminder) {
                        count -= reminder;
                        if (r % 3 == 0) {
                            modified += r / 3 - 1;
                        }
                    } else {
                        modified += r / 3;
                    }
                }
            } else {
                modified += r / 3;
            }
        }

        int typeCount = 0;
        if (uppercase == 0)
            typeCount++;
        if (lowercase == 0)
            typeCount++;
        if (digit == 0)
            typeCount++;

        if (!remove) {
            return Math.max(modified, Math.max(Math.max(modified, typeCount), count));
        } else {
            return Math.max(modified, typeCount) + cachedCount;
        }
    }

    public static void main(String[] args) {
        //6
        System.out.println(new StrongPasswordChecker().strongPasswordChecker(""));
        //1
        System.out.println(new StrongPasswordChecker().strongPasswordChecker("aA123"));
        //2
        System.out.println(new StrongPasswordChecker().strongPasswordChecker("aaa111"));
        //2
        System.out.println(new StrongPasswordChecker().strongPasswordChecker("ABABABABABABABABABAB1"));
        //3
        System.out.println(new StrongPasswordChecker().strongPasswordChecker("1234567890123456Baaaaa"));
        //7
        System.out.println(new StrongPasswordChecker().strongPasswordChecker("aaaaaaaaaaaaaaaaaaaaa"));
        //3
        System.out.println(new StrongPasswordChecker().strongPasswordChecker("pppppp1020304050607080"));
        //2
        System.out.println(new StrongPasswordChecker().strongPasswordChecker("1Abababcaaaabababababa"));
        //4
        System.out.println(new StrongPasswordChecker().strongPasswordChecker("aaaaaa1234567890123Ubefg"));
        //13
        System.out.println(new StrongPasswordChecker().strongPasswordChecker("aaaaaaaAAAAAA6666bbbbaaaaaaABBC"));
    }
}
