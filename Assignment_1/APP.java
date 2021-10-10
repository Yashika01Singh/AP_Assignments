import java.util.*;
public class APP {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Portal portal = new Portal();
        System.out.println("coWin Portal initialised...");
        System.out.println("..................................");
        while(true){
        
        System.out.println("\n..................................");
        System.out.println("1.Add Vaccine");
        System.out.println("2.Register Hospital");
        System.out.println("3.Register Citizen");
        System.out.println("4.Add Slot for Vaccination");
        System.out.println("5.Book Slot for Vaccination");
        System.out.println("6.List all slots for a hopital");
        System.out.println("7.Check Vaccination Status");
        System.out.println("8.Exit\n");
        int choice = sc.nextInt();
        if(choice==8){
            break;
        }
        switch(choice) {
            case 1:
                portal.addVaccine();    
                break;
            case 2:
                portal.addHospital();
                break;
            case 3:
                portal.addCitizen();
                break;
            case 4:
                portal.addSlot();
                break;
            case 5:
                portal.BookSlot();
                break;
            case 6:
                portal.show_allSlots();
                break;
            case 7:
                portal.VacStatus();
                break;
            case 8:
                break;
            default:
              // code block
              System.out.println("Enter Correct ");


          }

        
        }
        sc.close();
    }
}
