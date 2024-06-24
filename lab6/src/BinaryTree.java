public class BinaryTree {
    BinaryTreeNode root;
    public BinaryTree() {
        this.root = null;
    }

    public void insert(BinaryTreeNode root, int x) {
        
        if (this.root == null) {
            
            this.root = new BinaryTreeNode(x);
        
        }

        else {
            
            BinaryTreeNode currentNode = this.root;
            BinaryTreeNode currentRoot = this.root;
            
            while (currentNode != null) {
                
                if (x < currentNode.key) {

                    currentRoot = currentNode;
                    currentNode = currentNode.left;
                
                }

                else if (x > currentNode.key) {
                    
                    currentRoot = currentNode;
                    currentNode = currentNode.right;
                
                }

                else {

                    System.out.println("Item already in list");

                }
                
            }

            if (x < currentRoot.key) {

                currentRoot.left = new BinaryTreeNode(x);
                currentRoot.left.parent = currentRoot;

            }

            else {

                currentRoot.right = new BinaryTreeNode(x);
                currentRoot.right.parent = currentRoot;

            }
        }
    }

    public void print() {

        intPrint(this.root);

    }

    private void intPrint(BinaryTreeNode curRoot) {

        if (curRoot != null) {

            intPrint(curRoot.left);
            System.out.println(curRoot.key);
            intPrint(curRoot.right);

        }
    }
        
    public int treeHeight() {
        
        return this.root.nodeHeight(this.root);

    }
}
