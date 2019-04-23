package me.zhaoyudong;

import java.util.ArrayList;
import java.util.List;

public class WidthOfBinaryTree {

    public int widthOfBinaryTree(TreeNode root) {
        List<TreeNode> current = new ArrayList<>();
        List<TreeNode> next = new ArrayList<>();

        int max = 0;

        current.add(root);

        while (!current.isEmpty()) {
            int last = 0;
            int first = 0;
            for (int i = 0; i < current.size(); i++) {
                TreeNode c = current.get(i);
                if (c != null) {
                    next.add(c.left);
                    next.add(c.right);
                    last = i + 1;
                } else {
                    if (last == 0) {
                        first++;
                    } else {
                        next.add(null);
                        next.add(null);
                    }
                }
            }
            if (last == 0) {
                break;
            }

            current.clear();
            current.addAll(next);
            next.clear();

            max = Math.max(max, last - first);
        }

        return max;
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
