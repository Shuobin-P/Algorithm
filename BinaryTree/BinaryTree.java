package util;

import model.TreeNode;

public class BinaryTree {
    public static TreeNode constructBinaryTree(int[] array) {
        return createBinaryTreeByArray(array, 0);
    }

    private static TreeNode createBinaryTreeByArray(int[] array, int index) {
        TreeNode root = null;
        if (index < array.length) {
            int value = array[index];
            if (value == -1) return null;
            root = new TreeNode(value);
            root.left = createBinaryTreeByArray(array, 2 * index + 1);
            root.right = createBinaryTreeByArray(array, 2 * index + 2);
        }
        return root;
    }
}
