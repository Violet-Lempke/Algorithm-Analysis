
import java.io.File;
import java.io.FileWriter;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.awt.Desktop;



public class App {

    static ArrayList<CharFreq> fTable = new ArrayList<CharFreq>();
    public static void main(String[] args) throws Exception {

        System.out.println("What would you like to do?");
        System.out.println("1) Run visual demonstration of Huffman Algorithm (Recommended Experience)");
        System.out.println("2) Encode file (Encoded File and Decoder will be created in local directory)");
        System.out.println("3) Decode File (Requires possesion of Encoded file and decoder created by running step 2)");
        System.out.print("\nEnter the Number of your choice: ");
        Scanner glados = new Scanner(System.in);
        int choice = glados.nextInt();
        glados.close();
        System.out.println("If you can't see the popup window please try moving vsStudio into WindowedMode I.E. making it smaller,\nthe file selector may be hidden by the VSCode window");
        System.out.println("this program is best run in windowed mode so please avoid re-maximizing the window,\nafter all programs are usually compiled not run from the IDE ;)");
        if (choice != 3) {
            
            File filePath = FileViaExplorer("Select File to operate on: ");
            fTree testTree = fTreefromFile(filePath);
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            int curCharacter = bufferedReader.read();
            StringBuilder OGFileBuilder = new StringBuilder();
            StringBuilder OGBinaryBuilder = new StringBuilder();

            int stepCount = 1;
            while (curCharacter != -1) {

                OGFileBuilder.append((char) curCharacter);
                OGBinaryBuilder.append(Integer.toBinaryString(curCharacter));
                if (stepCount % 8 == 0) {
                    OGBinaryBuilder.append('\n');
                }
                curCharacter = bufferedReader.read();
                stepCount++;

            }

            String OGFileString = OGFileBuilder.toString();
            String OGBinary = OGBinaryBuilder.toString();

            //System.out.println('\n' + OGFileString);
            inOrder(testTree.root);
            HuffmanNode[] arraySetup = new HuffmanNode[fTable.size()];
            int curStep = 0;
            for (CharFreq freq : fTable) {
                arraySetup[curStep] = new HuffmanNode(freq);
                curStep++;
            }
            minHeap heap = new minHeap(fTable.size());
            for (CharFreq charFreq : fTable) {
                heap.insert(new HuffmanNode(charFreq));
            }

            //print("Frequency Table", testTree.root, false);
            ArrayList<HuffmanNode> fTableNode = new ArrayList<HuffmanNode>();
            for (CharFreq CharFreq : fTable) {

                fTableNode.add(new HuffmanNode(CharFreq));

            }
            quickSort(fTableNode, 0, fTable.size() - 1);
            StringBuilder fBookBuilder = new StringBuilder();
            for (int ii = 0; ii < fTable.size(); ii++) {

                fBookBuilder.append(fTable.get(ii).character + ": " + fTable.get(ii).freq + '\n');
            
            }
            
            String fBook = fBookBuilder.toString();

            
            HuffmanTreeCreator encoderCreator = new HuffmanTreeCreator();
            HuffmanNode HuffmanTree = (encoderCreator.HuffmanTreeCreate(heap));
            System.out.println("Encoder");
            print("Encoder", HuffmanTree, false);
        
            PrefixGetter makePrefix = new PrefixGetter();
            Decoder makeDecoder = new Decoder();

            HashMap<Character,String> PrefixBook = makePrefix.Prefixer(HuffmanTree);
            HashMap<String,Character> Decoder = makeDecoder.Prefixer(HuffmanTree); 
            Set<Character> keySet = PrefixBook.keySet();
            StringBuilder BookBuilder = new StringBuilder();
        
        
            for (Character key : keySet) {

                if ((key != '\n' && key != '\t') && (key != '\r')) {
                    BookBuilder.append(key + ":" + PrefixBook.get(key));
                    BookBuilder.append('\n');
                }

                else {

                    switch(key) {

                        case '\n':
                            BookBuilder.append("NL" + ":" + PrefixBook.get(key));
                            BookBuilder.append('\n');
                            break;
                        
                        case '\t':
                            BookBuilder.append("tab" + ":" + PrefixBook.get(key));
                            BookBuilder.append('\n');
                            break;

                        case '\r':
                            BookBuilder.append("carraige" + ":" + PrefixBook.get(key));
                            BookBuilder.append('\n');
                            break;
                    }
                }

            }

            String Book = BookBuilder.toString();
            fileReader = new FileReader(filePath);
            bufferedReader = new BufferedReader(fileReader);

            curCharacter = bufferedReader.read();

            stepCount = 1;
            StringBuilder EncodedBuilder = new StringBuilder();
            while (curCharacter != -1) {

                EncodedBuilder.append(PrefixBook.get((char) curCharacter));
                curCharacter = bufferedReader.read();
                if (stepCount % 8 == 0) {

                    EncodedBuilder.append('\n');
                }
                stepCount++;

            }
            //System.out.println("\nCode Book: \n");
            //System.out.println(Book);
            //for (key key : PrefixBook)

            String EncodedText = EncodedBuilder.toString();

            //This portion decodes the Encoded Text using the key provided by our Hashmap

            StringBuilder worker = new StringBuilder();
            StringBuilder decodedBuilder = new StringBuilder();

            for (int ii = 0; ii < EncodedText.length(); ii++) {
                if (EncodedText.charAt(ii) != '\n') {
                    worker.append(EncodedText.charAt(ii));
                }

                if (Decoder.containsKey(worker.toString())) {
                    decodedBuilder.append(Decoder.get(worker.toString()));
                    worker = new StringBuilder();
                }
            }
            bufferedReader.close();
            String decodedText = decodedBuilder.toString();

            switch(choice) {

                case 1:

                    GUI GUI = new GUI();
                    GUI.createAndShowGUI(OGFileString, fBook, OGBinary, Book, EncodedText, decodedText);
                    break;
                
                case 2:

                    try {
                        File myObj = new File("Encoded" + filePath.getName());
                        myObj.createNewFile();
                        
                        } 
                     catch (IOException e) {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                    }

                    try {
                        FileWriter myWriter = new FileWriter("Encoded" + filePath.getName());
                        myWriter.write(EncodedText);
                        myWriter.close();
                      } catch (IOException e) {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                      }

                      try {
                        File myObj = new File("key" + filePath.getName());
                        myObj.createNewFile();
                        
                        } 
                     catch (IOException e) {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                    }

                    try {
                        FileWriter myWriter = new FileWriter("key" + filePath.getName());
                        myWriter.write(Book);
                        myWriter.close();
                      } catch (IOException e) {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                      }
                  

              
            
            }
            
            
        
            //System.exit(0);
        }

        else {
            System.out.println("Please select the file you wish to decode: ");
            File EncodedFile = FileViaExplorer("Select File to Decode: ");
            System.out.println("Please select its key: ");
            File key = FileViaExplorer("Select key to decode by: ");
            HashMap<String,Character> PrefixBook = new HashMap<String,Character>();
            FileReader fileReader = new FileReader(key);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            int curChar = bufferedReader.read();

            while (curChar != -1) {
                
                if((curChar == '\r' || curChar == '\t') || curChar == '\n') {
                    curChar = bufferedReader.read();
                }
                int nextChar = bufferedReader.read();
                if ((char) nextChar == ':') {
                    
                    int character = curChar;
                    curChar = bufferedReader.read();
                    StringBuilder keyBuilder = new StringBuilder();
                    while (curChar != '\n') {

                        keyBuilder.append((char)curChar);
                        curChar = bufferedReader.read();
                    }
                    String newkey = keyBuilder.toString();
                    PrefixBook.put(newkey, (char)character);
                }

                else {
                    //System.out.println(curChar);
                    switch ((char)curChar) {

                        case ('t'):
                            while (curChar != ':') {
                                curChar = bufferedReader.read();
                            }

                            curChar = bufferedReader.read();
                            StringBuilder keyBuilder = new StringBuilder();
                            while (curChar != '\n') {

                                keyBuilder.append((char)curChar);
                                curChar = bufferedReader.read();
                            }
                            String newkey = keyBuilder.toString();
                            PrefixBook.put(newkey, '\t');
                            break;

                        case ('N'):
                            while (curChar != ':') {
                                curChar = bufferedReader.read();
                            }

                            curChar = bufferedReader.read();
                            StringBuilder keyBuilder2 = new StringBuilder();
                            while (curChar != '\n') {

                                keyBuilder2.append((char)curChar);
                                curChar = bufferedReader.read();
                            }
                            String newkey1 = keyBuilder2.toString();
                            PrefixBook.put(newkey1, '\n');
                            break;

                        case ('c'):
                            while (curChar != ':') {
                                curChar = bufferedReader.read();
                            }

                            curChar = bufferedReader.read();
                            StringBuilder keyBuilder3 = new StringBuilder();
                            while (curChar != '\n') {

                                keyBuilder3.append((char)curChar);
                                curChar = bufferedReader.read();
                            }
                            String newkey3 = keyBuilder3.toString();
                            PrefixBook.put(newkey3, '\r');
                            break;

                    }
                }
                
            }

            //System.out.println(PrefixBook.keySet().toString());
            //System.out.println("what");
            fileReader = new FileReader(EncodedFile);
            bufferedReader = new BufferedReader(fileReader);
            StringBuilder EncodedBuilder = new StringBuilder();
            int curCharacter = bufferedReader.read();
            
            while (curCharacter != -1) {

                EncodedBuilder.append((char) curCharacter);
                curCharacter = bufferedReader.read();

            }
            

            String EncodedText = EncodedBuilder.toString();
            
            StringBuilder worker = new StringBuilder();
            StringBuilder decodedBuilder = new StringBuilder();

            for (int ii = 0; ii < EncodedText.length(); ii++) {
                if (EncodedText.charAt(ii) != '\n') {
                    worker.append(EncodedText.charAt(ii));
                }

                if (PrefixBook.containsKey(worker.toString())) {
                    decodedBuilder.append(PrefixBook.get(worker.toString()));
                    worker = new StringBuilder();
                }
            }
            bufferedReader.close();
            String decodedText = decodedBuilder.toString();
            File myObj = null;
            try {
                myObj = new File("Decoded" + EncodedFile.getName());
                myObj.createNewFile();
                
                } 
             catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }

            try {
                FileWriter myWriter = new FileWriter("Decoded" + EncodedFile.getName());
                myWriter.write(decodedText);
                
                myWriter.close();
              } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
              }

              Desktop desktop = Desktop.getDesktop();
              desktop.open(myObj);
            System.out.println("The decoded file has been placed in the local directory");
            
            System.exit(0); 
        }
    }

    public static File FileViaExplorer(String Description) {
        
            
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter((Description), "java", "txt");
        fileChooser.setFileFilter(filter);
        fileChooser.setCurrentDirectory(new File("."));

        int result = fileChooser.showOpenDialog(null);
        System.out.println("Result: " + result);
            
        File selectedFile = new File(fileChooser.getSelectedFile().getAbsolutePath());
        System.out.println("Filepath: " + selectedFile);
        return selectedFile;
        
        
        

    }

    


    private static void inOrder(fTreeNode node) {

        
        if (node == null) {
            return;
        }
        
        inOrder(node.left);
        //System.out.println(node.key + ": " + node.frequency);
        CharFreq arrayToAdd = new CharFreq(node.key, node.frequency);
        fTable.add(arrayToAdd);
        

        
        
        inOrder(node.right);
        
        
    }

    private static fTree fTreefromFile(File filePath) {
        fTree result = new fTree();
        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            int curCharacter = bufferedReader.read();

            while(curCharacter != -1) {
                if (curCharacter == 10) {
                    result.insert(result.root, '\n');
                    curCharacter = bufferedReader.read();
                }
                
                else if(curCharacter == 9) {
                    result.insert(result.root, '\t');
                    curCharacter = bufferedReader.read();
                }
                
                else if (curCharacter == 13) {
                    result.insert(result.root, '\r');
                    curCharacter = bufferedReader.read();
                }

                else {
                    result.insert(result.root, ((char) curCharacter));
                    curCharacter = bufferedReader.read();
                }
            }
            bufferedReader.close();
        }

        catch(IOException e) {

            System.out.println(e);
        }
        
        return result; 
    }

    public static void print(String prefix, fTreeNode n, boolean isLeft) {
        if (n != null) {
            print(prefix + "     ", n.right, false);
            System.out.println (prefix + ("|-- ") + n.key);
            print(prefix + "     ", n.left, true);
        }
    }

    public static void print(String prefix, HuffmanNode n, boolean isLeft) {
        if (n != null) {
            print(prefix + "     ", n.right, false);
            if (n.isLeaf) {
                System.out.println (prefix + ("|-- ") + n.key + ": " + n.frequency);
            }
            else {
                System.out.println (prefix + ("|-- ") + n.frequency);
            }

            print(prefix + "     ", n.left, true);
        }
    }

    static void quickSort(ArrayList<HuffmanNode> arr, int low, int high)
    {
        if (low < high) {

            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(arr, low, high);

            // Separately sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    static int partition(ArrayList<HuffmanNode> arr, int low, int high)
    {
        // Choosing the pivot
        int pivot = arr.get(high).frequency;

        // Index of smaller element and indicates
        // the right position of pivot found so far
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {

            // If current element is smaller than the pivot
            if (arr.get(j).frequency < pivot) {

                // Increment index of smaller element
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    static void swap(ArrayList<HuffmanNode> arr, int i, int j)
    {
        HuffmanNode temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }
}

