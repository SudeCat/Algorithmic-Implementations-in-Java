public class DoublyLinkedList <T extends Comparable>{
    DNode<T> head;
    public DNode<T> createNode(T val){
        return new DNode<T>(val);
    }
    public void insertToFront(T val){
        DNode<T> newNode=new DNode<>(val);
        if (head==null){
            head=newNode;
        }else{
            newNode.next=head;
            head.prev=newNode;
            head = newNode;
        }
    }
    public void insertToEnd(T val){
        DNode<T> newNode=createNode(val);
        if(head==null){
            head=newNode;
            return;
        }
        DNode<T> iterator=head;
        while(iterator.next!=null)
            iterator=iterator.next;
        iterator.next=newNode;
        newNode.prev=iterator;

    }
    public void delete(T val){
        if(head==null)
            return;
        else if(head.value.compareTo(val)==0){
            head=head.next;
            if(head!=null)
                head.prev=null;
        }
        else{
            DNode<T> iterator=head;
            while(iterator!=null && iterator.value.compareTo(val)!=0)
                iterator=iterator.next;

            if(iterator!=null && iterator.next!=null) {
                iterator.prev.next = iterator.next;
                iterator.next.prev = iterator.prev;
            }
            else if(iterator.next==null)
                iterator.prev.next = null;

        }
    }
    public void deleteAll(T val){
        if(head==null)
            return;
        else if(head.value.compareTo(val)==0){
            head=head.next;
            if(head!=null)
                head.prev=null;
        }
        else{
            DNode<T> iterator=head;
            while(iterator!=null){
                if( iterator.value.compareTo(val)==0 && iterator.next!=null){
                    iterator.prev.next = iterator.next;
                    iterator.next.prev = iterator.prev;
                }else if(iterator.value.compareTo(val)==0 && iterator.next==null)
                    iterator.prev.next = null;
                iterator=iterator.next;
            }
        }
    }
    public void sortedInsert(T val){
        DNode<T> newNode=createNode(val);
        if(head==null)
            head=newNode;
        else if (val.compareTo(head.value)<=0){
            newNode.next=head;
            head.prev=newNode;
            head=newNode;
        }else{
            DNode<T> iterator=head;
            while(iterator.next!=null && iterator.next.value.compareTo(val)==-1){
                iterator=iterator.next;
            }
            if(iterator.next!=null){
                newNode.next=iterator.next;
                iterator.next.prev = newNode;
                iterator.next=newNode;
                newNode.prev = iterator;
            }
            else{
                newNode.next = null;
                iterator.next=newNode;
                newNode.prev=iterator;
            }



        }
    }
    public void display() {
        if (head == null) {
            System.out.println("Doubly Linked List is empty");
            return;
        }
        DNode<T> current = head;
        do {
            System.out.print(current.value + " ");
            current = current.next;
        } while (current != null);

        System.out.println();
    }
    public void swapFirstAndLastNodes() {
        if (head == null || head.next == null) {
            return;
        }
        DNode<T> last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = head.next;
        head.next = null;
        last.prev.next = head;
        head = last;
    }

    public static void main(String[] args) {
        DoublyLinkedList<Integer> linkedList = new DoublyLinkedList<>();

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
        linkedList.deleteAll(7);
        linkedList.display();
        linkedList.swapFirstAndLastNodes();



        linkedList.display();
    }

}