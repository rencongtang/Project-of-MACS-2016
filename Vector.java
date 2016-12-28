package hospital;


public class Vector {
    protected int count = 0;
    protected Comparable data[];

    //Define a Vector
    public Vector(int capacity){
        data = new Comparable[capacity];
        count = 0;
    }

    //To get the size of Vector
    public int size(){
        return count;
    }
    //To add all the elements you want
    public Comparable[] addAll(int num){
        for(int i= 0;i < num;i++){
            data[i]=i+1;
            count++;
        }
        return data;
    }

    public boolean isEmpty(){
        return size()==0;
    }

    //Add the element b into the Vector
    public int add(Comparable o){
        data[count]= o;
        return count++;
    }
    //Make the data to be a String to show it up
//	public String toString(){
//		String s="[";
//		for(int i=0;i<count-1;i++){
//			s+=data[i]+",";
//		}
//		s+=data[count-1];//making this step is to provide there is a ","in the end
//		s+="]";
//		return s;
//
//	}

    //To find if there is an Comparable element in the Vector
//	public boolean contains(Comparable obj){ //when you judge(to return True or False), you have to use boolean
//		for(int i=0;i<count;i++){
//			if(data[i]==obj) return true;
//		}
//		return false;
//	}
    public boolean contains(Comparable obj) {
        for(int i=0;i<count;i++) {
            if(data[i].equals(obj)) return true;
        }
        return false;
    }
    //To find the location of element
    public Comparable find(Comparable obj){
        for(int i = 0; i<count; i++){
            if(data[i].equals(obj)) return i;
        }
        return false;
    }
    public Comparable get(int i){
        return data[i];
    }

    //To get the first element and the last element
    public Comparable getLast(){
        return data[count-1];
    }
    public Comparable getFirst(){
        return data[0];
    }

    //A binarySearch can make a search faster, to find out if the key in the Vector,
    //the professor told the method in the class
    public boolean binarySearch(Comparable key){
        int start = 0;
        int end = count-1;
        while(start<=end){
            int middle=(start+end+1)/2;
            if((int)key > (int)data[middle]) start=middle+1;// you need to add (int) ahead for numbers it to judge
                //don't forget "+1" that can reduce a judge
            else if((int)key < (int) data[middle]) end=middle-1;
            else return true;
        }
        return false;
    }

    //To change the element in the Vector
    public void set(int index, Comparable obj){
        data[index] = obj;
    }

    public void addFirst(Comparable item){
        for(int i=count-1;i>=0;i--){ //to prevent the problem of plus 1 of 'i'
            data[i+1]=data[i];
        }
        set(0, item);

    }
    public void addLast(Comparable item){
        if(data==null){
            data[0]=item;//this is the most important statement
        }
        else{
            for(int i=0;i<count;i++){
                data[i]=data[i+1];
            }
            set(count-1, item);
        }
        count++;
    }
    public void removeLast(){
        data[count]=null;
        count--;

    }
    public void removeFirst(){
        if(count>0){
            for(int i=0;i<count;i++){
                data[i] = data[i+1];
            }
            count--;
        }
    }
    public void remove(int index){
        if(count>0){
            for(int i=index;i<count-1;i++){// if no this, will out of range of the last element
                data[i]=data[i+1];
            }
            data[count-1] = null;
        }
    }
    public void delete(int index){
        data[index]=null;
    }
    public void reverse(){
        int c;
        for(int i=0;i<=count/2-1;i++){
            c=(int) data[i];
            data[i]=data[count-1-i];
            data[count-1-i]=c;
        }
        count--;
    }

}

