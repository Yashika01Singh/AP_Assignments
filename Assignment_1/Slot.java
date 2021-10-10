
public class Slot {
    private Hospital hospital;
    private Vaccine vaccine;
    private int day;
    private int quantity;
    
    Slot (Hospital hospital , Vaccine vaccine , int day , int quantity){

        this.hospital=hospital;
        this.day=day;
        this.quantity=quantity;
        this.vaccine = vaccine;
        this.print();
        
    }
    public void print(){
        
        System.out.printf("Slot added by Hospital %s for Day %d ,Available quantinty :%d of Vaccine %s",this.hospital.getUniqueId(),this.day , this.quantity , this.vaccine.get_VaccineName());
    } 
    public int getDay(){
        return this.day;
    }
    public int getQuantity(){
        return this.quantity;
    }
    public Hospital getHospital(){
        return this.hospital;
    }
    
    public String getVaccine(){
        return this.vaccine.get_VaccineName();
    }
    public void set_quantity(int quantity){
        
        this.quantity=quantity;

    }
    public int getdozes(){
        return this.vaccine.get_Dozes();
    }
    
    public Vaccine getvaccinefull(){
        return this.vaccine;
    }
}
