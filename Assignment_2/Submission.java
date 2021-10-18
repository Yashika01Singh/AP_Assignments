public class Submission {
    private Student student;
    private String ans;
    private boolean Graded;
    //Graded is true when assignment is graded
    private int Score; 
    Submission(Student student , String ans){
        this.student=student;
        this.ans=ans;
        this.Graded=false;    
    }
    public void set_score(int Score){
        this.Score=Score;
    }
    public void set_graded(Boolean bool){
        this.Graded=bool;
    }
    public int getID(){
        return this.student.getID();
    }
}
