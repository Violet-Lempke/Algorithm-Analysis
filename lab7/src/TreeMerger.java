/**
 * 
 * Takes two nodes and relates them via a parent that is their combined frequency. 
 * 
 * 
 */

public class TreeMerger {
    HuffmanNode merger (HuffmanNode root1, HuffmanNode root2) {

        HuffmanNode root = new HuffmanNode(root1.frequency + root2.frequency);
        root1.parent = root;
        root2.parent = root;
        root.left = root1;
        root.right = root2;
        return root;
    }

    HuffmanNode merger (HuffmanNode root) {

        HuffmanNode newRoot = new HuffmanNode(root.frequency);
        root.parent = newRoot;
        newRoot.right = root;
        return root;

    }
}
