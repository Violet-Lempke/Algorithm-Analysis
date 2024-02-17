public record Contact (String first, String last, String telephone) implements Comparable <Contact> {
    
    public Contact (String first, String last, String telephone) {
        this.first = first;
        this.last = last;
        this.telephone = telephone;
    }

    public String toString() {
        return last + ", " + first + "\t" + telephone;
    }

    @Override
    public int compareTo(Contact Contact2) {
        int result;

        if (this.last.equals(Contact2.last)) {
            result = this.first.compareTo(Contact2.first);
        }
        else {
            result = this.last.compareTo(Contact2.last); 
            }
        
        return result;
    }
}
