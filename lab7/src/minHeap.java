class minHeap {
 
    
    private HuffmanNode[] Heap;
    public int size;
    private int maxsize;
 
    // Initializing front as static with unity
    private static final int FRONT = 1;
 
    // Constructor of this class
    public minHeap(int maxsize)
    {
 
        // This keyword refers to current object itself
        this.maxsize = maxsize;
        this.size = 0;
 
        Heap = new HuffmanNode[this.maxsize + 1];
        
    }
 
    
    private int parent(int pos) { return pos / 2; }
 
    
    private int leftChild(int pos) { return (2 * pos); }
 
    
    private int rightChild(int pos)
    {
        return (2 * pos) + 1;
    }
 
    
    private boolean isLeaf(int pos)
    {
 
        if (pos > (size / 2)) {
            return true;
        }
 
        return false;
    }
 

    private void swap(int fpos, int spos)
    {
 
        HuffmanNode tmp;
        tmp = Heap[fpos];
 
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }
 
    
   private void minHeapify(int pos)
   {      
     if(!isLeaf(pos)){
       int swapPos= pos;
       if(rightChild(pos)<=size)
          swapPos = Heap[leftChild(pos)].frequency <Heap[rightChild(pos)].frequency ?leftChild(pos):rightChild(pos);
       else
         swapPos= leftChild(pos);
        
       if(Heap[pos].frequency>Heap[leftChild(pos)].frequency || Heap[pos].frequency > Heap[rightChild(pos)].frequency){
         swap(pos,swapPos);
         minHeapify(swapPos);
       }
        
     }       
   }
 
    
    public void insert(HuffmanNode node)
    {
 
        if (size >= maxsize) {
            return;
        }
 
        Heap[++size] = node;
        int current = size;
 
        while (Heap[parent(current)] != null && Heap[current].frequency < Heap[parent(current)].frequency) {
            swap(current, parent(current));
            current = parent(current);
        }
    }
 
    
 
    // Method 9
    // To remove and return the minimum
    // element from the heap
    public HuffmanNode extractMin()
    {
 
        HuffmanNode min = Heap[FRONT];
        Heap[FRONT] = Heap[size--];
        minHeapify(FRONT);
 
        return min;
    }
}