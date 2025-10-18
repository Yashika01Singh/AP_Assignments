import java.util.*;
public class Main {
    private static ArrayList<soft_toy>SoftToys= new ArrayList<soft_toy>() ;
    public static void main(String[] args) throws InvalidTypeException{
       
        

        Scanner sc = new Scanner(System.in);
        Random rd = new Random();
        System.out.println("Hit enter to initialise the game");
        sc.nextLine();
        String[] hop_no = new String[]{"first" , "second", "third" , "fourth" , "fifth"};
        set_soft_toys();
       // System.out.println(SoftToys.size());
        System.out.println("Game is ready");
        int i=0;
        Gamer player = new Gamer();
        while(i<5){
        System.out.printf("Hit enter for %s hop \n" , hop_no[i]);
        sc.nextLine();
        int hop = rd.nextInt(22)+1;
        Question q=null;
        try {
            
            System.out.printf("You landed on tile %d\n",hop); 
            soft_toy soft = SoftToys.get(hop-1);
            if(hop%2!=0){
                while(true){
                    try{
                System.out.println("Question answer round. Integer or string ?");
                
                String choice = sc.nextLine();
                
               if(choice.equals("integer") || choice.equals("Integer")){
                      q= new Integer_Question ();
                }
                else if(choice.equals("string") || choice.equals("String")){
                    q= new String_Question();
                    
                }
                else throw new InvalidTypeException("Enter either Integer or String");
                break;
            }
                catch (RuntimeException e){
                    System.out.println("Try again");
                }
            }
                q.Ask();
                Boolean res = q.Evaluate();
                if(!res){
                    System.out.println("Incorrect answer");
                    System.out.println("You didn't win a soft toy");
                    continue;
                }
            }
            System.out.printf("You won a %s soft toy\n" , soft.get_name());
            player.add_SoftToy(soft.clone());
            
        }
        
        catch(IndexOutOfBoundsException e){
           
            System.out.println("You are too energetic and zoomed past all the tiles. Muddy Puddle Splash!");
        }
        finally{
            i++;
           
        }
        
        
    }
    System.out.println("Game Over"); 
    player.DisplayToys(); 
    sc.close();





}
public static void set_soft_toys(){
//1
SoftToys.add(new soft_toy("Thor"));
//2
SoftToys.add(new soft_toy("Mickey Mouse"));
//3
SoftToys.add(new soft_toy("Donald Duck"));
//4
SoftToys.add(new soft_toy("Loki"));
//5
SoftToys.add(new soft_toy("Iron Man"));
//6
SoftToys.add(new soft_toy("Captain America"));
//7
SoftToys.add(new soft_toy("Ant Man"));
//8
SoftToys.add(new soft_toy("Spider Man"));
//9
SoftToys.add(new soft_toy("Doraemon"));
//10
SoftToys.add(new soft_toy("Black Widow"));
//11
SoftToys.add(new soft_toy("Jerry"));
//12
SoftToys.add(new soft_toy("Tom"));
//13
SoftToys.add(new soft_toy("winnie the pooh"));
//14
SoftToys.add(new soft_toy("Tigger"));
//15
SoftToys.add(new soft_toy("Smurf"));
//16
SoftToys.add(new soft_toy("Penguin"));
//17
SoftToys.add(new soft_toy("Flash"));
//18
SoftToys.add(new soft_toy("Batman"));
//19
SoftToys.add(new soft_toy("Spider Man"));
//20
SoftToys.add(new soft_toy("Wonder Woman"));


}
}
