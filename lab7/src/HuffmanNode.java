public class HuffmanNode {
    char key;
    int frequency;
    HuffmanNode left;
    HuffmanNode right, parent;
    boolean isLeaf;

    public HuffmanNode(CharFreq lilguy) {
        this.key = lilguy.character;
        this.frequency = lilguy.freq;
        this.left = null;
        this.right = null;
        this.parent = null;
        this.isLeaf = true;

    }

    public HuffmanNode(int freq) {
        
        this.frequency = freq;
        this.left = null;
        this.right = null;
        this.parent = null;
        this.isLeaf = false;
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
}