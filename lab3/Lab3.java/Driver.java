import java.util.Random;

public class Driver {
    // n is the number of items that will be randomly placed into our array
    static int n = 1000;
    public static void main(String[] args) {
        int grossMovements = 0;
        int grossComp = 0;
        for (int jj = 0; jj < 5000; jj++) {
            Random generator = new Random();
            int[] numbers = new int[n];
            for (int ii = 0; ii < n; ii++) {
                numbers[ii] = generator.nextInt(10);
            }

            //BubbleSort sorter = new BubbleSort();
            //InsertionSort sorter = new InsertionSort();
            MergeSort sorter = new MergeSort();
            //SelectionSort sorter = new SelectionSort();

            //int[] testSet = new int[4];

            //testSet[0] = 3;
            //testSet[1] = 1;
            //testSet[2] = 0;
            //testSet[3] = 2;
            int[] specs = new int[2];
            specs = sorter.sort(numbers);
            grossComp += specs[0];
            grossMovements += specs[1];
            //sorter.sort(testSet);
            
        }
        int meanComp = grossComp / 5000;
        int meanMove = grossMovements / 5000;
        System.out.printf("Mean comp is: %d Mean move is: %d", meanComp, meanMove);
        //System.out.println(meanMove);
    }
}