public interface Assessment {
   public void grade(Instructor instructor);
   public void close();
   public void print();
   public boolean get_Status();
   public void print_question();
   public void add_Submission(Submission sub);
   
}
