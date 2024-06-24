
/**
 * 
 * Returns the prefixes of each character of a huffman tree given the minHeap that the tree consists of in
 * the form of a hashmap. This is what the actually decoder consists of 
 */


import java.util.HashMap;
public class Decoder {

    StringBuilder prefix = new StringBuilder();
    
    HashMap<String, Character> PrefixCollection = new HashMap<>();
    public HashMap<String, Character> Prefixer(HuffmanNode root) {
        
        if (root == null) {

            return PrefixCollection;

        }

        if (root.isLeaf) {

            PrefixCollection.put(prefix.toString(), ((Character)root.key));

        }

        prefix.append('0');
        Prefixer(root.left);
        prefix.deleteCharAt(prefix.length() - 1);

        prefix.append('1');
        Prefixer(root.right);
        prefix.deleteCharAt(prefix.length() - 1);



        return PrefixCollection;
    }
    
}
