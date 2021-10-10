import java.util.*;
public class Hospital {
   private final String HospitalName;
   private final int pincode;
   private final int HospitalID;
   private static int Number=0;
  
   private ArrayList<Slot>Slots = new ArrayList<Slot>();

   //getter for uniqueid getUniqueId
   Hospital(String HospitalName , int pincode){
       this.HospitalName=HospitalName;
       this.pincode=pincode;
       this.HospitalID=Number;
       Number++;

   }
   public float getUniqueId(){
       return this.HospitalID;
   }
   public void addSlot(Slot slot){
    this.Slots.add(slot);
   }
   public ArrayList<Slot> getSlot(){
    return Slots;
    }
    public int get_pincode(){
        return this.pincode;
    }
    public void Remove_Slot(Slot Selectedslot){
        for(Slot slot : Slots){
            if(slot==Selectedslot){
                int quantity = slot.getQuantity();
                if(quantity==1){
                    Slots.remove(slot);
                }
                slot.set_quantity(quantity-1);

            }
        }
    }
    
    /*
   public void print_Slots(){
    int i=0;
    for (Slot slot : Slots){
        
            print_slot(slot);
    }
   }
   private void print_slot(){
       int i=0;
        for (Slot slot : Slots){
            
            System.out.printf("Day : &d",slot.getDay());
            System.out.printf("Available Qty : &d",slot.getQuantity()); 
            System.out.printf("Vaaccine : &d",slot.getVaccine());
            i++;

        }
        
   }*/
}
