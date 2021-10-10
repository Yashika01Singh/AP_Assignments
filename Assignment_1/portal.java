import java.util.*;
public class portal {
    
    private ArrayList<Vaccine>Vaccines = new ArrayList<Vaccine>() ;
    private ArrayList<Hospital>Hospitals = new ArrayList<Hospital>();
    private ArrayList<Citizen>Citizens= new ArrayList<Citizen>();
    
    private Scanner sc = new Scanner(System.in);
    public void addVaccine(){
        String s;
        int dose,gap;
        System.out.println("Vaccine Name:");
        s=sc.next();
        System.out.println("Number of Doses:");
        dose=sc.nextInt();
        System.out.println("Gap between Doses:");
        gap=sc.nextInt();
        Vaccine vaccine = new Vaccine(s, dose, gap);
        this.Vaccines.add(vaccine);
    }
    /*public void addHospital(Hospital hospital){
        this.Hospitals.add(hospital);
    }*/
    public void addSlot(){
        System.out.println("Enter Hospital ID:");
        Hospital hospital=Hospitals.get(sc.nextInt());
        System.out.println("Enter Number of Slots to be added:");
        int slotnumbers=sc.nextInt();
        while(slotnumbers>0){
        System.out.println("Enter day number:");
        int day = sc.nextInt();
        System.out.println("Enter quantity");
        int quantity=sc.nextInt();
        this.printall_Vaccines();
        Vaccine vaccine=Vaccines.get(sc.nextInt());
        Slot slot = new Slot(hospital, vaccine, day, quantity);
        hospital.addSlot(slot);
        slotnumbers--;
        }

    }
    public void addHospital(){
        System.out.println("Hospital Name:");
        String HospitalName=sc.next();
        System.out.println("PinCode :");
        int pincode = sc.nextInt();
        Hospital hospital=new Hospital(HospitalName, pincode);
        this.Hospitals.add(hospital);

    }

    public void printall_Vaccines(){
        for(int i=0 ; i<Vaccines.size();i++){
            System.out.print(i);
            System.out.println( Vaccines.get(i).get_VaccineName());
        }
    }
    
    public void addCitizen(){
        System.out.println("Citizen Name : ");
        String name = sc.next();
        System.out.println("Age : ");
        int age=sc.nextInt();
        if(age<18){
            System.out.println("Citizen Must be more than 18 years old");
            return;
        }
        System.out.println("Unique ID: ");
        float ID=sc.nextFloat();
        Citizen citizen = new Citizen(age, name, ID);
        this.Citizens.add(citizen);
    }
    private void print_slot(Slot slot){
        System.out.printf("Day : &d",slot.getDay());
        System.out.printf("Available Qty : &d",slot.getQuantity()); 
        System.out.printf("Vaaccine : &d",slot.getVaccine());
    
    }

    public void BookSlot(){
        System.out.println("Enter patient Unique ID:");
        float id = sc.nextFloat();
        System.out.println("1.Search by area \n2.Search by Vaccine\n3.Exit");
        System.out.println("Enter option");
        int ch = sc.nextInt();
        int i=0;
        ArrayList<Slot>SuitableSlots = new ArrayList<Slot>();
        ArrayList<Hospital>SuitableHospitals = new ArrayList<Hospital>();

        if(ch==1){
            //Search by area
            System.out.println("Enter PinCode");
            int pincode = sc.nextInt();
            
            for (Hospital hospital : Hospitals){
                if(pincode==hospital.get_pincode()){
                ArrayList<Slot>Slots=hospital.getSlot();
                
                
                for(Slot slot : Slots){
                    SuitableSlots.add(slot);
                    SuitableHospitals.add(hospital);
                    System.out.println(i);
                    print_slot(slot);
                    i++;
                }

                }

            }
            
        
        }
        else if(ch==2){
            //Search by Vaccine
            printall_Vaccines();
            System.out.println("Enter Vaccine name (for eg. covax");
            String vac = sc.next();
            
            for (Hospital hospital : Hospitals){
                ArrayList<Slot>Slots=hospital.getSlot();
                
                for(Slot slot : Slots){
                if((slot.getVaccine()).equalsIgnoreCase(vac)){
                    SuitableSlots.add(slot);
                    SuitableHospitals.add(hospital);
                    System.out.println(i);
                    print_slot(slot);
                    i++; 
                }
            }

            }
        }
        else{        
            return;
        }
        System.out.println("Enter choice:");
        int slot_number = sc.nextInt();
        Slot SelectedSlot = SuitableSlots.get(i);
        Hospital SelectedHospital = SuitableHospitals.get(i);
        SelectedHospital.Remove_Slot(SelectedSlot);
        
        for(Citizen citizen : Citizens){
            if(id == citizen.get_ID()){
                citizen.book_slot(SelectedSlot);
            }
        }


    }
  
}
