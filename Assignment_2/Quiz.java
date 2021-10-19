import java.util.*;
public class Quiz implements Assessment {
    private String question;
    private Scanner sc = new Scanner(System.in);
    private Boolean Status;
    private int MaxMarks;
    private ArrayList<Submission>Submissions = new ArrayList<Submission>() ;

    Quiz(){
        System.out.println("Enter quiz question ");
        this.question=sc.nextLine();
        this.MaxMarks=1;
        this.Status=true;
     
    }

    @Override
    public void grade(Instructor instructor) {
        if(this.Submissions.isEmpty()){
            System.out.println("No submissions to grade ");
            return;
        }
        System.out.printf("Choose ID from these ungraded submissions\n");
        int i=0;
        for(Submission sub : this.Submissions){
            System.out.printf("%d. S%d",i,sub.getID());
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

    @Override
    public void close() {
        this.Status=false;
        
    }

    @Override
    public void print() {
        System.out.printf("Question : %s " , this.question);
    }

    @Override
    public boolean get_Status() {
        
        return this.Status;
    }

    @Override
    public void print_question() {
        System.out.println(this.question);
        
    }

    @Override
    public void add_Submission(Submission sub) {
        this.Submissions.add(sub);
      }
}
