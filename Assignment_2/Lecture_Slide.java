import java.util.*;

public class Lecture_Slide implements CourseMaterial{

    private String topic;
    private ArrayList<String>slides = new ArrayList<String>() ;
    
    private java.util.Date date;
    private User user;
    Lecture_Slide(User user ,String topic ,ArrayList<String> slides){
        this.user = user;
         
        this.topic = topic;
        this.slides=slides;
        
        this.date = new java.util.Date();
        }

    
    
    @Override
    public void print() {
        
        System.out.printf("Title: %s\n" , this.topic); 
        int i=0;
        for(String s : this.slides){
            System.out.printf("Slide %d: %s\n" , i+1 ,s);
            i++;
        }
        System.out.printf("Number of slides: %d \n" , i);
        System.out.printf("Date of upload : ");
        System.out.println(this.date);
        System.out.printf("Uploaded by: %s",user.getusername());

    }
}
