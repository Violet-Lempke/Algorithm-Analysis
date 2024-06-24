public class SelectionSort {
    
    public int[] sort (int[] array) {
        int n = array.length;
        int comparisons = 0;
        int movements = 0;

        for (var ii = 0; ii < n - 1; ii++) {
            var min = ii;
            
            for (var jj = ii + 1; jj < n; jj++) {
                if (array[jj] < (array[min])) {
                    min = jj;
                }
                comparisons++;
            }
            if (min != ii) {
                var temp = array[ii];
                array[ii] = array[min];
                array[min] = temp;
                movements += 3;
            }
        }
        int[] specs = new int[2];
        specs[0] = comparisons;
        specs[1] = movements;
        return specs;
    }
}
