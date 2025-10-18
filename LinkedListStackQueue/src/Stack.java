public class Stack {
    private int [] values;
    private int top;
    public Stack(int size){
        this.top=-1;
        this.values=new int[size];
    }
    public int size(){
        return values.length;
    }
    public int peek(){
        if (isEmpty())
            return -1;
        return this.values[this.top];
    }
    public int count(){
        return this.top+1;
    }
    public boolean isEmpty(){
        //if(this.top==-1)
        //   return true;
        //else return false;
        return this.top==-1;
    }
    public boolean isFull(){
        return this.top==values.length-1;
    }
    public void push(int val){
        if(isFull()){
            System.out.println("stack is full");
        }else{
            this.top++;
            this.values[top]=val;
        }
    }
    public int pop(){
        if (isEmpty())
            return -1;
        this.top--;
        return values[this.top+1];
    }
    public void display() {
        if (isEmpty()) {
            System.out.println("stack is empty");
            return;
        }
        for (int i = this.top; i > -1; i--) {
            System.out.println(this.values[i]);
        }
    }
    public static boolean isEqual(Stack s1, Stack s2){
            if(s1.count()!=s2.count())
                return false;

            Stack tempStack1 = new Stack(s1.count());
            Stack tempStack2 = new Stack(s2.count());
            boolean result = true;

            while(!s1.isEmpty()){
                int val1 = s1.pop();
                int val2 = s2.pop();
                tempStack1.push(val1);
                tempStack2.push(val2);
                if(val1 != val2) {
                    result = false;
                    break;
                }
            }
            while(!tempStack1.isEmpty()){
                s1.push(tempStack1.pop());
                s2.push(tempStack2.pop());
            }
            return result;


    }
    public static boolean search(Stack Stk, int val){
        boolean found = false;
        Stack temp = new Stack(Stk.count());
        while(!(Stk.isEmpty())){
            int elm = Stk.pop();
            if(elm == val){
                found = true;
                break;
            }
            temp.push(elm);
        }
        while(!(temp.isEmpty())){
            Stk.push(temp.pop());
        }
        return found;
    }
    public static void remove(Stack Stk, int val){
        Stack temp = new Stack(Stk.count());
        while(!(Stk.isEmpty())){
            int elm = Stk.pop();
            if(elm != val)
                temp.push(elm);
        }
        while(!(temp.isEmpty())){
            Stk.push(temp.pop());
        }
    }



}
