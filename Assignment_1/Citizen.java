import java.util.*;
enum Status { Not_Vaccinated , partially_Vaccinated ,fully_Vaccinated} 
public class Citizen {
    
    private final int age;
    private final String name;
    private final float ID;
    private Slot slot;
    private int bookings;
    private Status status;
    

    /*status , slot*/

    Citizen(int age , String name , float ID){
        this.age=age;
        this.name=name;
        this.ID=ID;
        this.bookings=0;
        this.status=Status.Not_Vaccinated;
    }

    public void book_slot(Slot slot){
        
        if(this.bookings==0)
        {this.bookings++;
        this.slot = slot;
        }
        else {
            Vaccine vac = slot.getvaccinefull();
            
            if(bookings>=vac.get_Dozes()){
                System.out.println("Already Vaccinated");
            }
            if(slot.getDay() - this.slot.getDay() >= vac.get_Gap() )
        }
    }

    public float get_ID(){
        return this.ID;
    }


}