/**
 * 
 * Binary Tree Data Structure taken from previous lab. 
 * 
 */

public class BinaryTree {
    HuffmanNode root;
    public BinaryTree() {
        this.root = null;
    }

    public void insert(HuffmanNode node) {
        
        if (this.root == null) {
            
            this.root = node;
        
        }

        else {
            
            HuffmanNode currentNode = this.root;
            HuffmanNode currentRoot = this.root;
            
            while (currentNode != null) {
                
                if (node.frequency <= currentNode.frequency) {

                    currentRoot = currentNode;
                    currentNode = currentNode.left;
                
                }

                else if (node.frequency > currentNode.frequency) {
                    
                    currentRoot = currentNode;
                    currentNode = currentNode.right;
                
                }

                else {

                    

                }
                
            }

            if (node.frequency < currentRoot.frequency) {

                currentRoot.left = node;
                currentRoot.left.parent = currentRoot;

            }

            else {

                currentRoot.right = node;
                currentRoot.right.parent = currentRoot;

            }
        }
    }


    public void print() {

        intPrint(this.root);

    }

    private void intPrint(HuffmanNode curRoot) {

        if (curRoot != null) {

            intPrint(curRoot.left);
            if (curRoot.isLeaf) {
                System.out.println(curRoot.key + ": " + curRoot.frequency);
            }
            
            else {
                
                System.out.println(curRoot.frequency);
            }

            intPrint(curRoot.right);

        }
    }
}

