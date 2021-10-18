import java.util.*;

public class Classroom {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Course course = new Course();
        User user = null;
        int choice;
        int id,op;
        while(true){
        System.out.println("\nWelcome to Backpack");
        System.out.println("1.Enter as instructor");
        System.out.println("2.Enter as student");
        System.out.println("3.Exit");
        choice=sc.nextInt();
        
        if(choice==1){
           course.printInstructors();
           System.out.println("Choose id");
           id = sc.nextInt();
           user = (Instructor)course.get_Instructor(id);
           

            
        }
        if(choice==2){
            course.printStudents();
           System.out.println("Choose id");
           id = sc.nextInt();
           user = (Student)course.get_Student(id);
        }
        if(choice==3){
            break;
        }
        if(choice>3){
            System.out.println("Enter correct choice ");
            continue;
        }
        while(true){
            course.print_menu(user);
            op = sc.nextInt();
            Boolean conti = course.Execute(user , op) ;
            if(conti == false){
                continue;
            }
        }
        

        }
        sc.close();
    }
}
