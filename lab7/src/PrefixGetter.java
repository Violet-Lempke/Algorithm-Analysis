

/**
 * 
 * This is very similar to the Decoder class, however the data it returns is in the opposite order I.E. Char then
 * character.
 * 
 * */
import java.util.HashMap;
public class PrefixGetter {

    StringBuilder prefix = new StringBuilder();
    
    HashMap<Character, String> PrefixCollection = new HashMap<>();
    public HashMap<Character, String> Prefixer(HuffmanNode root) {
        
        if (root == null) {

            return PrefixCollection;

        }

        if (root.isLeaf) {

            PrefixCollection.put(((Character)root.key), prefix.toString());

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
