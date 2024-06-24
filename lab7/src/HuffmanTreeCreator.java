
public class HuffmanTreeCreator {
    TreeMerger merger = new TreeMerger();
    public  BinaryTree HuffmanTree = new BinaryTree();
    public  HuffmanNode HuffmanTreeCreate(minHeap heap) {
    
    while (heap.size != 1) {
        HuffmanNode node1 = heap.extractMin();
        HuffmanNode node2 = heap.extractMin();
        heap.insert(merger.merger(node1, node2));
    }

    return heap.extractMin();
        

        
        
    }
}
