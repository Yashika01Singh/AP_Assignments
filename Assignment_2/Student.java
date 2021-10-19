import java.util.*;
public class Student implements User{
    
    private static int number;
    private int id;
    private ArrayList<Submission>Submissions = new ArrayList<Submission>() ; 

    Student(){
        this.id = number;
        number++;
    }
    public int getID(){
        return this.id;
    }
    @Override
    public void print_menu(){
        
        System.out.println("1.View Lecture materials");
        System.out.println("2.view assessments");
        System.out.println("3.Submit assessments");
        System.out.println("4.VIew grades");
        System.out.println("5.view Comments ");
        System.out.println("6.Add Comments ");
        System.out.println("7.Logout");
        System.out.println("");        
    }
    public boolean Not_submitted(Assessment assm){
        boolean notsubmitted =true;
        for(Submission sub :this.Submissions){
            if(sub.get_Assessment().equals(assm)){
                notsubmitted=false;
                break;
            }
        }

        return notsubmitted;}
    public void add_Submission(Submission sub){
        Submissions.add(sub);
    }
    public void View_Grades(){
        ArrayList<Submission>GradedSubmissions = new ArrayList<Submission>() ;  
        ArrayList<Submission>UngradedSubmissions = new ArrayList<Submission>() ; 
        for(Submission sub :this.Submissions){
            if(sub.is_graded()){
                GradedSubmissions.add(sub);
            }
            else{

                UngradedSubmissions.add(sub);
            }
        }
        System.out.println("Graded submissions");
        for(Submission sub : GradedSubmissions){
            System.out.printf("Submission:%s\n" ,sub.get_Answer());
            System.out.printf("Marks scored:%d\nGraded by: %s \n",sub.get_score(),sub.get_Grader());

        }
        System.out.println("\n------------------\nUngraded submissions");
        for(Submission sub : UngradedSubmissions){
            System.out.printf("Submission:%s\n" ,sub.get_Answer());

        }


    }
    @Override
    public String getusername() {
        String s ="S"+this.id;
        return s;
    }
}
