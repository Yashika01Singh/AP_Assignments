
enum Status { Not_Vaccinated , partially_Vaccinated ,fully_Vaccinated} 
public class Citizen {
    //This class creates a object citizen
    private final int age;
    private final String name;
    private final String ID;;
    private Slot slot;
    private int bookings;
    private Status status;
    

    /*status , slot*/

    Citizen(int age , String name , String ID){
        this.age=age;
        this.name=name;
        this.ID=ID;
        this.bookings=0;
        this.status=Status.Not_Vaccinated;
        this.slot=null;
    }
    public int getAge() {
        return age;
    }
    public String get_VacName(){
            return this.slot.getVaccine();
    }
    public int get_bookings(){
        return this.bookings;
    }
    public boolean book_slot(Slot slot){
        Vaccine vac = slot.getvaccinefull();

        if(this.bookings >= vac.get_Dozes()){
            System.out.println("Already vacccinated ");
            return false;
        }
        
        
        boolean success = false;
        if(this.bookings==0)
        {this.bookings++;
        this.slot = slot;
        success=true;
        }
        else {
            
            if( this.slot.getVaccine() .equalsIgnoreCase(slot.getVaccine()) ==false ){
                System.out.printf("You have earlier registered for vaccine %s you can register again for only this vaccine",this.slot.getVaccine());
                return false;
            }
            
            if(slot.getDay() - this.slot.getDay() >= vac.get_Gap() && this.bookings < vac.get_Dozes()){

                this.bookings++;
                this.slot=slot;
                success=true;

            }
        }
        if(this.bookings ==vac.get_Dozes()){
            this.status = Status.fully_Vaccinated;
        }
        else if(success == true){
            this.status = Status.partially_Vaccinated;
        }

        return success;

    }

    public String get_ID(){
        return this.ID;
    }
    public String get_Name(){
        return this.name;
    }
    public Status getStatus(){
        return this.status;
    }
    public int get_DueDate(){
        if(this.slot == null){
            return -1;
        }
        return this.slot.getDay()+this.slot.getvaccinefull().get_Gap();
    }

}