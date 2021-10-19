
public class Lecture_Video implements CourseMaterial{
    private User user ;
    private String topic;
    private String filename;
    
    private java.util.Date date;
    Lecture_Video(User user ,String topic , String filename){
        this.user=user;
        
        this.topic=topic ;    
        
        this.filename=filename;
        this.date = new java.util.Date();
    }

    @Override
    public void print() {
        System.out.printf("Title of video: %s\n",this.topic);
        
        System.out.printf("Video file: %s\n" , this.filename);
        System.out.printf("Date of upload: ");
        System.out.println(this.date);
        System.out.printf("Uploaded by: %s",user.getusername());
        
    }
}
