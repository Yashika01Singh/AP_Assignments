import java.util.*;
public class String_Question implements Question{
    private String first;
    private String second;
    private Random rd = new Random();
    private Scanner sc = new Scanner(System.in);
    private String[] str = new String[]{"hi", "one","world", "bye","name","third","prize","abc","xyz"};
    private Calculator<String> cal = new Calculator<String>();
   @Override
    public void Ask(){
         // creating Random object
        first = str[rd.nextInt(9)];
        second = str[rd.nextInt(9)];
      System.out.printf("Calculate the concatenation of strings %s and %s \n",first,second);
    }
    @Override
    public boolean Evaluate(){
        String answer = sc.nextLine();
        String correct = (String)cal.Calculate(first, second);

        return answer.equals(correct);
    }
}
