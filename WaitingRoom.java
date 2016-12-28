package hospital;

/**
 * Created by rencongtang on 25/12/2016.
 */
public class WaitingRoom {
    private PriorityQueue normalWaitingRoom = new PriorityQueue();
    private PriorityQueue returnSingle = new PriorityQueue();
    private PriorityQueue returnNormal =new PriorityQueue();
    public WaitingRoom(){

    }

    public void addToNormal(Patient p){
//        Register register=new Register();
        int level=p.getDiseaseLevel();
        normalWaitingRoom.push(p,level);
//        register.setPatientName(p.getName());
//        register.setRoomNumber("");
    }

    public void returnToSing(Patient p1){
        int level=p1.getDiseaseLevel();
        returnSingle.push(p1,level);
//        System.out.println("Patient: "+p1.getName()+" has been returned back to Waiting Room");
    }

    public void returnToNormal(Patient p2){
        int level=p2.getDiseaseLevel();
        returnNormal.push(p2,level);
//        System.out.println("Patient: "+p2.getName()+" has been returned back to Waiting Room");
    }

    public Patient signOut(){
        Patient p= (Patient)normalWaitingRoom.pop();
        return p;
    }

    public Patient signOutSingle(){
        Patient p1=(Patient)returnSingle.pop();
        return p1;
    }

    public Patient signOutNormal(){
        Patient p2=(Patient)returnNormal.pop();
        return p2;
    }
}
