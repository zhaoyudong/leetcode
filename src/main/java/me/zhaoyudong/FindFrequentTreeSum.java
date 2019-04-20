package me.zhaoyudong;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/most-frequent-subtree-sum/
 */
public class FindFrequentTreeSum {

    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        Map<Integer, Integer> countMap = new HashMap<>();
        processTree(root, countMap);
        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(countMap.entrySet());

        entries.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        int max = entries.get(0).getValue();
        int size = 0;

        for (Map.Entry<Integer, Integer> entry : entries) {
            if (entry.getValue() == max) {
                size++;
            } else {
                break;
            }
        }

        int[] result = new int[size];
        for(int i=0;i<size;i++){
            result[i] = entries.get(i).getKey();
        }
        return result;

    }

    private int processTree(TreeNode treeNode, Map<Integer, Integer> countMap) {
        if (treeNode == null) {
            return 0;
        }

        int left = processTree(treeNode.left, countMap);
        int right = processTree(treeNode.right, countMap);

        int value = treeNode.val + left + right;
        countMap.put(value, countMap.getOrDefault(value, 0) + 1);
        return value;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
