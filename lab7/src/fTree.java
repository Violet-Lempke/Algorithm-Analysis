public class fTree {
    fTreeNode root;
    public fTree() {
        this.root = null;
    }

    

   
    public void insert(fTreeNode root, char x) {
        
        if (this.root == null) {
            
            this.root = new fTreeNode(x);
        
        }

        else {
            
            fTreeNode currentNode = this.root;
            fTreeNode currentRoot = this.root;
            
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

                    currentNode.frequency += 1;
                    return;

                }
                
            }

            if (x < currentRoot.key) {

                currentRoot.left = new fTreeNode(x);
                currentRoot.left.parent = currentRoot;

            }

            else {

                currentRoot.right = new fTreeNode(x);
                currentRoot.right.parent = currentRoot;

            }
        }
    }

    public void print() {

        intPrint(this.root);

    }

    private void intPrint(fTreeNode curRoot) {

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
