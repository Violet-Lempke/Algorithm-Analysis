import java.util.LinkedList;
import java.util.Iterator;
import java.util.Scanner;


public class App {
    public static void main(String[] args) {

        courseStructure courses = new courseStructure();
        LinkedList<courseInfo> courseOrder = courses.topologicalSort();
        Iterator<courseInfo> iterator = courseOrder.iterator();
        int curStep = 0;
        String curLine = "";
        Scanner glados = new Scanner(System.in);
        System.out.print("How many CS/MA courses would you like to take per year?: ");
        int stepper = Integer.valueOf(glados.nextLine());
        glados.close();
        
        
        while (iterator.hasNext()) {
            curStep += 1;
            curLine += (iterator.next().getCourse().name());
            
            if (curStep % stepper == 0) {
                
                System.out.println("Year: " + (curStep / stepper));
                System.out.println(curLine + '\n');
                curLine = "";

            }

            else {

                curLine += ", ";

            }
        }

        if (curLine != "") {

            System.out.println("Year: " + ((curStep / stepper) + 1));
            System.out.println(curLine + '\n');
        }


    }
}
