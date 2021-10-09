public class Vaccine {

    private final String VaccineName;
    private int doses;
    private final gap;

    private static int numberofvaccines = 0;

    private Scanner sc = new Scanner(System.in);
    Vaccine(){
        numberofvaccines++;
        System.out.println("Vaccine Name: ");
        this.VaccineName = sc.next();
        System.out.println("Number of Doses: ");
        this.doses = sc.nextInt();
        System.out.println("Gap between Doses: ");
        this.gap=sc.nextInt();
        this.toString();


    }

    public toString(){
        System.out.printf("\nVaccine Name: %s, Number of Doses: %d, Gap Between Doses: %d",this.name,this.doses,this.gap);
    }





}