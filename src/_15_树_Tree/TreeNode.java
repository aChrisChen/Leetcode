package _15_树_Tree;

/**
 * Project Name: Leetcode
 * Package Name: _15_树_Tree
 * File Name: TreeNode
 * Creator: Jipeng Chen
 * Date: 6/4/20
 * Description: TODO
 */
public class TreeNode {
    public int val;
    public TreeNode left;

    public TreeNode right;

    public TreeNode() {}

    public TreeNode(int val) { this.val = val; }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
