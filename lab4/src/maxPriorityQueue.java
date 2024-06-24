public interface maxPriorityQueue {

    //The example uses the term comparable rather than int, however despite 
    //being comparable int does not implement the comparable interface meaning 
    //will not fit this requirement. For the sake of simplicity I will thus replace 
    //comparable with int with the understanding it will yield the same result. 
    public void insert(int x);

    public int maximum();

    public int extractMax();

    public void increaseKey(int i, int k);

}