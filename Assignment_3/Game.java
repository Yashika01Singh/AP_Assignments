import java.util.*;


public class Game {
    
    private static Dice die;
    private static Boolean chance =true;
    private static Player player;
    public static void main(String[] args){
        die = new Dice();
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the player name and hit enter");
        String Name = sc.nextLine();
        player = new Player(Name);
        System.out.printf("Welcome %s, Get ready to play Snakes and Ladders\n",Name);
        System.out.println("The game setup is ready");
        
        while(true){
            int pos=player.getpos(); 
            if(pos==13){
                System.out.println("Game is complete");
                
                player.printpoints();
                System.out.println("Thanks for playing");
                System.out.println("Press 0 to play again :");
                String again = sc.nextLine();
                if(again.equals("0")){
                    chance=true;
                    player.reset();
                    continue;
                }
                sc.close();
                return;
            }
            if(chance){
                System.out.println("Hit enter to roll the dice");   
                sc.nextLine();      
                int temp = pos+die.roll();
                if(pos==-1 && (temp!=0)){
                    System.out.println("Game cannot start till 1");
                    continue;}
    
                if(temp > 13)
                {System.out.println("Player cannot move");
                continue;
                }
                pos=temp;
                
            }
  //System.out.println(pos);
            player.updatepos(pos);
            Floor floor = getfloor(pos);
            
            player.updatepoints(floor.points());
            player.Display(floor);

            player.updatepos(floor.pos() + pos);
            

            
            }
        


        

    }
    public static Floor getfloor(int temp){
        chance=false;
        if(temp==2){
            
            return new Elevator();
        }
        if(temp==5){
            return new Snake();
        }
        if(temp==8){
            return new Ladder();
        }
        if(temp==11){
            return new KingKobra();
        }
        chance=true;
        return new EmptyFloor() ;
    }
}
