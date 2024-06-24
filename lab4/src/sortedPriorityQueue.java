public class sortedPriorityQueue implements maxPriorityQueue{
    
    int extractgrossMovements = 0;
    int extractgrossComp = 0;
    int maxGrossMovements = 0;
    int maxGrossComp = 0;
    int insertgrossMovements = 0;
    int insertGrossComparisons = 0;
    int[] sortedPriorityQueue;
    int rightIndex;


    public int getExtractgrossComp() {
        return this.extractgrossComp;
    }

    public int getExtractgrossMovements() {
        return this.extractgrossMovements;
    }

    public int getmaxGrossMovements() {
        return this.maxGrossMovements;
    }

    public int getmaxGrossComp() {
        return this.maxGrossComp;
    }

    public int getinsertgrossMovements() {
        return this.insertgrossMovements;
    }

    public int getinsertGrossComparisons() {
        return this.insertGrossComparisons; 
    }

    public sortedPriorityQueue(int[] A) {
        this.sortedPriorityQueue = mergesort(A, 0, A.length - 1);
        this.rightIndex = A.length;
        this.insertGrossComparisons = 0;
        this.insertgrossMovements = 0;
    }

    public int maximum() {
        return this.sortedPriorityQueue[(this.rightIndex - 1)];
    }

    public int extractMax() {
        this.rightIndex -= 1;
        return this.sortedPriorityQueue[this.rightIndex];
    }

    public void increaseKey(int i, int k) {
        if (this.sortedPriorityQueue[i] > k) {
            //System.out.println("Error: new value must be larger than previous");
            return;
        }

        if (i >= this.rightIndex) {
            System.out.println("Index out of bounds");
            return;
        }

        this.sortedPriorityQueue[i] = k;
        this.sortedPriorityQueue = mergesort(this.sortedPriorityQueue, 0, this.rightIndex - 1);
    }

    public void insert(int i) {
        if (this.rightIndex >= this.sortedPriorityQueue.length){
            int[] temp = new int[sortedPriorityQueue.length + 10];
            for (int ii = 0; ii < this.rightIndex; ii++) {
                temp[ii] = sortedPriorityQueue[ii];
            }
            this.sortedPriorityQueue = temp; 
        }
        this.sortedPriorityQueue[this.rightIndex] = i;
        this.rightIndex += 1;
        this.sortedPriorityQueue = mergesort(this.sortedPriorityQueue, 0, this.rightIndex - 1);
        
    }

    @Override
    public String toString() {
        String result = "";
        for (int ii = 0; ii < this.rightIndex; ii++) {
            result += this.sortedPriorityQueue[ii] + ",";
        }
        return result; 
    }

      // Merges two subarrays of arr[]. 
        // First subarray is arr[l..m] 
        // Second subarray is arr[m+1..r] 
        void merge(int arr[], int l, int m, int r) 
        { 
            // Find sizes of two subarrays to be merged 
            int n1 = m - l + 1; 
            int n2 = r - m; 
      
            // Create temp arrays 
            int L[] = new int[n1]; 
            int R[] = new int[n2]; 
            
            this.insertgrossMovements += 2;
            // Copy data to temp arrays 
            for (int i = 0; i < n1; ++i) 
                L[i] = arr[l + i]; 
            for (int j = 0; j < n2; ++j) 
                R[j] = arr[m + 1 + j]; 
      
            // Merge the temp arrays 
            // Initial indexes of first and second subarrays 
            int i = 0, j = 0; 
      
            // Initial index of merged subarray array 
            int k = l; 

            this.insertGrossComparisons += 1;
            while (i < n1 && j < n2) {
                this.insertGrossComparisons += 1;
                this.insertgrossMovements += 1;
                if (L[i] <= R[j]) { 
                    arr[k] = L[i]; 
                    i++; 
                } 
                else { 
                    arr[k] = R[j]; 
                    j++; 
                } 
                k++; 
            } 
      
            // Copy remaining elements of L[] if any 
            while (i < n1) { 
                this.insertgrossMovements += 1;
                arr[k] = L[i]; 
                i++; 
                k++; 
            } 
      
            // Copy remaining elements of R[] if any 
            while (j < n2) { 
                arr[k] = R[j]; 
                j++; 
                k++; 
            } 
        } 
      
        // Main function that sorts arr[l..r] using 
        // merge() 
        int[] mergesort(int arr[], int l, int r) 
        { 
            this.insertGrossComparisons += 1;
            if (l < r) { 
                // Find the middle point 
                int m = (l + r) / 2; 
      
                // Sort first and second halves 
                mergesort(arr, l, m); 
                mergesort(arr, m + 1, r); 
      
                // Merge the sorted halves 
                merge(arr, l, m, r); 
            } 
            return arr;
        } 
      
        
}

