public class BinaryTreeNode {
    int key;
    BinaryTreeNode left, right, parent;

    public BinaryTreeNode(int key) {
        this.key = key;
        left = null;
        right = null;
        parent = null;
    }


    public int nodeHeight(BinaryTreeNode pseudoRoot) {

        return ((intNodeHeight(pseudoRoot)) - 1);

    }

    private int intNodeHeight(BinaryTreeNode pseudoRoot) {

        if (pseudoRoot == null) {

            return 0;

        }

        else {

            int leftDepth = intNodeHeight(pseudoRoot.left);
            int rightDepth = intNodeHeight(pseudoRoot.right);

            if (leftDepth > rightDepth) {

                return leftDepth + 1;

            }

            else {

                return rightDepth + 1;
                
            }

        }
    }
}
