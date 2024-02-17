public class driver {
    public static void main(String[] args) {
    
        Contact[] friends = new Contact[7];
        friends[0] = new Contact ("John", "Smith", "610-555-7384");
        friends[1] = new Contact ("Sarah", "Barnes", "215-555-3827");
        friends[2] = new Contact ("Mark", "Riley", "733-555-2969");
        friends[3] = new Contact ("Laura", "Getz", "663-555-3984");
        friends[4] = new Contact ("Larry", "Smith", "464-555-3489");
        friends[5] = new Contact ("Frank", "Phelps", "322-555-2284");
        friends[6] = new Contact ("Marsha", "Grant", "243-555-2837");
        //Let’s try insertion sort first...
        InsertionSort sorter = new InsertionSort();
        //SelectionSort sorter = new SelectionSort();
        //MergeSort sorter = new MergeSort();
        //BubbleSort sorter = new BubbleSort();
        sorter.sort(friends);
        for (int index = 0; index < friends.length; index++)
        System.out.println (friends[index]);
    }
}

    



