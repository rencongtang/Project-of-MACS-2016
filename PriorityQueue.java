package hospital;



public class PriorityQueue {
    public class PriorityPair implements Comparable{
        public Comparable element;
        public Comparable priority;
        public PriorityPair(Comparable element, Comparable priority){
            this.element = element;
            this.priority = priority;
        }
        public Comparable getElement(){
            return element;
        }
        public int compareTo(Comparable o){
            PriorityPair p2 = (PriorityPair)o;
            return ((Comparable)priority).compareTo(p2.priority);
        }

        @Override
        public int compareTo(Object o) {
            // TODO Auto-generated method stub
            return 0;
        }
        public Comparable getPriority(){
            return priority;
        }
    }

    private LinkedList data;
    private int count=0;
    public PriorityQueue(){
        data = new LinkedList();
    }

    public void push(Comparable o, int priority){
        PriorityPair p = new PriorityPair(o, priority);
        data.addSorted(p);
        count++;
    }

    public Comparable pop(){
        Object a = data.getLast();
        PriorityPair b = (PriorityPair)a;
        data.removeLast();
        Comparable c = b.element;
        count--;
        return c;
    }
    public Comparable top(){
        Object a = data.getLast();
        PriorityPair b = (PriorityPair)a;
        Comparable c = b.element;
        return c;
    }
    /***
     * for this toString, at first, you know the PriorityQueue is a LinkedList, so that you need to get the linked list
     * element and that is a Priority Queue, and you need to get the element of this, and to String
     */
    public String toString(){
        String s="[";
        for(int i=0;i<count;i++){
            s+=((PriorityPair)data.get(i)).getElement()+" ";
        }

        s+="]";
        return s;
    }
}
