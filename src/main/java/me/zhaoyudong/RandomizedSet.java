package me.zhaoyudong;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by zhaoyudong on 2018/2/8.
 */
public class RandomizedSet {

    private List<Integer> array;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        this.array = new ArrayList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (array.contains(val)) {
            return false;
        }
        array.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!array.contains(val)) {
            return false;
        }
        array.remove((Integer) val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        if (array.size() == 0)
            return -1;
        return array.get(new Random().nextInt(array.size()));
    }
}
