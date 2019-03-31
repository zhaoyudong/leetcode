package me.zhaoyudong;

import java.util.ArrayList;
import java.util.List;

public class RLEIterator {

    private List<Integer> rleArray = new ArrayList<>();

    public RLEIterator(int[] A) {
        if (A != null) {
            for (int i : A) {
                this.rleArray.add(i);
            }
        }

    }

    public int next(int n) {
        if (rleArray.size() == 0) {
            return -1;
        }

        int index = -1;
        int val = -1;

        for (int i = 0; i < rleArray.size(); i += 2) {
            if (n == 0) {
                break;
            }
            int count = rleArray.get(i);
            if (count > n) {
                rleArray.set(i, count - n);
                n = 0;
            } else {
                n -= count;
                rleArray.set(i, 0);
                index = i;
            }
            val = rleArray.get(i + 1);
        }

        if (n > 0) {
            this.rleArray = new ArrayList<>();
            return -1;
        }

        if (index + 1 == rleArray.size()) {
            this.rleArray = new ArrayList<>();
        } else if (index >= 0) {
            this.rleArray = new ArrayList<>(rleArray.subList(index + 2, rleArray.size()));
        }

        return val;
    }
}
