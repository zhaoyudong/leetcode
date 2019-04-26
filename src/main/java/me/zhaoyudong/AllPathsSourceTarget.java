package me.zhaoyudong;

import java.util.*;

public class AllPathsSourceTarget {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        if (graph == null || graph.length < 2) {
            return new ArrayList<>();
        }
        List<List<Integer>> array = new ArrayList<>();
        List<List<Integer>> tmp = dfs(graph, 0);
        if (tmp.size() > 0) {
            for (List<Integer> arr : tmp) {
                List<Integer> newArray = new ArrayList<>();
                newArray.add(0);
                newArray.addAll(arr);
                array.add(newArray);
            }
        }

        return array;
    }

    private List<List<Integer>> dfs(int[][] graph, int i) {
        if (i >= graph.length - 1 || graph[i] == null || graph[i].length == 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> array = new ArrayList<>();

        for (int num : graph[i]) {
            if (num == graph.length - 1) {
                array.add(Collections.singletonList(num));
            } else {
                List<List<Integer>> tmp = dfs(graph, num);
                if (tmp.size() > 0) {
                    for (List<Integer> arr : tmp) {
                        List<Integer> newArray = new ArrayList<>();
                        newArray.add(num);
                        newArray.addAll(arr);
                        array.add(newArray);
                    }
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        System.out.println(new AllPathsSourceTarget().allPathsSourceTarget(new int[][]{new int[]{1,2},new int[]{3},new int[]{3},new int[0]}));
    }
}
