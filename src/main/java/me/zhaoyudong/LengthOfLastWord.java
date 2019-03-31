package me.zhaoyudong;

public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        s = s.trim();
        int spaceIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                spaceIndex = i;
            }
        }

        return spaceIndex == 0 ? s.length() : s.length() - spaceIndex - 1;
    }

    public static void main(String[] args) {
        System.out.println(new LengthOfLastWord().lengthOfLastWord("Hello World"));
    }
}
