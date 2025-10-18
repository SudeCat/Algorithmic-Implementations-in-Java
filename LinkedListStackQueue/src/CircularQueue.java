public class CircularQueue <T>{
    int rear,front;
    T[] items;

    public CircularQueue(Class<T> dataType, int size){
        this.rear=this.front=0;
        items=(T[])java.lang.reflect.Array.newInstance(dataType, size+1);
    }
    public boolean isEmpty(){
        return rear == front;
    }
    public int size(){
        return items.length;
    }
    public boolean isFull()
    {
        return (rear + 1) % size() == front;
    }
    public void enQueue(T val) throws Exception{
        if(isFull()){
            throw new Exception("Queue is full)");
        }
        else{
            this.rear=(this.rear+1)%size();
            this.items[this.rear]=val;
        }
    }
    public T deQueue () throws  Exception{
        if(isEmpty()){
            throw new Exception("Queue is Empty");
        }
        else{
            this.front=(this.front+1)%size();
            return this.items[this.front];
        }
    }
    public void display(){
        int i=(front+1)%size();
        while(i!=(rear+1)%size()){
            System.out.println(items[i]);
            i=(i+1)%size();
        }
    }

    public static void main(String[] args) throws Exception {
        try {
            CircularQueue<Integer> queue = new CircularQueue<>(Integer.class, 5);

            // Kuyruğa öğeler ekleyelim
            queue.enQueue(1);
            queue.enQueue(2);
            queue.enQueue(3);

            // Kuyruktan öğeleri çıkaralım
            System.out.println("front item: " +queue.items[queue.front]+ queue.front);
            System.out.println("rear item: " +queue.items[queue.rear]);
            System.out.println("Dequeued item: " + queue.deQueue());
            System.out.println("Dequeued item: " + queue.deQueue());

            // Yeni öğeler ekleyelim
            queue.enQueue(4);
            queue.enQueue(5);

            // Kuyruğu ekrana yazdıralım
            queue.display();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
