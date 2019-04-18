package me.zhaoyudong;

public class SmallestFromLeaf {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public String smallestFromLeaf(TreeNode root) {
        if (root == null) {
            return "";
        }
        return find(root, "");
    }

    public String find(TreeNode node, String endWith) {
        if (node == null) return (char) ('a' + 26) + endWith;
        endWith = (char) ('a' + node.val) + endWith;
        if (node.left == null && node.right == null) {
            return endWith;
        }

        String left = find(node.left, endWith);
        String right = find(node.right, endWith);
        return left.compareTo(right) > 0 ? right : left;
    }

}
