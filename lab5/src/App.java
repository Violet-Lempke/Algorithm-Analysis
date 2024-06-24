import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class App {
    public static void main(String[] args) {
        case1();
        case2();
        case3();
    }

    public static void case1() {
        
        BufferedWriter bw1 = null;
   
        try {
            DoubleLinkedList group = new DoubleLinkedList();
            for (int ii = 1; ii <= 40; ii++) {
                group.addLast(ii);
            }


            
            File file = new File("./CircleLab/Outputs/test1.txt");

            FileWriter fw = new FileWriter(file);
            bw1 = new BufferedWriter(fw);
            

            DoubleNode curNode = group.search(1);
            String content = "Kill Order: ";
            for (int ii = 0; ii < 39; ii++) {
                content += ((String.valueOf(group.delete(curNode.next.info))) + ",");
                curNode = curNode.next;
            }

            content += "\n\nSurvivor: ";
            content += group.returnHead();
            bw1.write(content);
            
        }

        catch (IOException ioe) {
            ioe.printStackTrace();
        }

        finally {
            try {
                if (bw1 != null) {
                    bw1.close();
                }
            }
            catch(Exception ex) {
                System.out.println("Error in closing lildude");
            }
        }
    }

    public static void case2() {
        String ns = "n :|";
        String contentFinal = "";
        String survivors = "   |";

        for (int ii = 1; ii <= 100; ii++) {
            if (ii == 50) {
                contentFinal += (ns + '\n' + survivors);
                ns = "n :|";
                survivors = "   |";
            }
            DoubleLinkedList group = new DoubleLinkedList();
            for (int jj = 1; jj <= ii; jj++) {
                group.addLast(jj);
            }

            DoubleNode curNode = group.search(1);

            for (int jj = 0; jj < ii - 1; jj++) {
                group.delete(curNode.next.info);
                curNode = curNode.next;
            }
            ns += ii + "|";

            if (Integer.parseInt(group.returnHead()) < 10 && ii >= 10) {
                survivors += " " + group.returnHead() + "|";
            }

            else {
                survivors += group.returnHead() + "|";
            }
        } 
        contentFinal += "\n\n" + ns + '\n' + survivors;
        BufferedWriter bw2 = null;
        try {
            File file = new File("./CircleLab/Outputs/test2.txt");

            FileWriter fw = new FileWriter(file);
            bw2 = new BufferedWriter(fw);
            bw2.write(contentFinal);
        }

        catch (IOException ioe) {
            ioe.printStackTrace();
        }

        finally {
            try {
                if (bw2 != null) {
                    bw2.close();
                }
            }

            catch(Exception ex) {
                System.out.println("Error in closing the buffered writer");
            }
        }


    }

    public static void case3() {
        String content = "";
        for (int ii = 0; ii < 3; ii++) {
            for (int jj = 0; jj < 3; jj++) {
                switch(ii) {
                    case 0:
                        switch(jj) {
                            case 0: 
                                content += '\n' + "J(10, 3): ";
                                content += J(10,3);
                                break;

                            case 1:
                                content += '\n' + "J(10, 4): ";
                                content += J(10,4);
                                break;
                            
                            case 2:
                                content += "\n" + "J(10, 12): ";
                                content += J(10,12);
                                break;
                        }
                        break;


                    case 1: 
                        switch(jj) {
                            case 0:
                                content += '\n' + "J(50, 3): ";
                                content += J(50,3);
                                break;

                            case 1: 
                                content += '\n' + "J(50, 4): ";
                                content += J(50,4);
                                break;

                            case 2: 
                                content += '\n' + "J(50, 12): ";
                                content += J(50,12);
                                break;
                        }
                        
                        break;

                    case 2:
                        switch(jj) {
                            case 0 :
                                content += '\n' + "J(100, 3): ";
                                content += J(100,3);
                                break;

                            case 1:
                                content += '\n' + "J(100, 4): ";
                                content += J(100,4);
                                break;

                            case 2:
                                content += '\n' + "J(100, 12): ";
                                content += J(100,12);
                                break;

                        }

                        break;    
                    
                }
            }
        }
        BufferedWriter bw2 = null;
        try {
            File file = new File("./CircleLab/Outputs/test3.txt");

            FileWriter fw = new FileWriter(file);
            bw2 = new BufferedWriter(fw);
            bw2.write(content);
        }

        catch (IOException ioe) {
            ioe.printStackTrace();
        }

        finally {
            try {
                if (bw2 != null) {
                    bw2.close();
                }
            }

            catch(Exception ex) {
                System.out.println("Error in closing the buffered writer");
            }
        }

        
    }


    public static int J(int n, int k) {
        DoubleLinkedList group = new DoubleLinkedList();
        for (int ii = 1; ii <= n; ii++) {
            group.addLast(ii);
        }

        DoubleNode curNode = group.search(1);
        for (int ii = 1; ii < n; ii++) {
            for (int jj = 1; jj < k - 1; jj++) {
                curNode= curNode.next;
            }
            group.delete(curNode.next.info);
            curNode = curNode.next;
        }
        return Integer.parseInt(group.returnHead());
    }
    
}
