public class LinkedList<T extends Comparable> {
    private Node<T> head;
    private int memoryAccessCount;

    public Node<T> createNode(T val){
        return new Node<T>(val);
    }
    public void insertToFront(T val){
        Node<T> newNode=createNode(val);
        newNode.next=head;
        head=newNode;
        memoryAccessCount++;
    }
    public void insertToEnd(T val){
        Node<T> newNode=createNode(val);
        if(head==null){
            head=newNode;
            memoryAccessCount++;
            return;
        }
        Node<T> iterator=head;
        while(iterator.next!=null) {
            iterator = iterator.next;
            memoryAccessCount++;
        }
        iterator.next=newNode;
        memoryAccessCount++;

    }
    public void display(){
        Node<T> iterator=head;
        while(iterator!=null){
            System.out.print(iterator + " ");
            iterator=iterator.next;
        }
        System.out.println();

    }
    public boolean search(T val) {
        Node<T> iterator = head;
        while (iterator != null) {
            memoryAccessCount++;
            if (iterator.value.equals(val)) {
                return true;
            }
            iterator = iterator.next;
        }
        return false;

    }
    public int count() {
        int count = 0;
        Node<T> iterator = head;
        while (iterator != null) {
            count++;
            iterator = iterator.next;
        }
        return count;
    }
    public T findMin() {
        if (head == null) {
            return null;
        }

        Node<T> iterator = head;
        T min = head.value;

        while (iterator != null) {
            if (iterator.value.compareTo(min) < 0) {
                min = iterator.value;
            }
            iterator = iterator.next;
        }

        return min;
    }
    public void sortedInsert(T val){
        Node<T> newNode=createNode(val);
        if(head==null)
            head=newNode;
        else if (val.compareTo(head.value)<=0){
            newNode.next=head;
            head=newNode;
        }else{
            Node<T> iterator=head;
            while(iterator.next!=null && iterator.next.value.compareTo(val)==-1){
                iterator=iterator.next;
            }
            newNode.next=iterator.next;
            iterator.next=newNode;
        }
    }
    public void deleteTheFirst(){
        if(head!=null)
            head=head.next;
    }
    public void delete(T val){
        if(head==null)
            return;
        if(head.value.compareTo(val)==0)
            head=head.next;
        else{
            Node<T> previous=head, iterator=head;
            while(iterator!=null && iterator.value.compareTo(val)!=0)   {
                previous=iterator;
                iterator=iterator.next;
            }
            if(iterator!=null)
                previous.next=iterator.next;

        }
    }
    public void deleteAll(T val){
        if(head==null)
            return;
        if(head.value.compareTo(val)==0)
            head=head.next;
        else{
            Node<T> previous=head, iterator=head;
            while (iterator != null) {
                if (iterator.value.equals(val)) {
                    previous.next = iterator.next;
                }
                previous = iterator;
                iterator = iterator.next;
            }

        }

    }
    public void recursiveAddToEnd(T val){
        head=recursiveAddToEnd(head, val);
    }
    public Node<T> recursiveAddToEnd(Node<T> tempHead, T val)
    {
        if(tempHead==null)
            return createNode(val);
        else{
            tempHead.next=recursiveAddToEnd(tempHead.next, val);
        }
        return tempHead;
    }
    public boolean recursiveSearch(Node<T> tempHead, T val) {

        if (tempHead == null) {
            return false;
        }
        if (tempHead.value.equals(val)) {
            return true;
        }
        return recursiveSearch(tempHead.next, val);
    }
    public void bubbleSort() {
        if (head == null) {
            return;
        }

        boolean swapped;
        Node<T> current;
        Node<T> last = null;

        do {
            swapped = false;
            current = head;

            while (current.next != last) {
                if (current.value.compareTo(current.next.value) > 0) {
                    T temp = current.value;
                    current.value = current.next.value;
                    current.next.value = temp;
                    swapped = true;
                }
                current = current.next;
            }
            last = current;
        } while (swapped);
    }
    public void swapFirstAndLastNodes() {
        if (head == null || head.next == null) {
            return;
        }

        Node<T> last = head;
        Node<T> previousToLast = null;
        while (last.next != null) {
            previousToLast = last;
            last = last.next;
        }

        last.next = head.next;
        head.next = null;
        previousToLast.next = head;
        head = last;
    }

    public int getMemoryAccessCount() {
        return memoryAccessCount;
    }
    public void moveToBeginning(T val) {
        Node<T> iterator = head;
        Node<T> prev = null;

        while (iterator != null) {
            memoryAccessCount++;
            if (iterator.value.equals(val)) {
                if (prev != null) {
                    prev.next = iterator.next;
                    iterator.next = head;
                    head = iterator;
                }
                return;
            }
            prev = iterator;
            iterator = iterator.next;
        }

    }

}
