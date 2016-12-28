package hospital;



public class Room implements Comparable  {
    private String roomNumber;
    private int capacity;
    private LinkedList patients=new LinkedList();
    private LinkedList returnedPatients=new LinkedList();

    public Room(String roomNumber, int capacity){
        this.roomNumber = roomNumber;
        this.capacity = capacity;
    }
    private void setRoomNumber(String roomNumber){
        this.roomNumber = roomNumber;
    }
    private void setCapacity(int capacity){
        this.capacity = capacity;
    }
    public String getRoomName(){
        return roomNumber;
    }
    public int getCapacity(){
        return capacity;
    }

    public LinkedList show(){
        return patients;
    }
    public int patientNumbers(){
        return patients.size();
    }
    // to sign in a patient, I need to measure the capacity and how many patient in this room, in crease out of the capacity
    public Register signIn(Patient patient){//When you sign in a patient, you need to make a register to return, don't forget to
        //write a register class
        String name = patient.getName();
        patients.addLast(name);
        Register register = new Register();
        register.setPatientName(name);
        register.setRoomNumber(roomNumber);
        System.out.println(name+" has been sign in successfully into "+roomNumber);
        return register;


    }
    public Patient signOut(String name){

        for(int i=0;i<patients.size();i++){
            Patient p=(Patient) patients.get(i);
            if(p.getName()==name){
                Patient get=p;
                patients.remove(i);
                return get;
            }
        }
        return null;
    }

    public String toString(){
        String s="";
        s+=roomNumber;
        return s;
    }
    @Override
    public int compareTo(Object o) {
        // TODO Auto-generated method stub
        return 0;
    }

}
