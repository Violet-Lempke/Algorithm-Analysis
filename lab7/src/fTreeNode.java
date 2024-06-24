public class fTreeNode {
    char key;
    int frequency;
    fTreeNode left, right, parent;

    public fTreeNode(char key) {
        this.key = key;
        this.frequency = 1;
        left = null;
        right = null;
        parent = null;
    }


    public int nodeHeight(fTreeNode pseudoRoot) {

        return ((intNodeHeight(pseudoRoot)) - 1);

    }

    private int intNodeHeight(fTreeNode pseudoRoot) {

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

    public fTreeNode getLeft() {
        return this.left;
    }

    public fTreeNode getRight() {

        return this.right;
    }

    public String getText() {

        return (this.key + ": " + (this.frequency));
    }
}

