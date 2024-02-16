import java.util.ArrayList;
import java.util.Scanner;
public class Josephus {
    /**
     * Simulates the Josephus Problem, and gives solutions for
     * the questions given in the lab
     * @param args 
     * 
     * @return Outputs the information requested by the user
     * 
     * @Author Violet Lempke
     */
    public static void main (String args[])  {
        //This portion is a very basic user interface 
        //It outputs prompts and utilizes the user response to select which code to run
        Scanner ScanFriend = new Scanner (System.in);
        System.out.println ("1: Run Problem 1");
        System.out.println ("2: Run Problem 2");
        System.out.println ("3: Run Problem 3");
        System.out.println ("4: Custom Input");
        System.out.println("5: Quit");
        System.out.print ("Make your selection: ");
        var choice = ScanFriend.nextInt();
        
        if (choice == 1) {
            option1();
        }

        if (choice == 2) {
            option2();
        }

        if (choice == 3) {
            option3();
        }

        if (choice == 4) {
            option4();
        }

        if (choice == 5) {
            System.exit(0);
        }
        ScanFriend.close();
        System.exit(0);
    }
    /**
    *The actual logic for simulating the Josephus problem
    *The logic takes the requested specfications and returns the 
    *position that survived. 
    * @param n an integer representing the number of people in the circle
    * @param k an integer representing how many spots in the circle are skipped each turn
    * @param order a boolean that determines whether or not the order of removal is shown
    * @return an integer representing the surviving spot
    * @author Violet Lempke
    */
    private static int j (int n, int k, boolean order) {
        ArrayList<Integer> circle = new ArrayList<Integer>();
        for (int i = 1; i <= n; i ++) {
            circle.add(i);
        }
        var index = -1;
        if (!order) {
            while (circle.size() != 1) {
                index = (index + k) % circle.size();
                circle.remove(index);
                index -= 1;
            }
            return circle.get(0);
        }
        else {
            ArrayList<Integer> killOrder = new ArrayList<Integer>();
            while (circle.size() != 1) {
                index = (index + k) % circle.size();
                killOrder.add(circle.get(index));
                circle.remove(index);
                index -= 1;
        }
        System.out.println(killOrder);
        return circle.get(0);
    }
    }    
    /**
    *Runs Question 1 of the lab
    *
    * @author Violet Lempke
    */
    private static void option1() {
        System.out.println(j(40,2,true));
    }
    /**
    *Runs Question 2 of the lab
    *
    * @author Violet Lempke
    */
    private static void option2() {
        ArrayList<Integer> solutionList = new ArrayList<Integer>();
        for (int i = 2; i <= 100; i++) {
            solutionList.add(j(i,2,false));
        }
        System.out.println(solutionList);
    }
    /**
    * Runs question 3 of the lab
    *
    * @author Violet Lempke 
    */
    private static void option3() {
        System.out.println(j(3,10,false));
        System.out.println(j(3,50,false));
        System.out.println(j(3,100,false));
        System.out.println(j(4,10,false));
        System.out.println(j(4,50,false));
        System.out.println(j(4,100,false));
        System.out.println(j(12,10,false));
        System.out.println(j(12,50,false));
        System.out.println(j(12,100,false));
    }
    /** 
    * Allows for a custom number of people and spots skipped
    * as specified by the user. 
    *
    * @author Violet Lempke
    */
    private static void option4() {
        Scanner newGuy = new Scanner(System.in);
        System.out.print("Select the number of people in the circle:");
        var people = newGuy.nextInt();
        newGuy.nextLine();
        System.out.print("Select the skip rate:");
        var skipRate = newGuy.nextInt();
        newGuy.nextLine();
        System.out.print("Would you like to see the kill order? y/n ");
        String choice = newGuy.nextLine();
        
        if (choice.equals("y")) {
            System.out.println(j(people,skipRate,true));
        }
        else {
            System.out.println(j(people,skipRate,false));
        }
        
    }
}
