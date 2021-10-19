import java.util.*;
public class Comment {
    private String statement;
    private String username;
    private java.util.Date date;
    private Scanner sc = new Scanner(System.in);
    Comment(User user){
        System.out.println("Enter comment");
        this.statement = sc.nextLine();
        this.username=user.getusername();
        this.date = new java.util.Date();

    }
    public void print(){
        System.out.printf("%s -%s \n",this.statement,this.username);
        System.out.println(this.date);

    }
}
