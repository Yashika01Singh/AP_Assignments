import java.util.*;
public class Vaccine {
    
    private final String VaccineName;
    private int doses;
    private final int gap;

    private Scanner sc = new Scanner(System.in);
    Vaccine(String VaccineName , int doses , int gap){
        
        this.VaccineName = sc.next();
        this.doses = sc.nextInt();
        this.gap=sc.nextInt();
        this.print();     

    }

    public void print(){
        System.out.printf("\nVaccine Name: %s, Number of Doses: %d, Gap Between Doses: %d",this.VaccineName,this.doses,this.gap);
    }

    public String get_VaccineName(){
        return this.VaccineName;
    }
    public int get_Dozes(){
        return this.doses;
    }
   
    public int get_Gap(){
        return this.gap;
    }
    

    





}