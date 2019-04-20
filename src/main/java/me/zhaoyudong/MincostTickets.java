package me.zhaoyudong;

public class MincostTickets {
    public static void main(String[] args) {
        System.out.println(new MincostTickets().mincostTickets(new int[]{1, 4, 6, 7, 8, 20}, new int[]{2, 7, 15}));
    }

    public int mincostTickets(int[] days, int[] costs) {
        int[] array = new int[366];
        int index = 0;
        array[0] = 0;

        for (int i = 1; i < array.length; i++) {
            if (i != days[index]) {
                array[i] = array[i - 1];
            } else {
                if (i <= 7) {
                    array[i] = Math.min(array[i - 1] + costs[0], costs[1]);
                } else if (i <= 30) {
                    array[i] = Math.min(array[i - 1] + costs[0], Math.min(costs[2], array[i - 7] + costs[1]));
                } else {
                    array[i] = Math.min(array[i - 1] + costs[0], Math.min(array[i - 30] + costs[2], array[i - 7] + costs[1]));
                }

                if (index < days.length - 1) {
                    index++;
                }
            }
        }

        return array[365];
    }
}
