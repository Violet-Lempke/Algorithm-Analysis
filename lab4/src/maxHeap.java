public class maxHeap implements maxPriorityQueue{

    int extractgrossMovements = 0;
    int extractgrossComp = 0;
    int maxGrossMovements = 0;
    int maxGrossComp = 0;
    int insertgrossMovements = 0;
    int insertGrossComparisons = 0;
    int[] heap;
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

    public maxHeap(int[] A) {
        this.heap = A;
        this.rightIndex = this.heap.length;
        heapSort();
        this.rightIndex = A.length;

        this.insertGrossComparisons = 0;
        this.insertgrossMovements = 0;

    }

    private void heapSort() {
        //int jj = 0;
        //int[] newHeap = new int[this.heap.length];
        int placeHolder = this.rightIndex;
        this.buildMaxHeap();
        int num = this.rightIndex - 1;
        for (int ii = num; ii >= 1; ii--) {
            this.insertgrossMovements += 1;
            int temp = this.heap[0];
            //newHeap[jj] = temp;
            //jj++;
            this.heap[0] = this.heap[ii];
            this.heap[ii] = temp; 
            this.rightIndex -= 1;
            maxHeapify(0);
        }
        this.rightIndex = placeHolder;
        
    }
    private void maxHeapify(int i) {
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        int largest = i;
        this.insertGrossComparisons += 1;
        if (l < this.rightIndex) {
            if (this.heap[l] > this.heap[i]) {
                largest = l;
            }
        }

        this.insertGrossComparisons += 1;
        if (r < this.rightIndex) {
            if (this.heap[r] > this.heap[largest]) {
                largest = r;
            }
        }

        this.insertGrossComparisons += 1;
        if (largest != i) {
            int temp = this.heap[i];
            this.heap[i] = this.heap[largest];
            this.heap[largest] = temp; 
            maxHeapify(largest);
        }
    }

    private void buildMaxHeap() {
        for (int ii = (this.rightIndex / 2) + 1; ii >= 0; ii--) {
            maxHeapify(ii);
        }
    }

    public int maximum() {
        return this.heap[rightIndex - 1];
    }

    public int extractMax() {
        this.rightIndex -= 1;
        return this.heap[rightIndex];
    }

    public void increaseKey(int i, int k) {

        this.insertGrossComparisons += 1;
        if ( k < this.heap[i]) {
            //System.out.println("Error: new value must be larger than previous");
        }

        this.insertGrossComparisons += 1;
        if (i >= this.rightIndex) {
            System.out.println("Index out of bounds");
            return;
        }
        
        this.heap[i] = k;
        heapSort();
    }


    public void insert(int i) {
        if (this.rightIndex >= this.heap.length) {
            int [] newArray = new int[this.heap.length + 10];
            for (int ii = 0; ii < this.rightIndex; ii++) {
                newArray[ii] = this.heap[ii];
                
            }
            this.heap = newArray;
        }

        this.heap[rightIndex] = i;
        rightIndex += 1;
        heapSort();
    }
    @Override
    public String toString() {
        String result = "";
        int lilGuy = 0;
        int lineTracker = 0;
        int guyLimit = 1;
        for (int ii = 0; ii < this.rightIndex; ii++) {
            result += (this.heap[ii] + ",");

            lilGuy += 1;
            if (lilGuy >= guyLimit) {
                lilGuy = 0;
                lineTracker += 1;
                guyLimit = 1;
                for (int jj = 0; jj < lineTracker; jj++) {
                    guyLimit *= 2;
                }
                result += "\n";
            }
            
            
        }
        return result; 
    }
}