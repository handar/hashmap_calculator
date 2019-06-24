package operators;

import java.util.HashMap;
import Evaluator.Operand;

public abstract class Operator {
    // The Operator class should contain an instance of a HashMap
    // This map will use keys as the tokens we're interested in,
    // and values will be instances of the Operators.
    // ALL subclasses of operator MUST be in their own file.
    // Example:
    // Where does this declaration go? What should its access level be?
    // Class or instance variable? Is this the right declaration?
    // HashMap operators = new HashMap();
    // operators.put( "+", new AdditionOperator() );
    // operators.put( "-", new SubtractionOperator() );

    private static HashMap<String, Operator> myOperator = new HashMap<>();

    public static Operator getOperator(String token) {
        Operator theOperator = myOperator.get(token);
        return theOperator;
    }

    static {
        myOperator.put("+", new AdditionOperator());
        myOperator.put("-", new SubtractionOperator());
        myOperator.put("*", new MultiplicationOperator());
        myOperator.put("/", new DivisionOperator());
        myOperator.put("^", new PowerOperator());
        myOperator.put("(", new OpenParOperator());
        myOperator.put(")", new RightParent());
    }

    public abstract int priority();

    public abstract Operand execute(Operand op1, Operand op2);

    public static boolean check(String token) {
        boolean check = token.matches("[-()*/^+]");

        return check;
    }
}
