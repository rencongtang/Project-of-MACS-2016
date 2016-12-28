package hospital;

public class Register implements Comparable{

    private String roomNumber;
    private String patientNmae;
    public Register(){
    }
    public void setRoomNumber(String roomNumber){
        this.roomNumber = roomNumber;
    }
    public String getRoomNumber(){
        return roomNumber;
    }
    public void setPatientName(String patientName){
        this.patientNmae = patientName;
    }
    public String getPatientName(){
        return patientNmae;
    }

    @Override
    public int compareTo(Object o) {
        // TODO Auto-generated method stub
        return 0;
    }

}
