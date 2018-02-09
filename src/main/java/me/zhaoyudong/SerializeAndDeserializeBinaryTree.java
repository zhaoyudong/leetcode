package me.zhaoyudong;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaoyudong on 2018/2/9.
 */
public class SerializeAndDeserializeBinaryTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            List<TreeNode> queue = new ArrayList<>();
            result.add(root.val);
            queue.add(root.left);
            queue.add(root.right);
            while (!processQueue(queue, result)) {

            }
        }
        List<Integer> removedIndex = new ArrayList<>();
        for (int i = result.size(); i > 0; i--) {
            Integer val = result.get(i - 1);
            if (val == null) {
                removedIndex.add(i - 1);
            } else {
                break;
            }
        }
        for (int index : removedIndex) {
            result.remove(index);
        }
        return result.toString();
    }

    private boolean processQueue(List<TreeNode> queue, List<Integer> result) {
        int length = queue.size();
        int i = 0;
        int count = 0;
        while (i < length) {
            TreeNode treeNode = queue.remove(0);
            if (treeNode == null) {
                result.add(null);
            } else {
                result.add(treeNode.val);
                queue.add(treeNode.left);
                queue.add(treeNode.right);
                if (treeNode.left != null || treeNode.right != null) {
                    count++;
                }
            }
            i++;
        }
        return count == 0;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.equals("") || data.equals("[]"))
            return null;
        String[] array = data.replace("[", "").replace("]", "")
                .replaceAll("\\s+", "").split(",");
        TreeNode root = null;
        List<TreeNode> queue = new ArrayList<>();
        for (int i = 0; i < array.length; ) {
            if (root == null) {
                if (!array[i].equals("null")) {
                    root = new TreeNode(Integer.parseInt(array[i]));
                    queue.add(root);
                }
                i++;
            } else {
                TreeNode treeNode = queue.remove(0);
                String left = array[i];
                i++;
                String right = null;
                if (i != array.length) {
                    right = array[i];
                    i++;
                }

                if (treeNode != null) {
                    treeNode.left = left.equals("null") ? null : new TreeNode(Integer.parseInt(left));
                    treeNode.right = right == null || right.equals("null") ? null : new TreeNode(Integer.parseInt(right));
                    if (treeNode.left != null)
                        queue.add(treeNode.left);
                    if (treeNode.right != null)
                        queue.add(treeNode.right);
                }
            }
        }
        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        SerializeAndDeserializeBinaryTree tree = new SerializeAndDeserializeBinaryTree();
        System.out.println(tree.serialize(tree.deserialize("[5,2,3,null,null,2,4,3,1]")));
    }
}
