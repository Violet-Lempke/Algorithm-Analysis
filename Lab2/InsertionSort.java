public class InsertionSort implements Sorter{

    @Override
    public void sort(Comparable[] array) {
        int n = array.length;

        for (int j = 1; j < n; j++) {
            Comparable k = array[j];
            int i = j-1;

            while (i >= 0 && array[i].compareTo(k) > 0) {
                array[i+1] = array[i];
                i--;
            }
            array[i+1] = k;
        }
    }
    
}
