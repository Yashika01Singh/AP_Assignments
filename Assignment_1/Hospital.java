import java.util.*;
public class Hospital {
   private final String HospitalName;
   private final int pincode;
   private final String HospitalID;
   private static int Number=0;
  
   private ArrayList<Slot>Slots = new ArrayList<Slot>();

   //getter for uniqueid getUniqueId
   Hospital(String HospitalName , int pincode){
       this.HospitalName=HospitalName;
       this.pincode=pincode;
       this.HospitalID=String.format("%06d", Number);
       Number++;
       System.out.printf("Hospital Name : %s " , this.HospitalName);
       System.out.printf("Pincode %d " , this.pincode);
       System.out.printf("Uniue ID %s " , this.HospitalID);


   }
   public String getUniqueId(){
       return this.HospitalID;
   }
   public void add_Slot(Slot slot){
    this.Slots.add(slot);
   }
   public ArrayList<Slot> getSlot(){
    return Slots;
    }
    public int get_pincode(){
        return this.pincode;
    }
    public String get_Name(){
        return this.HospitalName;
    }
    public void Remove_Slot(Slot Selectedslot){
        int i=0;
        for(Slot slot : this.Slots){
            if(slot==Selectedslot){
                int quantity = slot.getQuantity();
                if(quantity<=1){
                
                    this.Slots.remove(i);
                    return;
                }
                slot.set_quantity(quantity-1);

            }
            i++;
        }
    }
    
   
}
