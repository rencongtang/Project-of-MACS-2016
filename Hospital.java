package hospital;

import com.sun.org.apache.xpath.internal.functions.FuncFalse;

/***
 * For the part 3, we use this class hospital to deal with the problem.
 * At first, what the hospital contains? The registers and departments.
 * the registers contains the regist of the patients in a specific room,
 * when the patient sign in into a patient room, the register worked,
 * and for the departments, it contains the patient rooms and waiting rooms
 * you can add patient rooms into the department in this class, and add patient
 * into a specific room in the department.
 */

public class Hospital {
    private LinkedList registers = new LinkedList();
    private LinkedList departments= new LinkedList();
    public Hospital()
    {

    }

    public void addDepartments(Department department){
        departments.addLast(department);
    }

    // Your methods for setting up a hospital (adding departments etc.)

    /**
     * Add the specified device to a given department (specified by name).
     *
     * @param device          // String specifying the device
     * @param departmentName  // Name of the department
     */

    public void addDeviceToDepartment(String device, String departmentName)
    {
        for(int i=0;i<departments.size();i++){
            Department department = (Department) departments.get(i);
            if(department.getDepartmentName()==departmentName){
                department.addDevice(device);
            }
        }
    }

    /**
     * Sign in a patient to a given department (name).
     *
     * @param patient
     * @param departmentName
     */
    public void signInPatientToDepartment(Patient patient, String departmentName)
    {
        for(int i=0;i<departments.size();i++){// To find the department one by one,if th department is what you need, operate it, or you need to
            //push it back
            Department department = (Department) departments.get(i);
            if(department.getDepartmentName()==departmentName){
                department.addToWaitingRoom(patient);//add to a department, at first, patient is supposed to add into a patient room
                Register register=new Register();
                register.setPatientName(patient.getName());
                register.setRoomNumber(departmentName+"'s Waiting Room");
                registers.addLast(register);
            }
        }
    }

    public Department findDepartment(String departmentName){
        for(int i=0;i<departments.size();i++){
            Department department = (Department) departments.get(i);
            if(department.getDepartmentName()==departmentName){
//                Patient patient = department.outWaitingRoom();
                return department;
            }
            else{
                System.out.println("Sorry, no this department in this hospital");
            }
        }
        return null;
    }

    public void signInPatientToPatientRoom(String depatmentName,String roomName){
        for(int i=0;i<departments.size();i++){//sign a patient in the department one by one, because we have the pority to push patient out
            //that means we don't need to add the specific name into the room.
            Department department = (Department) departments.get(i);
            if(department.getDepartmentName()==depatmentName){
                Room room=department.findRoom(roomName);
                Patient patient = department.outWaitingRoom();
                if(room.patientNumbers()<room.getCapacity()){
                    if((!patient.getSingle()||room.getCapacity()==1)&&(room!=null)){//To find out if this patient need a single room, and if this room is a single
                        //room, we will not worry anything, just add patient into this. And when we have a patient needs a single room, this code can
                        //also work we don't have to write a specific code for single room, when I read my code again, I even suprise how I came up with
                        //this idea...
                        Register register=department.signIntoPatientRoom(patient,room);

                        for(int j=0;j<registers.size();j++){
                            if(((Register)registers.get(j)).getPatientName()==patient.getName()){
                                registers.remove(j);
                                break;
                            }
                        }
                        registers.addLast(register);
                    }
                    else {
                        System.out.println("Patient:"+patient.getName()+" needs a single room!");// If not ,we need to find single rooms in the department
                        //and print it out to make those rooms visible for us to make decision
                        LinkedList singleRooms=department.findSingleRoom();
                        if(singleRooms!=null){
                            for(int k=0;k<singleRooms.size();k++){
                                System.out.println("Single Room: "+((Room)singleRooms.get(k)).getRoomName()+" can be used");
                                System.out.println("Attention, you need to add "+patient.getName()+" at first!!!");
                                department.addBackToSingleWaitingRoom(patient);
                            }
                        }
                        else{
                            System.out.println("Sorry, no free Single Room now, add patient:"+patient.getName()+" back to Waiting room");
                            department.addBackToSingleWaitingRoom(patient);
                        }

                    }
                }
                else {
                    System.out.println("Can't sign in patient, This room is full, looking for other rooms");
                    LinkedList availableRooms=department.findAvailableRoom();
                    if(availableRooms==null){
                        System.out.println("Sorry, no rooms are available, return Patient: "+patient.getName()+" back to Waiting Roomhas been returned back to Waiting Room");
                    }
                }

            }

        }
    }

    public void signInReturnedSinglePatient(String departmentName,String roomName){
        for(int i=0;i<departments.size();i++){
            if(((Department)departments.get(i)).getDepartmentName()==departmentName){
                Department department=(Department) departments.get(i);
                Patient p=department.outSingle();
                Room room=department.findRoom(roomName);
                Register register=department.signIntoPatientRoom(p,room);
                for(int j=0;j<registers.size();j++){
                    if(((Register)registers.get(j)).getPatientName()==p.getName()){
                        registers.remove(j);
                        break;
                    }
                }
                registers.addLast(register);

            }
        }
    }

    public void findPatient(String patientName){
        boolean flag =false;// To make a flag for true and false
        for(int i=0;i<registers.size();i++){//check the elements of queue one by one
            Register register = (Register) registers.get(i);
            if(register.getPatientName()==patientName){
                flag = true;
                System.out.println("The patient: "+patientName+"is at "+register.getRoomNumber());

            }
        }
        if(flag==false){
            System.out.println("Sorry, can't find patient "+patientName);
        }

    }

    /**
     * Sign out a patient from the hospital.
     *
     * @param patient
     */
    public void signOutPatient(Patient patient)
    {
        // ...
    }

    /**
     * Get the room number (or name) for a given patient (name).
     *
     * @param name
     * @return The room number as String or the name of the room.
     */
//	public String getRoomNumberForPatientNamed(String name)
//	{
//		// ...
//	}

    /**
     * Print the shortest route from one department to another.
     *
     * @param from  Name of the department to start from.
     * @param to    Name of the department to go to.
     */
    public void printRouteFromTo(String from, String to)
    {
        // ...
    }

    /**
     * Print the shortest route from one department to another, avoiding a third given department.
     *
     * @param from      Name of the department to start from.
     * @param to        Name of the department to go to.
     * @param avoiding  Name of the department to avoid.
     */
    public void printRouteFromToAvoiding(String from, String to, String avoiding)
    {
        // ...
    }

    /**
     * Print the shortest route from one department to another, via a third given department.
     *
     * @param from  Name of the department to start from.
     * @param to    Name of the department to go to.
     * @param via   Name of the department to pass through.
     */
    public void printRouteFromToVia(String from, String to, String via)
    {
        // ...
    }

    /**
     * Find the closest department to a given department that has a given device.
     *
     * @param dep     Name of the given department.
     * @param device  Name of the device.
     * @return Name of the closest department where the given device can be found.
     */
//	public String closestDepartmentToWithDevice(String dep, String device)
//	{
//		// ...
//	}
//
//	/**
//	 * Print the current status of the hospital.
//	 * Should include a list of patients and their roomnumbers (register)
//	 * and departments (name, rooms, patients/room -including patient names-, status waiting room)
//	 *
//	 */
//	public String toString()
//	{
//		// ...
//	}
}
