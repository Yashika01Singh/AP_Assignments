public class Submission {
    private Student student;
    private String ans;
    private boolean Graded;
    //Graded is true when assignment is graded
    private int Score;
    private String grader;

    private Assessment assessment;
    Submission(Assessment assessment, Student student , String ans){
        this.student=student;
        this.ans=ans;
        this.Graded=false;
        this.assessment = assessment;    
    }
    public void set_score(int Score){
        this.Score=Score;
    }
    public void set_graded(Boolean bool){
        this.Graded=bool;
    }
    public boolean is_graded(){
        return this.Graded;
    }
    public void Grader(String grader){
        this.grader= grader;
    }
    public String get_Grader(){
        return this.grader;
    }
    public int get_score(){
        return this.Score;
    }
    public Assessment get_Assessment(){
        return this.assessment;
    }
    public int getID(){
        return this.student.getID();
    }
    public String get_Answer(){
        return this.ans;
    }
}
