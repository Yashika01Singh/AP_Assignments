import java.util.*;
public class Slot {
    private final Hospital hospital;
    private final Vaccine vaccine;
    private int day;
    private int quantity;
    
    Slot (Hospital hospital , Vaccine vaccine , int day , int quantiny){

        this.hospital=hospital;
        this.day=day;
        this.quantity=quantiny;
        this.vaccine = vaccine;
        this.print();
        
    }
    public void print(){
        System.out.printf("Slot added by Hospital %d for Day %d ,Available quantinty :%d of Vaccine %s",this.hospital.getHospitalID(),this.day , this.quantity , this.vaccine.get_VaccineName());
    } 
    public int getDay(){
        return this.day;
    }
    public int getQuantity(){
        return this.quantity;
    }
    public Hospital getHospital(){
        return this.hospital.get;
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
