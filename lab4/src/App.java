import java.util.Random;

public class App {
    
    public static void main(String[] args) {

        int[] nvalues = new int[] {10, 50, 100, 200, 500, 1000, 2000, 5000};
       int[] counters = new int[] {0, 0 , 0 , 0 , 0 , 0};
       for (int mouse = 0; mouse < nvalues.length; mouse++) {
       int n = nvalues[mouse];
       for (int jj = 0; jj < 5000; jj++) {
           Random generator = new Random();
           int[] numbers = new int[n];
           for (int ii = 0; ii < n; ii++) {
               numbers[ii] = generator.nextInt(10);
           }

           //maxHeap queue = new maxHeap(numbers);
           sortedPriorityQueue queue = new sortedPriorityQueue(numbers);
           //unsortedPriorityQueue queue = new unsortedPriorityQueue(numbers);
           
           int random1 = generator.nextInt(n - 1);
           int random2 = generator.nextInt(10);
           if (random1 > random2) {
            int temp = random2;
            random2 = random1;
            random1 = temp;
           }

           if (random1 == random2) {
            random2++;
           }
           queue.increaseKey(random1, random2);
           counters[4] += queue.getinsertgrossMovements();
           counters[5] += queue.getinsertGrossComparisons();
           queue.maximum();
           queue.extractMax();
           counters[0] += queue.getmaxGrossComp();
           counters[1] += queue.getmaxGrossMovements();
           counters[2] += queue.getExtractgrossComp();
           counters[3] += queue.getExtractgrossMovements();


        }
        String result = "";
        result += "n: " + n + " ";
        result += "increaseKeyMov: " + counters[4] + " ";
        result += "increaseKeyCom: " + counters[5] + " ";
        result += "maxComp: " + counters[0] + " ";
        result += "maxMove: " + counters[1] + " ";
        result += "extractComp: " + counters[2] + " ";
        result += "extractMove: " + counters[3] + " ";
        System.out.println(result);
    }
    System.out.println("Sorted");
    //System.out.println("Unsorted");
    //System.out.println("heap");
    System.exit(0);
    }
}
