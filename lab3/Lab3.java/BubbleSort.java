public class BubbleSort {
    public int[] sort(int[] array) {
        int comparisons = 0;
        int movements = 0;
        for (int ii = 0; ii < array.length - 1; ii++) {
            for (int jj = array.length - 1; jj > ii; jj--) {
                comparisons++;
                if (array[jj] < array[jj-1]) {
                    var temp = array[jj - 1];
                    movements++;
                    array[jj - 1 ] = array[jj];
                    movements++;
                    array[jj] = temp;
                    movements++;
                }
            }
        }
        int[] specs = new int[2];
        specs[0] = comparisons;
        specs[1] = movements;
        return specs;
    }
}
