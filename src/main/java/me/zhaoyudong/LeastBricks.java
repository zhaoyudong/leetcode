package me.zhaoyudong;

import java.util.*;

public class LeastBricks {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> records = new HashMap<>();

        for (List<Integer> integers : wall) {
            int tmp = 0;
            for (Integer integer : integers) {
                tmp += integer;
                Integer count = records.getOrDefault(tmp, 0);
                count++;
                records.put(tmp, count);
            }
        }
        List<Integer> counts = new ArrayList<>(records.values());
        Collections.sort(counts);

        int through = 0;
        if (counts.size() == 1) {
            through = 0;
        } else {
            through = counts.get(counts.size() - 2);
        }
        return wall.size() - through;
    }
}
