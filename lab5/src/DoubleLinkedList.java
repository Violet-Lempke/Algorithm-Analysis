public class DoubleLinkedList {
    private DoubleNode head;
    private DoubleNode tail;
    public DoubleLinkedList() {
        head = null;
        tail = null;
    }

    public DoubleNode search(int key) {
        if ((head != null) && (tail != null)) {
            DoubleNode curNode = head;
            
            while (curNode.next != head) {
                if (curNode.info == key) {
                    return curNode;
                }
                curNode = curNode.next;
            }

            if (curNode.info == key) {
                return curNode;
            }
        System.out.println("Item not in list, head returned");
        return head;
        }

        if (head != null) {
            if (head.info == key) {
                
                return head;
            }
        }

        
        System.out.println("Error: list empty");
        return head;
        
            
        
    }

    public void addFirst(int key) {
        if (head == null) {
            head = new DoubleNode(key);
        }

        else if (tail == null) {
            tail = head;
            DoubleNode newHead = new DoubleNode(key);
            tail.prev = newHead;
            tail.next = newHead;
            head = newHead;
            newHead.next = tail;
            newHead.prev = tail; 

        }
        else {
            DoubleNode newHead = new DoubleNode(key);
            newHead.next = head;
            head = newHead;
            head.prev = tail; 
        }
    }

    public void addLast(int key) {
        

        if (head == null) {
            head = new DoubleNode(key);
            return;
        }

        if (tail == null) {
            tail = new DoubleNode(key);
            head.next = tail;
            tail.prev = head;
            tail.next = head;
            head.prev = tail;
        }
        else {
            DoubleNode newTail = new DoubleNode(key);
            tail.next = newTail;
            newTail.prev = tail;
            newTail.next = head;
            tail = newTail;
        }
    }

    public int delete(int key) {
        DoubleNode deadNode = search(key);
        deadNode = delete(deadNode);
        int x = deadNode.info;
        deadNode = null;
        return x;
        
    }

    private DoubleNode delete(DoubleNode node) {
        if (head.next == tail) {
            if (node == tail) {
                tail = null;
            }

            else {
                head = tail;
                tail = null;
            }
        }
        if (node == head) {
            DoubleNode next = node.next;
            next.prev = tail;
            head = next;
            tail.next = head;
            return node;
        }

        if (node == tail) {
            DoubleNode prev = node.prev;
            prev.next = head;
            tail = prev;
            return node;
        }

        
        DoubleNode prev = node.prev;
        DoubleNode next = node.next;
        prev.next = next;
        next.prev = prev;
        return node;
    }

    public String returnHead() {
        return String.valueOf(head.info);
    }
}
