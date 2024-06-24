import java.util.LinkedList;
public class courseInfo {
    
    public int color = 0;
    public courseInfo pi = null;
    public int time = -1;
    public int finished = -1;

    private course course;
    private LinkedList <courseInfo> prereqList;
    courseInfo(course course,LinkedList <courseInfo> preReqs ) {
        this.course = course;
        this.prereqList = preReqs;
    }

    public course getCourse() {
        return this.course;
    }

    public LinkedList <courseInfo> getPreReqs() {
        return this.prereqList;
    }
}
