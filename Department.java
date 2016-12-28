package hospital;
/***
 * what I'm supposed to finish in this part:
 * 1> I need to build a new class named Department, in this class, it contains patient Rooms,
 * special waitingRooms, devices and the devices which is equipmented.
 * 2> I need to add two new parameter into patient, which is the level of sick and is that necessary to
 * stay in a single patients room
 * 3> I need to make the department has the ability to add and remove different devices into equipment
 */


public class Department implements Comparable{

    private String departmentName;
    //	private int Rooms;//To save how many rooms in this department
    private LinkedList patientRooms = new LinkedList();
    private WaitingRoom waitingRoom=new WaitingRoom();
    private Vector devices = new Vector(100);
    private LinkedList equipments = new LinkedList();
    //private Vector RoomName =new Vector(100);

    public Department(String departmentName){//Set the name of department
        this.departmentName = departmentName;
    }
    public void addPatientRooms(Room r){//add patient rooms
        patientRooms.addLast(r);
    }
    public Room getRoom(int n){
        return (Room)patientRooms.get(n);
    }
    public String getDepartmentName(){
        return departmentName;
    }
    public void setDevices(int capacity){//Set devices
        devices = new Vector(capacity);
    }
    public void addDevice(String Device){//add
        devices.add(Device);
    }
    public void showDevices(){
        System.out.println(devices);
    }
    public int size(){
        return patientRooms.size();
    }
    public void addEquipments(int i){
        Comparable a = devices.get(i);
        equipments.addFirst(a);
    }

    public void removeEquipments(int i){
        equipments.remove(i);;
    }
    public void showEquipments(){
        System.out.println(equipments);
    }
    public void addToWaitingRoom(Patient p){//add patients to the waiting room
        waitingRoom.addToNormal(p);
    }
    public Room findRoom(String roomName){
        for(int k=0;k<patientRooms.size();k++){
            Room getRoom=(Room)patientRooms.get(k);
            if( getRoom.getRoomName()==roomName){
                return getRoom;
            }

        }
        return null;
    }
    public void addBackToSingleWaitingRoom(Patient p1){
        waitingRoom.returnToSing(p1);
    }
    public void addBackToNormalWaitingRoom(Patient p2){
        waitingRoom.returnToNormal(p2);
    }
    public Patient outWaitingRoom(){
        return (Patient) waitingRoom.signOut();
    }
    public Patient outSingle(){
        return (Patient) waitingRoom.signOutSingle();
    }

    public Patient outNormal(){
        return (Patient) waitingRoom.signOutNormal();
    }

    public LinkedList findSingleRoom(){
        LinkedList singleRooms=new LinkedList();
        for(int i=0;i<patientRooms.size();i++){
            Room room = (Room)patientRooms.get(i);
            if(room.getCapacity()==1&&room.patientNumbers()==0){
                singleRooms.addLast(room);
            }
        }
        return singleRooms;
    }

    public LinkedList findAvailableRoom(){
        LinkedList rooms=new LinkedList();
        for(int i=0;i<patientRooms.size();i++){
            Room room =(Room)patientRooms.get(i);
            if(room.getCapacity()>room.patientNumbers()){
                rooms.addLast(room);
            }
        }
        return rooms;
    }
    //To sign in a patient into a patient room, it can pop patients out of WR automaticlly, and what I need to take into consider is
    //is he want a sigle room at first
    public Register signIntoPatientRoom(Patient patient,Room patientRoom){

        for(int i=0;i<patientRooms.size();i++) {
            Room room = (Room) patientRooms.get(i);

            if(room==patientRoom) {
                int capacity = room.getCapacity();

                Register register=new Register();
                register = room.signIn(patient);
				//System.out.println("patient "+patient.getName()+" has been sign in "+room.getRoomNumber());
                return register;
            }
        }
        return null;
    }

    public String toString() {
        String s = "[";
        s+="Department Name:";
        s+=departmentName+" ";
        s+="devices:";
        s+=devices+" ";
        s+="equipments:";
        s+=equipments+" ";
        s+="Rooms:";
        s+=patientRooms;
        s+="WaitingRooms:";
        s+=waitingRoom;
        s+="]";
        return s;
    }

    @Override
    public int compareTo(Object o) {
        // TODO Auto-generated method stub
        return 0;
    }
}
