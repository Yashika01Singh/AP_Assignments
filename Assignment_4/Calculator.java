
public class Calculator<T> {    
    public Object Calculate(T a, T b) {
       if( (a instanceof Integer ) && (b instanceof Integer))
        return (Integer)a/(Integer) b;
        if( (a instanceof String ) && (b instanceof String))
        return (String)a + (String)b;

     return null;
        
    }
  }


  
    /*
    public class InvalidTypeException extends RuntimeException { 
        public InvalidTypeException(String s) { 
        super(s);
        }
        }*/

    
    
