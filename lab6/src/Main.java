import java.util.*;

public class Main {
    public static void main(String[] args) {
        test1();
        test2();
        System.exit(0);
    }



    public static void test1() {

        System.out.println("Test 1: \n");

        int[] nodes = {9, 4, 17, 3, 6, 22, 5, 7, 20};

        BinaryTree testTree1 = new BinaryTree();
        for (int ii = 0; ii < nodes.length; ii ++) {

            testTree1.insert(testTree1.root, nodes[ii]);

        }

        System.out.println("Root: " + testTree1.root.left.left.key + " Height: " + testTree1.root.nodeHeight(testTree1.root.left.left) + '\n');

        System.out.println("Root: " + testTree1.root.left.right.key + " Height: " + testTree1.root.nodeHeight(testTree1.root.left.right) + '\n');

        System.out.println("Root: " + testTree1.root.left.key + " Height: " + testTree1.root.nodeHeight(testTree1.root.left) + '\n');

        System.out.println("Root: " + testTree1.root.key + " Height: " + testTree1.treeHeight() + '\n');
    

    }


    public static void test2() {

        int n = 0;

        System.out.println("Test 2: \n");

        for (int ii = 0; ii < 6; ii++) {


            switch(ii) {
                
                case 0: 

                    n = 10;
                    break;
                    
                case 1: 

                    n = 50;
                    break; 

                case 2: 

                    n = 100;
                    break;

                case 3:

                    n = 200;
                    break;

                case 4: 

                    n = 500;
                    break;

                case 5:

                    n = 1000;
                    break;

                
            }

            
            System.out.println("n: " + n);
            int grossHeight = 0;

            for (int jj = 0; jj < n; jj ++) {

                Random randomizer = new Random();

                int[] randomNodes = new int[n];

                ArrayList<Integer> seen = new ArrayList<Integer>();

                for (int vv = 0; vv < n;) {

                    int nextInt = randomizer.nextInt(n);
                    if (!seen.contains(nextInt)) {

                        seen.add(nextInt);
                        randomNodes[vv] = nextInt;
                        vv += 1;

                    }

                }
                
                BinaryTree testTree2 = new BinaryTree();

                for (int vv = 0; vv < n; vv++) {

                    testTree2.insert(testTree2.root, randomNodes[vv]);
                    
                }

                grossHeight += testTree2.treeHeight();
                
            }

            
            int avgHeight = (grossHeight / n);
            System.out.println("Average Height: " + avgHeight + '\n');

                    
        }
    }
}