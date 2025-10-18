import java.util.*;
public class Integer_Question implements Question{

    private Integer first;
    private Integer second;
    private Random rd = new Random();
    private Scanner sc = new Scanner(System.in);
    private Calculator<Integer> cal = new Calculator<Integer>();
    @Override
    public void Ask(){
         // creating Random object
        first = (rd.nextInt(10)+1) *1000;
        second = (rd.nextInt(10)+1) *100;
      System.out.printf("Calculate the result of %d divided by %d \n",first,second);
    }
    @Override
    public boolean Evaluate(){
        int answer;
        while(true){
          try{
            answer =Integer.parseInt(sc.nextLine());
            
            break;}
          catch (NumberFormatException e){
            System.out.println("Enter an integer");
            System.out.println("try Again");
            System.out.printf("Calculate the result of %d divided by %d \n",first,second);
          }
       }
        
        
        int correct = (Integer)cal.Calculate(first, second);

        return answer==correct;
    }
}
