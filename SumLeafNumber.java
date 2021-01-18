//https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class SumLeafNumber {
    public int sumNumbers(TreeNode root) {
        int result = 0;
        if (root == null) {
            return result;
        }
        Stack<TreeNode> nodeStack = new Stack<>();
        nodeStack.push(root);
        TreeNode thisNode;
        while (!nodeStack.empty()) {
            thisNode = nodeStack.pop();
            if (thisNode.left != null) {
                nodeStack.push(thisNode.left);
                thisNode.left.val += thisNode.val * 10;
            }
            if (thisNode.right != null) {
                nodeStack.push(thisNode.right);
                thisNode.right.val += thisNode.val * 10;
            }
            if (thisNode.left == null && thisNode.right == null) {
                result += thisNode.val;
            }
        }
        return result;
    }
}
