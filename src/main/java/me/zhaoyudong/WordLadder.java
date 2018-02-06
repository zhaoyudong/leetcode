package me.zhaoyudong;

import java.util.*;

/**
 * Created by zhaoyudong on 2018/2/2.
 */
public class WordLadder {

    private Map<String, List<String>> startPath = new HashMap<>();
    private Map<String, List<String>> endPath = new HashMap<>();
    private int length = 1;
    private boolean done = false;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null || beginWord.length() != endWord.length() || !wordList.contains(endWord))
            return 0;
        if (beginWord.equals(endWord)) {
            return 1;
        }
        Set<String> wordSet = new HashSet<>(wordList);

        Set<String> startSet = new HashSet<>();
        startSet.add(beginWord);
        Set<String> endStart = new HashSet<>();
        endStart.add(endWord);

        startPath.put(beginWord, Arrays.asList(beginWord));
        endPath.put(endWord, Arrays.asList(endWord));

        processWord(startSet, endStart, wordSet, true);
        if (!done)
            return 0;
        return length;
    }

    private void processWord(Set<String> set1, Set<String> set2, Set<String> wordSet, boolean direct) {
        if (set1.size() == 0)
            return;
        if (set1.size() > set2.size())
            processWord(set2, set1, wordSet, !direct);
        else
            length++;

        wordSet.removeAll(set1);
        wordSet.removeAll(set2);

        Set<String> set = new HashSet<>();

        outer:
        if (!done) {
            for (String s : set1) {
                List<String> nextWords = getNextWords(s);
                for (String next : nextWords) {
                    if (done)
                        break outer;
                    buildMap(set2, set, wordSet, s, next, direct);
                }
            }
        }
        if (!done) {
            processWord(set2, set, wordSet, !direct);
        }
    }

    private void buildMap(Set<String> keySet, Set<String> newKeySet, Set<String> wordSet,
                          String first, String second, boolean direct) {
        if (keySet.contains(second)) {
            done = true;
        }
        Map<String, List<String>> map = direct ? startPath : endPath;

        if (!done & map.containsKey(first) & wordSet.contains(second)) {
            List<String> list = map.get(first);
            List<String> newArray = new ArrayList<>(list);
            newArray.add(second);
            map.put(second, newArray);
            newKeySet.add(second);
        }
    }

    private List<String> getNextWords(String beginWord) {
        List<String> nextWords = new ArrayList<>();
        for (int i = 0; i < beginWord.length(); i++) {
            char[] chars = beginWord.toCharArray();
            for (char ch = 'a'; ch <= 'z'; ch++) {
                chars[i] = ch;
                String word = new String(chars);
                nextWords.add(word);
            }
        }
        return nextWords;
    }
}
