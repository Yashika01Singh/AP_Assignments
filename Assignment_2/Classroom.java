import java.util.*;

public class Classroom {
    
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        Course course = new Course();
        
        int choice;
        int id,op;
        course.add_Instructor();
        course.add_Instructor();
        course.add_Student();
        course.add_Student();
        course.add_Student();
        


        while(true){
        System.out.println("\nWelcome to Backpack");
        System.out.println("1.Enter as instructor");
        System.out.println("2.Enter as student");
        System.out.println("3.Exit");
        choice=Integer.parseInt(sc.nextLine());
        
        if(choice==1){
           course.printInstructors();
           System.out.println("Choose id");
           id = Integer.parseInt(sc.nextLine());
           Instructor user = course.get_Instructor(id);
           while(true){
            System.out.print("Welcome ");
            System.out.println(user.getusername());
            course.print_menu(user);
            op = Integer.parseInt(sc.nextLine());
            Boolean conti = course.Execute(user , op) ;
            if(conti == false){
                break;
            }
        }

           continue; 
        }
        if(choice==2){
            course.printStudents();
           System.out.println("Choose id");
           id = Integer.parseInt(sc.nextLine());
          Student user = course.get_Student(id);
          while(true){
            System.out.print("Welcome ");
            System.out.println(user.getusername());
            course.print_menu(user);
            op = Integer.parseInt(sc.nextLine());
            Boolean conti = course.Execute(user , op) ;
            if(conti == false){
                break;
                }
            
            }
            continue;
        }
        if(choice==3){
            break;
            }
        if(choice>3){
            System.out.println("Enter correct choice ");
            continue;
            }
        
        
        }
        
        sc.close();
    }
}
