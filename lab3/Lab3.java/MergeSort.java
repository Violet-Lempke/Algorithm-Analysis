public class MergeSort {
    int movement = 0;
    int comparisons = 0;

    private void merge(int[] array, int p, int q, int r) {
        int n1 = (q - p + 1);
        int n2 = (r - q);

        int[] left = new int[n1];
        int[] right = new int[n2];

        

        for (int ii = 0; ii < (n1); ii++) {
            left[ii] = array[p + ii];
        }
        

        for (int ii = 0; ii < (n2); ii++) {
            right[ii] = array[q + 1 + ii];
        }
        
        // indexes are used to keep track of what portion of each subarray has already been placed.
        int leftIndex = 0;
        int rightIndex = 0;

        // total represents the total number of items we are merging which is used to prevent the uneccessary use of a while loop.
        
        int index = p;
        
        while (leftIndex < n1 && rightIndex < n2) {
            comparisons++;
            if ((left[leftIndex]) < (right[rightIndex])) {
                array[index] = left[leftIndex];
                movement++;
                index++;
                leftIndex++;
            }
            
            else {
                array[index] = right[rightIndex];
                movement++;
                index++;
                rightIndex++;
            }
        }

        while (leftIndex < n1) {
            //it should be noted that although no comparisons are actually
            //being made this is to simulate the number of comparisons that would be
            //made if sentinals were used. 
            comparisons++;
            array[index] = left[leftIndex];
            movement++;
            index++;
            leftIndex++;
        }

        while (rightIndex < n2) {
            comparisons++;
            array[index] = right[rightIndex];
            movement++;
            index++;
            rightIndex++;
        }
      

        
    }

    private void sort (int[] array, int p, int r) {
        if (p < r) {
            int q = ((p + r) / 2);
            sort(array, p, q);
            sort(array, (q + 1), r);
            merge(array, p, q, r);
        }
    }

    public int[] sort(int[] array) {
        sort(array, 0, array.length - 1);
        int[] specs = new int[2];
        specs[0] = comparisons;
        specs[1] = movement;
        return specs;
    }
}
