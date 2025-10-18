public class CircularLinkedList<T extends Comparable>  {
    Node<T> head;

    public void insertToEnd(T val){
        Node<T> newNode=new Node<>(val);
        if (head==null){
            head=newNode;
            head.next=head;
        }else{
            Node<T> iterator=head;
            while(iterator.next!=head)
                iterator=iterator.next;
            iterator.next=newNode;
            newNode.next=head;
        }
    }
    public void insertToFront(T val){
        Node<T> newNode=new Node<>(val);
        if (head==null){
            head=newNode;
            head.next=head;
        }else{
            Node<T> iterator=head;
            while(iterator.next!=head)
                iterator=iterator.next;
            iterator.next=newNode;
            newNode.next=head;
            head=newNode;
        }
    }
    public void display() {
        if (head == null) {
            System.out.println("Circular Linked List is empty");
            return;
        }

        Node<T> current = head;

        do {
            System.out.print(current.value + " ");
            current = current.next;
        } while (current != head);

        System.out.println();
    }
    public void delete(T val) {
        if (head == null) {
            return;
        }

        if (head.value.equals(val)) {
            if (head.next == head) {
                head = null;
            } else {
                Node<T> last = head;
                while (last.next != head) {
                    last = last.next;
                }
                head = head.next;
                last.next = head;
            }
            return;
        }

        Node<T> current = head;
        Node<T> previous = null;

        do {
            if (current.value.equals(val)) {
                previous.next = current.next;
            }
            previous = current;
            current = current.next;
        } while (current != head);
    }
    public void sortedInsert(T val){
        Node<T> newNode=new Node<>(val);
        if(head==null) {
            head = newNode;
            newNode.next=head;
        }
        else if (val.compareTo(head.value)<=0){
            Node<T> last = head;
            while (last.next != head) {
                last = last.next;
            }
            newNode.next=head;
            head=newNode;
            last.next=head;
        }else{

            Node<T> iterator=head;
            while(iterator.next!=head && iterator.next.value.compareTo(val)==-1){
                iterator=iterator.next;
            }
            if(iterator.next==head){
                iterator.next=newNode;
                newNode.next=head;
            }
            else{
                newNode.next=iterator.next;
                iterator.next=newNode;
            }


        }
    }
    public void recursiveAddToEnd(T val) {
        head = recursiveAddToEnd(head, val, head);
    }

    private Node<T> recursiveAddToEnd(Node<T> tempHead, T val, Node<T> last) {
        if (tempHead == null) {
            Node<T> newNode=new Node<>(val);
            if (last == null) {
                newNode.next = newNode;
                return newNode;
            } else {
                last.next = newNode;
                newNode.next = head;
                return head;
            }
        } else {
            tempHead.next = recursiveAddToEnd(tempHead.next, val, last);
            return tempHead;
        }
    }
    public boolean recursiveSearch(Node<T> tempHead, T val) {
        return recursiveSearch(tempHead, val, tempHead);
    }

    private boolean recursiveSearch(Node<T> current, T val, Node<T> start) {
        if (current == null) {
            return false;
        }
        if (current.value.equals(val)) {
            return true;
        }
        if (current.next == start) {
            return false;
        }
        return recursiveSearch(current.next, val, start);
    }




    public static void main(String[] args) {
        CircularLinkedList<Integer> linkedList = new CircularLinkedList<>();
        linkedList.sortedInsert(5);
        linkedList.sortedInsert(6);
        linkedList.sortedInsert(7);
        linkedList.sortedInsert(9);
        linkedList.sortedInsert(10);
        linkedList.sortedInsert(6);
        linkedList.sortedInsert(4);
        linkedList.sortedInsert(8);
        linkedList.sortedInsert(6);
        linkedList.sortedInsert(12);
        linkedList.sortedInsert(11);
        linkedList.delete(6);



        linkedList.display();

    }


}
