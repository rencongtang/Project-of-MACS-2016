package hospital;


public class Stack {

    private Vector stack;
    public Stack(int capcaity){
        stack= new Vector(capcaity);
    }
    public void push(Comparable o){
        stack.add(o);
        //Push the element to the last position of Vector
    }
    public Comparable pop(){
        Comparable a = stack.getLast();
        stack.removeLast();
        return a;

    }
    public Comparable top(){
        return stack.getLast();

    }
    public int size(){
        return stack.size();


    }
    public boolean empty(){
        if(stack!=null){
            return false;
        }
        else{
            return true;
        }
    }
}
