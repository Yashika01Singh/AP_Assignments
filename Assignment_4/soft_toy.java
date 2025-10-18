public class soft_toy implements Cloneable {
   // public static void main()
   private String softtoy;
   soft_toy(String s){
      softtoy=s;
   }

   public soft_toy clone() 
   { try{
      soft_toy copy = (soft_toy) super.clone();
     return copy; 
   }
      catch (CloneNotSupportedException e){
         return null;
      }
   }

   public String get_name(){
      return this.softtoy;
   }

}
