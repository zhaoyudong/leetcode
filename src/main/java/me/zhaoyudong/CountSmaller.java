package me.zhaoyudong;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhaoyudong on 2018/2/8.
 */
public class CountSmaller {

    public List<Integer> countSmaller(int[] nums) {
        if (nums.length == 0)
            return new ArrayList<>();
        if (nums.length == 1)
            return Arrays.asList(0);
        int[] results = new int[nums.length];
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            nodes.add(new Node(nums[i], i));
        }
        sortNodes(nodes, results);
        List<Integer> res = new ArrayList<>();
        for (int r : results) {
            res.add(r);
        }
        return res;
    }

    private List<Node> sortNodes(List<Node> nodes, int[] results) {
        if (nodes.size() < 2) return nodes;
        int midIndex = nodes.size() / 2;
        List<Node> begin = sortNodes(new ArrayList<>(nodes.subList(0, midIndex)), results);
        List<Node> end = sortNodes(new ArrayList<>(nodes.subList(midIndex, nodes.size())), results);
        return mergeArray(begin, end, results);
    }

    /**
     * TODO: 比较出结果时 end中剩余多少（end中比它小的） 在加上 begin中已经比自己小的数量 即为 smaller； 不必关心end中大值以及begin中小值，这些数据虽然会因为排序而移动但是并不影响其smaller
     */
    private List<Node> mergeArray(List<Node> begin, List<Node> end, int[] results) {
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < begin.size(); ) {
            Node beginNode = begin.get(i);
            if (end.size() == 0 || beginNode.getValue() > end.get(0).getValue()) {
                //当前右边剩下(end.size + 上一次排序)出来的比自己小的数据
                results[beginNode.getIndex()] += end.size();
                nodes.add(beginNode);
                i++;
            } else {
                nodes.add(end.get(0));
                end.remove(0);
            }
        }
        nodes.addAll(end);
        return nodes;
    }

    private class Node {
        private Integer value;
        private Integer index;

        public Node(Integer value, Integer index) {
            this.value = value;
            this.index = index;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        public Integer getIndex() {
            return index;
        }

        public void setIndex(Integer index) {
            this.index = index;
        }
    }


    public static void main(String[] args) {
        System.out.println(new CountSmaller().countSmaller(new int[]{26, 78, 27, 100, 33, 67, 90, 23, 66, 5, 38, 7, 35, 23, 52
                , 22, 83, 51, 98, 69, 81, 32, 78, 28, 94, 13, 2, 97, 3, 76, 99, 51, 9, 21, 84, 66, 65, 36, 100, 41}));
    }
}
