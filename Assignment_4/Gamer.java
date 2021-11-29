import java.util.*;
public class Gamer {
    private static ArrayList<soft_toy>SoftToys= new ArrayList<soft_toy>() ;
    public void add_SoftToy(soft_toy s){
        SoftToys.add(s);
    }
    public void DisplayToys(){
       
    System.out.println("Soft toys won by you are:"); 
for(soft_toy ss : SoftToys){
   
   System.out.printf("%s, ",ss.get_name());
}
}
}
