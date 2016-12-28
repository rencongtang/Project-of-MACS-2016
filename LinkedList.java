package hospital;

import hospital.PriorityQueue.PriorityPair;

public class LinkedList {

    private class ListElement {
        private Comparable el1;
        private ListElement el2;

        public ListElement(Comparable el, ListElement nextElement) {
            el1 = el;
            el2 = nextElement;
        }

        public ListElement(Comparable el) {
            this(el, null);
        }//Makes a list with a head and a trail first, and then add the elements

        public Comparable first() {
            return el1;
        }

        public ListElement rest() {
            return el2;
        }

        public void setFirst(Comparable value) {
            el1 = value;
        }

        public void setRest(ListElement value) {
            el2 = value;
        }
    }
    public ListElement getNewElement() {
        return newElement;
    }
    public void setNewElement(ListElement newElement) {
        this.newElement = newElement;
    }
    private ListElement head;
    private ListElement tail;
    private ListElement newElement;
    private int count = 0;
    public LinkedList() {
        head = null;// at the full list, the head is null, but if you want to add elements, that's change
        tail = null;
    }//Without this statement is also fine, this statement is to initialize the Linklist
    public Comparable getFirst() {
        return head.first();
    }

    public Comparable get(int n) {
        ListElement d = head;
        while (n > 0) {
            d = d.rest();
            n--;
        }
        return d.first();
    }
    public void remove(int n){
        ListElement d=head;
        if(n==0){
            head=head.rest();
            d.setRest(null);
        }
        else if(n==1){
            ListElement c=d.rest();
            d.setRest(d.rest().rest());
            c.setRest(null);
        }

        else{
            while((n > 1)){
                d=d.rest();
                n--;
            }
            ListElement c=d.rest();
            d.setRest(d.rest().rest());
            c.setRest(null);

        }

        count--;
    }

    public void addFirst(Comparable o) {//THIS IS IMPORTANT
        ListElement newElement = new ListElement(o);//(1) making a new listelement for the new data
        newElement.setRest(head);//(2) making the rest of the listelement point to the head and
        head=newElement;//(3)make the head point to the new listelement
        //head = new ListElement(o,head); Also can be writen in this way,
        //The next head can point at this head
        count++;
    }

    public Comparable getLast(){//Also can use the size above, I just want to use my own way, of course, it can also be used to get size
        ListElement d=head;
        while(d.rest()!=null){
            d=d.rest();
        }
        return d.first();
    }

    public void addLast(Comparable o) {
        //if Linked list is empty
        if(head == null){

            head = new ListElement(o);
            tail = head;

        }
        else{
            ListElement d= head;
            int n=count-1;//if without -1, it will point to a null rather than the tail
            while(n>0){
                d=d.rest();
                n--;
            }
            tail=d; //it didn't work even with this to find out the tail
            ListElement newElement = new ListElement(o);
            tail.setRest(newElement);//make the el2 of trail to point at newElement
            tail = newElement;//make newElement as a new tail
        }
        count++;
    }
    public void removeLast(){
        ListElement d = head;
        if(d.rest() == null){
            head = null;
        }
        else{
            while(d.rest().rest() != null){
                d = d.rest();
            }
        }
        d.setRest(null);
        tail=null;
        count--;
    }
    public void set(int n,Comparable o){
        ListElement newElement = new ListElement(o);
        if(n==0){
            head.setFirst(o);//The smart way is setFirst, and I can also use the replace way , of course that's the Engineer of MicroSoft
        }
        else{
            ListElement d=head;
            while(n>0){

                d=d.rest();
                d.setFirst(o);
                n--;
            }
            count++;
        }
    }

    public void search(Comparable o){
        int n = 0;
        ListElement d=head;
        while(d.rest() !=null){
            if(d.first()==o){
                System.out.println("the location of Comparable is:"+n);//But if there are more than one Comparable, what you are supposed to do
            }

            d=d.rest();
            n++;

        }
    }
    public void exchangetoLast(ListElement change){


    }
    public String toString() {
        String s = "(";
        ListElement d = head;
        while (d != null) {
            s += (d.first()).toString();
            s += " ";
            d = d.rest();
        }
        s += ")";
        return s;
    }
    public int size(){
        return count;
    }

    public void addSorted(Comparable<Comparable> o){
        //If this list is empty, just add the element in front
        if (head == null){
            head = new ListElement(o,null);
        }
        else if(((PriorityPair)head.first()).getPriority().compareTo(((PriorityPair)o).getPriority()) <0){
            //In this case we can just add the element at the head
            head = new ListElement(o, head);
        }
        else{
            ListElement d = head;
            while((d.rest() != null) && (((PriorityPair)d.rest().first()).getPriority().compareTo(((PriorityPair) o).priority) > 0)){
                d = d.rest();
            }
            ListElement next = d.rest();
            d.setRest(new ListElement(o, next));
        }
        count++;
    }
    //	write a remove to remove specific listelement
    public void remove1(ListElement o){
        ListElement d = head;
        while((d.rest() != o)&&(d.rest() != null)){
            d = d.rest();
        }
        d.setRest(o.rest());
        o.setRest(null);
    }


    public void changePriority(){
        ListElement d = head;
        ListElement priority = head;
        while(d.rest() != null){
            d = d.rest();
            if(d.first().compareTo(priority.first()) > 0){
                priority = d;//To compare the first element one by one until get the largest priority
            }
        }
        d.setRest(priority);
        remove1(priority);//delete priority
    }

}
