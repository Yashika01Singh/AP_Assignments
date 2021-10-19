

public class Instructor implements User{
   
    private static int number;
    private int id;
    
    Instructor(){
        this.id = number;
        number++;
    }
    public int getID(){
        return this.id;
    }
    @Override
    public void print_menu(){
        System.out.println("1.Add class material");
        System.out.println("2.Add assessment");
        System.out.println("3.View Lecture materials");
        System.out.println("4.view assessments");
        System.out.println("5.Grade assessments");
        System.out.println("6.Close assessments");
        System.out.println("7.view Comments ");
        System.out.println("8.Add Comments ");
        System.out.println("9.Logout");
        System.out.println("");        
    }
    @Override
    public String getusername() {
        String s ="I"+this.id;
        return s;
    }
}

