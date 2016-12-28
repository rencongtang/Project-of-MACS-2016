package hospital;

public class Queue {
    private Vector Queue;
    public Queue(){
        Queue = new Vector(100);
    }

    public void push(Comparable o){
        Queue.add(o);
    }
    public Comparable pop(){
        Comparable a = Queue.getFirst();
        Queue.removeFirst();
        return a;
    }
    public Comparable top(){
        return Queue.getLast();
    }

    public int size(){
        return Queue.size();
    }

    public boolean empty(){
        if(Queue.size() != 0){
            return false;
        }
        else {
            return true;
        }
    }
}