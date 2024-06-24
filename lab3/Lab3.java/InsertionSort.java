public class InsertionSort {

    
    public int[] sort(int[] array) {
        int n = array.length;
        int comparisons = 0;
        int movements = 0;


        for (int j = 1; j < n; j++) {
            int k = array[j];
            movements++;

            int i = j-1;

            comparisons++;
            while (i > 0 && array[i] > k) {
                array[i+1] = array[i];
                movements++;
                i--;
                comparisons++;
            }
            array[i+1] = k;
            movements++;
        }

        int[] specs = new int[2];
        specs[0] = comparisons;
        specs[1] = movements;
        return specs;
    }
    
}