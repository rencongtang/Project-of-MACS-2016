package hospital;



public class Main {
    public static void main(String[] args) {
        Hospital hospital1 = new Hospital();
        Patient patient1 = new Patient("Glen Quagmire",1,true);
        Patient patient2 = new Patient("Peter Griffn",2,false);
        Patient patient3 = new Patient("Joe Swanson",3,false);
        Patient patient4 = new Patient("Jack",2,false);
        Patient patient5 = new Patient("Jones",2,true);
        Room room1 = new Room("106",3);
        Room room2 = new Room("107",3);
        Room room3 = new Room("108",2);
        Room room4 = new Room("109",1);
        Department department1 = new Department("Dep1");
        Department department2 = new Department("Dep2");
        department1.addPatientRooms(room1);
        department1.addPatientRooms(room2);
        department1.addPatientRooms(room3);
        department1.addPatientRooms(room4);

        hospital1.addDepartments(department1);
        hospital1.addDepartments(department2);
        hospital1.signInPatientToDepartment(patient5,"Dep1");
        hospital1.signInPatientToDepartment(patient3,"Dep1");
        hospital1.signInPatientToDepartment(patient2, "Dep1");
        hospital1.signInPatientToDepartment(patient1, "Dep1");
        hospital1.signInPatientToDepartment(patient4,"Dep1");
//		System.out.println(department1.outWaitingRoom().getName());
//		System.out.println(department1.outWaitingRoom().getName());
//		System.out.println(department1.outWaitingRoom().getName());
//
//
//
////
        hospital1.signInPatientToPatientRoom("Dep1","108");
        hospital1.signInReturnedSinglePatient("Dep1","109");
        hospital1.signInPatientToPatientRoom("Dep1","109");
        hospital1.signInPatientToPatientRoom("Dep1","108");
        hospital1.signInPatientToPatientRoom("Dep1","108");
        hospital1.signInPatientToPatientRoom("Dep1","108");
//
//        hospital1.findPatient("Glen Quagmire");
//        hospital1.findPatient("Joe Swanson");
//        hospital1.findPatient("Peter Griffn");
//        LinkedList l=new LinkedList();
//        l.addLast(1);
//        l.addLast(2);
//        l.addLast(3);
//        l.addLast(4);
//        l.remove(1);
//        l.addLast(5);
//        System.out.print(l);

//		System.out.print(department1.outWaitingRoom().getName());
//
//		PriorityQueue p=new PriorityQueue();
//		p.push(2,2);
//		p.push(1,1);
//		p.push(3,3);
//		System.out.print(p);
//		Comparable a =p.pop();
//		p.push(a,1);
//		System.out.print(p);







//


//
//
//		department1.addPatientRooms(room1);
//		department1.addPatientRooms(room2);
//		department1.SetWaitingRoom();
//		department1.addDevice("mashine1");
//		department1.addDevice("mashine2");
//		department1.addDevice("mashine3");
//		department1.showDevices();
//		department1.addEquipments(1);
//		department1.addEquipments(2);
//		department1.removeEquipments(0);
//		department1.addEquipments(2);
//		department1.showEquipments();
//		department1.addToWaitingRoom(patient1);
//		department1.addToWaitingRoom(patient2);
//		department1.addToWaitingRoom(patient3);
//		Patient p1 = (Patient)department1.outWaitingRoom();
//		Patient p2 = (Patient)department1.outWaitingRoom();
//		Patient p3 = (Patient)department1.outWaitingRoom();
//
//		String name1 = p1.getName();
//		String name2 = p2.getName();
//		System.out.println(name1);
//		System.out.println(name2);
//		System.out.println(department1);
//
//		int capacity = room1.getCapacity();
//		room1.setPatients();
//		int a = room1.getRoomNumber();
//		System.out.println(a);
//		room1.signIn(patient1);
//		room1.signIn(patient2);
//		room1.signIn(patient3);
//		Vector b = room1.show();
//		String c = room1.signOut(patient2);
//		System.out.println(b);
//		System.out.println(c);

    }

}
