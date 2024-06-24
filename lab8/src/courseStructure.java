import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Iterator;


public class courseStructure {
    //This really should go in a "header" file of sorts but for times sake 
    //its going here.
    private course MA1800 = new course("MA", 1800);
    private course CS2010 = new course("CS", 2010);
    private course MA2130 = new course("MA", 2130);
    private course CS2370 = new course("CS", 2370);
    private course MA2300 = new course("MA", 2300);
    private course labSCI = new course("SCI", 1234);
    private course MA2550 = new course("MA", 2550);
    private course MA2450 = new course("MA", 2450);
    private course CS2381 = new course("CS", 2381);
    private course MA2560 = new course("MA", 2560);
    private course CS2470 = new course("CS", 2470);
    private course CS2220 = new course("CS", 2220);
    private course CS3221 = new course("CS", 3221);
    private course CS3600 = new course("CS", 3600);
    private course electives = new course("Elec", 1234);
    private course CS3720 = new course ("CS", 3720);
    private course CS3780 = new course("CS", 3780);
    private course CS4250 = new course("CS", 4250);
    private course CS4520 = new course("CS", 4520);
    private course CS4760 = new course("CS", 4760);
    private course CS4140 = new course("CS", 4140);
    private course CS4310 = new course("CS", 4310);

    ArrayList <courseInfo> courseGraph;

        int time = 0;
    
    
    courseStructure() {
        //Initializing our arraylist that will contains our linked lists
        
        courseGraph = new ArrayList<>();
        //We will now generate the linked list representation of each course and then 
        //add it to this array list

        LinkedList <courseInfo> ma1800preReqs = new LinkedList<>();
        
        courseInfo MA1800Info = new courseInfo(MA1800, ma1800preReqs);
        courseGraph.add(MA1800Info);

        LinkedList <courseInfo> cs2010preReqs = new LinkedList<>();
        courseInfo CS2010Info = new courseInfo(CS2010, cs2010preReqs);
        courseGraph.add(CS2010Info);

        LinkedList <courseInfo> MA2300preReqs = new LinkedList<>();
        courseInfo MA2300Info = new courseInfo(MA2300, MA2300preReqs);
        courseGraph.add(MA2300Info);


        LinkedList <courseInfo> labScipreReqs = new LinkedList<>();
        courseInfo labSCIInfo = new courseInfo(labSCI, labScipreReqs);
        courseGraph.add(labSCIInfo);

        LinkedList <courseInfo> electivespreReqs = new LinkedList<>();
        courseInfo electivesInfo = new courseInfo(electives, electivespreReqs);
        courseGraph.add(electivesInfo);

        LinkedList <courseInfo> MA2130preReqs = new LinkedList<>();
        
        courseInfo MA2130Info = new courseInfo(MA2130, MA2130preReqs);
        courseGraph.add(MA2130Info);

        LinkedList <courseInfo> CS2370preReqs = new LinkedList<>();
        
        courseInfo CS2370Info = new courseInfo(CS2370, CS2370preReqs);
        courseGraph.add(CS2370Info);

        LinkedList <courseInfo> MA2550preReqs = new LinkedList<>();
        
        courseInfo MA2550Info = new courseInfo(MA2550, MA2550preReqs);
        courseGraph.add(MA2550Info);

        LinkedList <courseInfo> MA2450preReqs = new LinkedList<>();
        
        courseInfo MA2450Info = new courseInfo(MA2450, MA2450preReqs);
        courseGraph.add(MA2450Info);

        LinkedList <courseInfo> CS2381preReqs = new LinkedList<>();
        
        courseInfo CS2381Info = new courseInfo(CS2381, CS2381preReqs);
        courseGraph.add(CS2381Info);

        LinkedList <courseInfo> MA2560preReqs = new LinkedList<>();
        
        courseInfo MA2560Info = new courseInfo(MA2560, MA2560preReqs);
        courseGraph.add(MA2560Info);

        LinkedList<courseInfo> CS3600preReqs = new LinkedList<>();
        
        courseInfo CS3600Info = new courseInfo(CS3600, CS3600preReqs);
        courseGraph.add(CS3600Info);

        LinkedList<courseInfo> CS2470preReqs = new LinkedList<>();
        
        courseInfo CS2470Info = new courseInfo(CS2470, CS2470preReqs);
        courseGraph.add(CS2470Info);

        LinkedList<courseInfo> CS2220preReqs = new LinkedList<>();
        
        courseInfo CS2220Info = new courseInfo(CS2220, CS2220preReqs);
        courseGraph.add(CS2220Info);

        LinkedList<courseInfo> CS3221preReqs = new LinkedList<>();
        
        courseInfo CS3221Info = new courseInfo(CS3221, CS3221preReqs);
        courseGraph.add(CS3221Info);

        LinkedList<courseInfo> CS3720preReqs = new LinkedList<>();
        
        courseInfo CS3720Info = new courseInfo(CS3720, CS3720preReqs);
        courseGraph.add(CS3720Info);

        LinkedList<courseInfo> CS3780preReqs = new LinkedList<>();
        
        courseInfo CS3780Info = new courseInfo(CS3780, CS3780preReqs);
        courseGraph.add(CS3780Info);

        LinkedList<courseInfo> CS4250preReqs = new LinkedList<>();
        
        courseInfo CS4250Info = new courseInfo(CS4250, CS4250preReqs);
        courseGraph.add(CS4250Info);

        LinkedList<courseInfo> CS4520preReqs = new LinkedList<>();
        courseInfo CS4520Info = new courseInfo(CS4520, CS4520preReqs);
        courseGraph.add(CS4520Info);

        LinkedList<courseInfo> CS4760preReqs = new LinkedList<>();
        
        courseInfo CS4760Info = new courseInfo(CS4760, CS4760preReqs);
        courseGraph.add(CS4760Info);

        LinkedList<courseInfo> CS4140preReqs = new LinkedList<>();
        
        courseInfo CS4140Info = new courseInfo(CS4140, CS4140preReqs);
        courseGraph.add(CS4140Info);

        LinkedList<courseInfo> CS4310preReqs = new LinkedList<>();
        
        courseInfo CS4310Info = new courseInfo(CS4310, CS4310preReqs);
        courseGraph.add(CS4310Info);

        ma1800preReqs.add(MA2130Info);
        ma1800preReqs.add(MA2450Info);

        
        cs2010preReqs.add(CS2370Info);

        MA2130preReqs.add(MA2550Info);

        CS2370preReqs.add(CS3600Info);
        CS2370preReqs.add(CS2381Info);
        CS2370preReqs.add(CS2470Info);
        CS2370preReqs.add(CS2220Info);

        MA2550preReqs.add(MA2560Info);

        MA2450preReqs.add(CS3221Info);
        MA2450preReqs.add(CS3600Info);

        CS2381preReqs.add(CS3221Info);
        CS2381preReqs.add(CS3720Info);
        CS2381preReqs.add(CS4250Info);

        CS3600preReqs.add(CS4760Info);
        CS3600preReqs.add(CS3720Info);

        CS2470preReqs.add(CS4760Info);

        CS2220preReqs.add(CS4760Info);
        CS2220preReqs.add(CS4250Info);

        CS3221preReqs.add(CS3780Info);

        CS3720preReqs.add(CS4760Info);
        CS3720preReqs.add(CS4140Info);

        CS3780preReqs.add(CS4760Info);

        CS4250preReqs.add(CS4310Info);



    }

    LinkedList<courseInfo> topologicalSort() {
    
    LinkedList<courseInfo> topo = new LinkedList<>();
    this.time = 0;
        for (int ii = 0; ii < this.courseGraph.size(); ii++) {

            if (courseGraph.get(ii).color == 0) {
                visit(courseGraph.get(ii), topo);
            } 
            
            

        }

        return topo;
    }

    void visit(courseInfo course, LinkedList<courseInfo> result) {

        this.time += 1;
        course.time = this.time;
        course.color = 1;
        Iterator<courseInfo> visitor = course.getPreReqs().iterator();
        while (visitor.hasNext()) {
            courseInfo curPre = visitor.next();
            if (curPre.color == 0) {
                curPre.pi = course;
                visit(curPre, result);
            }
        }

        course.color = 2;
        this.time += 1;
        course.finished = this.time;
        result.addFirst(course);

    }


}
