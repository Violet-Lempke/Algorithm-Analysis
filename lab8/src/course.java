public class course {

    private String department;
    private int number;
    private String name;
    public course pi = null;

    course(String department, int number) {
        this.department = department;
        this.number = number;
        this.name = (department + number);
    }

    public String department() {
        return this.department;
    }

    public int number() {
        return this.number;
    }

    public String name() {
        return this.name;
    }

}
