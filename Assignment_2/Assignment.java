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
        this.MaxMarks=Integer.parseInt(sc.nextLine());       
        this.Status=true;
    
    }
    public void grade(Instructor instructor){
        if(this.Submissions.isEmpty()){
            System.out.println("No submissions to grade ");
            return;
        }
        System.out.printf("Choose ID from these ungraded submissions\n");

        int i=0;
        
        for(Submission sub : this.Submissions){
            System.out.printf("%d. S%d \n",i,sub.getID());
            i++;
        }

        Submission sub = this.Submissions.get(Integer.parseInt(sc.nextLine()));
        this.Submissions.remove(sub);
        System.out.println("Submission: ");
        System.out.printf("Submission: %s\n" , sub.get_Answer());
    
        System.out.printf("Max Marks: %d \n",this.MaxMarks  );
        System.out.println("Enter Marks scored: ");
        sub.set_score(Integer.parseInt(sc.nextLine()));
        sub.set_graded(true); 
        sub.Grader(instructor.getusername());
             
    }
    public void close(){
        this.Status=false;
    }
    public boolean get_Status(){
        return this.Status;
    }
    @Override
    public void print() {
        System.out.printf("Assignment : %s Max Marks:%d\n" , this.problemStatement,this.MaxMarks);
        
    }
    @Override
    public void print_question() {
        
        System.out.println(this.problemStatement);
        System.out.println("Enter filename of assignment");
    }
    @Override
    public void add_Submission(Submission sub) {
      this.Submissions.add(sub);
    }
}
