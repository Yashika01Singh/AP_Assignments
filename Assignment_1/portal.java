import java.util.*;

public class Portal{
    
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
        gap=0;
        if(dose>1){
            System.out.println("Gap between Doses:");
        gap=sc.nextInt();
        }
        
        Vaccine vaccine = new Vaccine(s, dose, gap);
        this.Vaccines.add(vaccine);
    }
    
    public void addSlot(){
        System.out.println("Enter Hospital ID:");
        Hospital hospital=null;
        try{
            hospital=Hospitals.get(sc.nextInt());
            }catch (Exception e){
                System.out.println("Enter valid ID");
                return;
            }
        
    
        System.out.println("Enter Number of Slots to be added:");
        int slotnumbers=sc.nextInt();
        while(slotnumbers>0){
        System.out.println("Enter day number:");
        int day = sc.nextInt();
        System.out.println("Enter quantity");
        int quantity=sc.nextInt();
        this.printall_Vaccines();
        System.out.println("Enter Choice :");

        Vaccine vaccine = null;
        try{
            vaccine=Vaccines.get(sc.nextInt());
            }catch (Exception e){
                System.out.println("Enter valid chocie");
                return;
            }
        
        System.out.println(vaccine.get_VaccineName());
        Slot slot = new Slot(hospital, vaccine, day, quantity);
        
        

        hospital.add_Slot(slot);
        System.out.println();

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
            System.out.printf("%d > ", i);
            System.out.println( Vaccines.get(i).get_VaccineName());
        }
    }
    
    public void addCitizen(){
        System.out.println("Citizen Name : ");
        String name = sc.next();
        System.out.println("Age : ");
        int age=sc.nextInt();
        
        System.out.println("Unique ID: ");
        String ID=sc.next();
        System.out.printf("Citizen Name : %s, Age: %d, Unique ID: %s",name,age,ID);
        if(age<18){
            System.out.println("\nOnly above 18 are allowed");
            return;
        }
        
        
        
        for(Citizen citi: Citizens){
            if(ID.equalsIgnoreCase(citi.get_ID())){
                System.out.println("ID is not Unique");
                return;
            }
        }
        
        Citizen citizen = new Citizen(age, name, ID);
        
        this.Citizens.add(citizen);
    }
    private void print_slot(Slot slot){
        System.out.printf("Day : %d ",slot.getDay());
        System.out.printf("Available Qty : %d ",slot.getQuantity()); 
        System.out.printf("Vaaccine : %s ",slot.getVaccine());
        System.out.println();
    
    }
    public void show_allSlots(){
        System.out.println("Enter Hospital ID");
        Hospital hospital = null;
        try{
        hospital =Hospitals.get(sc.nextInt()) ;
        }catch (Exception e){
            System.out.println("Enter valid Hospital ID");
            return;
        }
        int i=0;
            
            ArrayList<Slot>Slots=hospital.getSlot();
            for(Slot slot : Slots){
                System.out.printf("\n%d -> ",i);
                print_slot(slot);
                i++;
                }
            
        

    }
    public void BookSlot(){
        System.out.println("Enter patient Unique ID:");
        String id = sc.next();
        
        Citizen citizen = null;
        for(Citizen citi: Citizens){
            if(id .equalsIgnoreCase( citi.get_ID())){
                citizen=citi;
                break;
            }}
        if(citizen == null){
            System.out.println("Invalid ID");
            return;    
        }
        if(citizen.getStatus() == Status.fully_Vaccinated){
            System.out.println("Citizen Already vaccinated");
            return;
        }
        System.out.println("1.Search by area \n2.Search by Vaccine\n3.Exit");
        System.out.println("Enter option");
        int ch = sc.nextInt();
        int i=0;
        Hospital SelectedHospital=null;
        Slot SelectedSlot=null;

        ArrayList<Slot>SuitableSlots=new ArrayList<Slot>();

        if(ch==1){
            //Search by area
            System.out.println("Enter PinCode");
            int pincode = sc.nextInt();
            
            for (Hospital hospital : Hospitals){
                if(pincode==hospital.get_pincode()){
                    System.out.printf("%s %s \n" , hospital.getUniqueId() , hospital.get_Name());
                    
                }

            }
            
            System.out.println("\nEnter Hospital ID:");
            try{
                SelectedHospital  =Hospitals.get(sc.nextInt()) ;
                }catch (Exception e){
                    System.out.println("Enter valid Hospital ID");
                    return;
                }
            ArrayList<Slot>Slots=SelectedHospital.getSlot();
            i=0;       
            for(Slot slot : Slots){

            System.out.printf("%d -> " , i);
            print_slot(slot);
            i++;

            }
            System.out.println("Choose Slot \n");
            try{
                SelectedSlot = Slots.get(sc.nextInt());
                }catch (Exception e){
                    System.out.println("Enter valid slot number ");
                    return;
                }
            
        
        }
        else if(ch==2){
            //Search by Vaccine
            i=0;
            printall_Vaccines();
            System.out.println("Enter Vaccine name (for eg. Covax)");
            String vac = sc.next();
            
            for (Hospital hospital : Hospitals){
                ArrayList<Slot>Slots=hospital.getSlot();
                
                for(Slot slot : Slots){
                if((slot.getVaccine()).equalsIgnoreCase(vac)){
                    System.out.printf("%s %s \n" , hospital.getUniqueId() , hospital.get_Name());                
                    
                    
                }
                   
                }


             }
             try{
                SelectedHospital = Hospitals.get(sc.nextInt());
                }catch (Exception e){
                    System.out.println("Enter valid Hospital ID");
                    return;
                }
             
             ArrayList<Slot>Slots=SelectedHospital.getSlot();
             for(Slot slot : Slots){
                if((slot.getVaccine()).equalsIgnoreCase(vac) && citizen.get_DueDate()<=slot.getDay()){
                    System.out.printf("%d ->" , i);
                    print_slot(slot);
                    i++;
                    SuitableSlots.add(slot);
                }

            }
            if(SuitableSlots.isEmpty()){
                System.out.println("No slots");
                return;
            }
            System.out.println("Choose slot");
                int choice=sc.nextInt();
                try{
                    SelectedSlot=SuitableSlots.get(choice);
                    }catch (Exception e){
                        System.out.println("Enter valid choice");
                        return;
                    }
               
        }
        else{        
            return;
        }
        
        
          
        boolean success = citizen.book_slot(SelectedSlot);
        if(success){
            SelectedHospital.Remove_Slot(SelectedSlot);
            System.out.printf("%s vaccinated with %s" , citizen.get_Name(),SelectedSlot.getVaccine());
            System.out.println("\nSlot booked successfully");
        }  
        


    }

    public void VacStatus(){
        System.out.println("Enter patient Unique ID:");
        String id = sc.next();
        Citizen citizen = null;
        for(Citizen citi: Citizens){
            if(id.equalsIgnoreCase(citi.get_ID())){
                citizen=citi;
                break;
            }}
        if(citizen == null){
            System.out.println("Invalid ID");
            return;    
        }
        Status status = citizen.getStatus();
        if(status==Status.partially_Vaccinated){
            System.out.println("PARTIALLY VACCINATED");
            System.out.printf("Vaccine Given: %s \n" , citizen.get_VacName());
            System.out.printf("Number of Doses given: %d\5n" , citizen.get_bookings());
            System.out.printf("Next Dose due date: %s\n" ,citizen.get_DueDate());
        }
        if(status==Status.fully_Vaccinated){
            System.out.println("FULLY VACCINATED\n");
            System.out.printf("Vaccine Given: %s \n" , citizen.get_VacName());
            System.out.printf("Number of Doses given: %d\n" , citizen.get_bookings());
        }
        if(status == Status.Not_Vaccinated){
            System.out.println("citizen REGISTERED");
        }

    }
  
}
