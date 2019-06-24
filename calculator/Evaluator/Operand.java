package Evaluator;

public class Operand {
    int intValue; //make an int variable to store the operand
               //because operands are integers
               //we will use this to our benefit 
               //in the other constructors

  public Operand( String token ) {
      intValue = Integer.parseInt(token); //here we need to parse a string token 
                                          //to an integer, which will be the operand
  }

  public Operand( int value ) {
      intValue = value; 
  }

  public int getValue() {
      return intValue;
  }

  public static boolean check( String token ) { //boolean for string token  
      for (int i = 0; i < token.length(); i++){
          if (Character.isDigit(token.charAt(i))){
              return true;    
          }
      }
       return false;
  }
}
