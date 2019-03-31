package me.zhaoyudong;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeckRevealedIncreasing {
    public int[] deckRevealedIncreasing(int[] deck) {
        if (deck == null || deck.length == 0) {
            return new int[0];
        }
        //先排序
        Arrays.sort(deck);

        List<Integer> array = new ArrayList<>();
        for (int i = deck.length - 1; i >= 0; i--) {
            if (array.size() == 0) {
                //无牌时，不用将最后一张牌提到第一位
                array.add(deck[i]);
                continue;
            }
            array.add(0, deck[i]);
            if (i != 0) {
                //第一个操作是拿出第一张牌
                int val = array.get(array.size() - 1);
                array.remove(array.size() - 1);
                array.add(0, val);
            }

        }

        for (int i = 0; i < array.size(); i++) {
            deck[i] = array.get(i);
        }
        return deck;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new DeckRevealedIncreasing().deckRevealedIncreasing(new int[]{17, 13, 11, 2, 3, 5, 7})));
    }

}
