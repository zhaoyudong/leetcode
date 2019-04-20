package me.zhaoyudong;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/coin-change/
 */
public class CoinChange {

    public static void main(String[] args) {
        System.out.println(new CoinChange().coinChange(new int[]{1, 2, 5}, 100));
    }

    public int coinChange(int[] coins, int amount) {
        int[] array = new int[amount + 1];
        Arrays.fill(array, Integer.MAX_VALUE);
        array[0] = 0;
        for (int i = 1; i < array.length; i++) {

            boolean change = false;
            for (int coin : coins) {
                if (i - coin >= 0 && array[i - coin] != -1) {
                    change = true;
                    array[i] = Math.min(array[i], array[i - coin] + 1);
                }
            }

            if (!change) {
                array[i] = -1;
            }
        }

        return  array[amount];
    }
}
