import java.util.*;
public class Dice {

    private Random rand;
    Dice(){
        this.rand = new Random();
    }
    public int roll(){
        int temp =1+rand.nextInt(2);
        System.out.printf("Dice gave ");
        System.out.println(temp);
        return temp;
    }
}
