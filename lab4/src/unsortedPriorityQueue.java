public class unsortedPriorityQueue implements maxPriorityQueue {
    int extractgrossMovements = 0;
    int extractgrossComp = 0;
    int maxGrossMovements = 0;
    int maxGrossComp = 0;
    int insertgrossMovements = 0;
    int insertGrossComparisons = 0;
    int[] unsortedPriorityQueue;
    int length;
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
    public unsortedPriorityQueue (int[] AA) {
        this.unsortedPriorityQueue = new int[(AA.length + 10 )];
        this.length = unsortedPriorityQueue.length;
        this.rightIndex = (AA.length);
        for (int ii = 0; ii < AA.length; ii++) {
            unsortedPriorityQueue[ii] = AA[ii];
        }

    }
    
    public void insert(int x) {
        if (this.rightIndex != (this.length)) {
            this.unsortedPriorityQueue[(rightIndex)] = x;
            this.rightIndex += 1;
            return;
        }
        
        else {
            int[] temp = new int[this.length + 10];
            for (int ii = 0; ii < this.rightIndex; ii++) {
                temp[ii] = this.unsortedPriorityQueue[ii];
            }
            this.unsortedPriorityQueue = temp;
            this.unsortedPriorityQueue[rightIndex + 1] = x;
            this.rightIndex += 1;

        }
    }

    public int maximum() {
        int max = this.unsortedPriorityQueue[0];
        for (int ii = 1; ii < this.rightIndex; ii++) {
            this.maxGrossComp += 1;
            if (this.unsortedPriorityQueue[ii] > max) {
                max = this.unsortedPriorityQueue[ii];
            }
            
        }
        return max; 
    }

    public int extractMax() {
        int max = this.unsortedPriorityQueue[0];
        int index = 0;
        for (int ii = 1; ii < this.rightIndex; ii++) {
            this.extractgrossComp += 1;
            if (this.unsortedPriorityQueue[ii] > max) {
                max = this.unsortedPriorityQueue[ii];
                index = ii;
            }
        }
        for (int jj = index; jj < this.rightIndex - 1; jj++) {
            this.extractgrossMovements += 1;
            this.unsortedPriorityQueue[jj] = this.unsortedPriorityQueue[jj + 1];
        }
        this.rightIndex -= 1;
        return max;
    }

    public void increaseKey(int i, int k) {
        this.insertGrossComparisons += 1;
        if (k < this.unsortedPriorityQueue[i]) {
            //System.out.println("Error: new value must be greater than old");
            return;
        }

        if (i >= this.rightIndex) {
            System.out.println("Index out of bounds");
            return;
        }
        this.unsortedPriorityQueue[i] = k;

    }

    
    public String toString() {
        String result = "";
        for (int ii = 0; ii < this.rightIndex; ii++) {
            result += (this.unsortedPriorityQueue[ii] + ",  ");
        }
        return result; 
    }
}