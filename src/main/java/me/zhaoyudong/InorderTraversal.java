package me.zhaoyudong;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> array = new ArrayList<>(inorderTraversal(root.left));
        array.add(root.val);
        array.addAll(inorderTraversal(root.right));
        return array;
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
