import java.util.*;

public class Course {
    private Scanner sc = new Scanner(System.in);
    private ArrayList<Instructor>Instructors = new ArrayList<Instructor>() ;
    private ArrayList<Student>Students = new ArrayList<Student>() ;
    private ArrayList<Assessment>Assessments = new ArrayList<Assessment>() ;
    private ArrayList<CourseMaterial>CourseMaterials = new ArrayList<CourseMaterial>() ;
    private ArrayList<Comment>Comments = new ArrayList<Comment>() ;
    public void printInstructors(){
        int i=0;
        for(Instructor instructor : Instructors){
            System.out.printf("%d - I%d\n",i,instructor.getID());
            i++;
        }
    }
    public void printStudents(){
        int i=0;
        for(Student student : Students){
            System.out.printf("%d - S%d\n",i,student.getID());
            i++;
        }
    } 
    public void add_Instructor(){
        Instructors.add(new Instructor());
    }
    public void add_Student(){
        Students.add(new Student());
    }
    public Instructor get_Instructor(int id){
        return Instructors.get(id);
    }
    public Student get_Student(int id){
        return Students.get(id);
    }
    public void print_menu(User user){
        user.print_menu();
    }
    public boolean Execute(Instructor instructor , int op){

        if(op==1){
           Add_Class_Material(instructor);
        }
        if(op==2){
            Add_Assessment();
        }
        if(op==3){
            View_Lecture_Materials();
        }
        if(op==4){
            View_Assessment();
        }
        if(op==5){
            Grade_Assessment(instructor);
        }
        if(op==6){
            Close_Assessment();
        }
        if(op==7){
            View_comment();
        }
        if(op==8){
            Add_comment(instructor);
        }
        if(op>=9){
            return false;
        }

        return true;
    }
    public boolean Execute(User user , int op){
        return false;
    }
    public boolean Execute(Student student , int op){
        if(op==1){
            View_Lecture_Materials();
         }
        if(op==2){
            View_Assessment();
        }
        if(op==3){
            Submit_Assessment(student);
        }
        if(op==4){
            student.View_Grades();
        }
        if(op==5){
            View_comment();
        }
        if(op==6){
            Add_comment(student);
        }
        if(op>=7){
            return false;
        }
        return true;
    }
    private void Add_Class_Material(User user){
        System.out.println("1.Add Lecture Slide");
        System.out.println("2.Add Lecture Video");
        int ch = Integer.parseInt(sc.nextLine());
        if(ch==1){
            
            System.out.println("Enter topic of slides"); 
            String topic = sc.nextLine();
            System.out.println("Enter number of slides"); 
            int num =Integer.parseInt(sc.nextLine());
            ArrayList<String>slides = new ArrayList<String>();
            for(int i=0 ; i<num ;i++){
                System.out.printf("\nContent of slide %d:",i+1);
                String s =sc.nextLine() ;
                slides.add(s); 
            }
            Lecture_Slide lec = new Lecture_Slide(user,topic,slides);
            this.CourseMaterials.add(lec);            
        } 
        if(ch==2){
            System.out.println("Enter topic of video:");
            String topic=sc.nextLine();       
            System.out.println("Enter filename of video");
            String filename=sc.nextLine();
            if(filename.endsWith(".mp4"))
            {Lecture_Video lec = new Lecture_Video(user,topic,filename);
            this.CourseMaterials.add(lec);}
            else{
                System.out.println("Enter valid filename with .mp4 extension to upload lecture video");
            }
        }
    }
    private void Add_Assessment(){
        System.out.println("1.Add Assignment");
        System.out.println("2.Add Quiz");
        int ch = Integer.parseInt(sc.nextLine());
        if(ch==1){
            Assignment assign = new Assignment();
            this.Assessments.add(assign);            
        } 
        if(ch==2){
            Quiz q = new Quiz();
            this.Assessments.add(q);
        }
    }
    public void View_Lecture_Materials(){
        System.out.println("Course Materials ...");
        
        for (CourseMaterial material : CourseMaterials){
            material.print();
            System.out.println("\n\n");
        }
    }
    public void View_Assessment(){
       System.out.println("List of assessments");
       int i=0; 
        for (Assessment assm : Assessments){
            System.out.printf("ID: %d " ,i);
            
            assm.print();
            i++;
        }
    }
    public void Grade_Assessment(Instructor instructor){
        if(Assessments.isEmpty()){
            System.out.println("No assessments yet");
            return;
        }
        View_Assessment();
        //Enter check for no ungraded 
        System.out.println("\nEnter ID of assessment to view submissions");
        Assessment assem = Assessments.get(Integer.parseInt(sc.nextLine()));
        
        assem.grade(instructor);
    }
    public void Close_Assessment(){
        System.out.println("List of Open Assignments");
        int i=0;
        ArrayList<Assessment>OpenAssessments = new ArrayList<Assessment>() ; 
        for (Assessment assm : Assessments){
            if(assm.get_Status() ){
            System.out.printf("ID: %d " ,i);
            OpenAssessments.add(assm);
            assm.print();
            i++;
            }
            
        }
        if(OpenAssessments.isEmpty()){
            System.out.println("\nNo Open Assessments");
            return;
        }
        System.out.println("\nEnter ID of assessment to close");
        Assessment assem = OpenAssessments.get(Integer.parseInt(sc.nextLine()));
        
        assem.close();


    }
    public void Submit_Assessment(Student student){
        System.out.println("Pending assessments ");
        ArrayList<Assessment>PendingAssessments = new ArrayList<Assessment>() ; 
        int j=0;
        for (int i= 0 ; i<Assessments.size() ; i++){
            Assessment assm = Assessments.get(i);
            if(assm.get_Status() && student.Not_submitted(assm) ){
                System.out.printf("ID: %d " ,j);
                j++;
                assm.print(); 
                PendingAssessments.add(assm);
            }
        }
        if(PendingAssessments.isEmpty()){
            System.out.println("\nNone ---");
            return;
        }
        System.out.println("\nEnter ID of assessment");
        Assessment assem = PendingAssessments.get(Integer.parseInt(sc.nextLine()));
        assem.print_question();
        String ans = sc.nextLine();
        if(assem instanceof Assignment && ans.endsWith(".zip")==false){
            System.out.println("Invalid submission for assignment, .zip format required");
            return;
        }
        Submission sub = new Submission( assem ,student,ans);
        assem.add_Submission(sub);
        student.add_Submission(sub);


    }

    public void View_comment(){
        for (Comment comment : Comments){
            comment.print();
            System.out.println("\n");
        }
    }
    public void Add_comment(User user){
        Comment comment = new Comment(user);
        Comments.add(comment);
    }



}
