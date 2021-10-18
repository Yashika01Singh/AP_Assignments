import java.util.*;

public class Assignment implements Assessment {
    private String problemStatement;
    private ArrayList<Submission>Submissions = new ArrayList<Submission>() ;

    private int MaxMarks;
    
    private boolean Status;
    
    private Scanner sc = new Scanner(System.in);
    Assignment(){
        System.out.println("Enter problem statement: ");
        this.problemStatement=sc.nextLine();
        System.out.println("Enter max marks: ");
        this.MaxMarks=sc.nextInt();
        
        this.Status=true;
    
    }
    public void grade(){
        System.out.printf("Choose ID from these ungraded submissions");
        int i=0;
        for(Submission sub : Submissions){
            System.out.printf("%d. S%d",i,sub.getID());
            i++;
        }
        Submission sub = Submissions.get(sc.nextInt());
        System.out.printf("Max Marks: %d",MaxMarks  );
        System.out.println("Enter Marks scored: ");
        sub.set_score(sc.nextInt());
        sub.set_graded(true);      
    }
    public void close(){
        this.Status=false;
    }
    public boolean get_Status(){
        return this.Status;
    }
    @Override
    public String print() {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public void print_question() {
        // TODO Auto-generated method stub
        System.out.println(problemStatement);
    }
    @Override
    public void add_Submission(Submission sub) {
        // TODO Auto-generated method stub
        
    }
}
