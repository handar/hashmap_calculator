package Evaluator;

import operators.Operator;
import java.util.*;
import operators.RightParent;

public class Evaluator {

    private Stack<Operand> operandStack;
    private Stack<Operator> operatorStack;

    private StringTokenizer tokenizer;

    private static final String DELIMITERS = "+-*^/()";

    public Evaluator() {
        operandStack = new Stack<>();
        operatorStack = new Stack<>();
    }

    public int eval(String expression) {
        String token;

        // The 3rd argument is true to indicate that the delimiters should be used
        // as tokens, too. But, we'll need to remember to filter out spaces.
        this.tokenizer = new StringTokenizer(expression, DELIMITERS, true);

        // initialize operator stack - necessary with operator priority schema
        // the priority of any operator in the operator stack other than
        // the usual mathematical operators - "+-*/" - should be less than the priority
        // of the usual operators
        // TODO Operator is abstract - this will need to be fixed:
        
        //push ")" to bottom of stack
        operatorStack.push(new RightParent());

        while (this.tokenizer.hasMoreTokens()) {
            // filter out spaces
            if (!(token = this.tokenizer.nextToken()).equals(" ")) {
                // check if token is an operand
                if (Operand.check(token)) {
                    operandStack.push(new Operand(token));
                } else {
                    if (!Operator.check(token)) {
                        System.out.println("**invalid token***");
                        throw new RuntimeException("*****invalid token******");
                    }
                    // TODO Operator is abstract - these two lines will need to be fixed:
                    // The Operator class should contain an instance of a HashMap,
                    // and values will be instances of the Operators.  See Operator class
                    // skeleton for an example.

                    Operator newOperator = Operator.getOperator(token);

                    //also enters when newOperator is a closed parenthesis 
                    while (operatorStack.peek().priority() >= newOperator.priority() || newOperator.priority() == -1) {

                        // note that when we eval the expression 1 - 2 we will
                        // push the 1 then the 2 and then do the subtraction operation
                        // This means that the first number to be popped is the
                        // second operand, not the first operand - see the following code
                        
                        //if newOperator is ")"
                        if (newOperator.priority() == -1) {

                            //while loop until the open parenthesis
                            while (operatorStack.peek().priority() != 1) {
                                Operator beforeOp = operatorStack.pop();
                                Operand op2 = operandStack.pop();
                                Operand op1 = operandStack.pop();
                                operandStack.push(beforeOp.execute(op1, op2));
                            }
                            
                            operatorStack.pop();
                            break;
                        } else if (newOperator.priority() == 1) {

                            //if newOperator is an open parenthesis, break 
                            break;
                        } else {
                            Operator oldOpr = operatorStack.pop();
                            Operand op2 = operandStack.pop();
                            Operand op1 = operandStack.pop();
                            operandStack.push(oldOpr.execute(op1, op2));
                        }

                    }

                    //push unless closed prenthesis
                    if (newOperator.priority() != -1) {
                        operatorStack.push(newOperator);
                    }

                }
            }
        }

    // Control gets here when we've picked up all of the tokens; you must add
    // code to complete the evaluation - consider how the code given here
    // will evaluate the expression 1+2*3
    // When we have no more tokens to scan, the operand stack will contain 1 2
    // and the operator stack will have + * with 2 and * on the top;
    // In order to complete the evaluation we must empty the stacks (except
    // the init operator on the operator stack); that is, we should keep
    // evaluating the operator stack until it only contains the init operator;
    // Suggestion: create a method that takes an operator as argument and
    // then executes the while loop.
    
        while ((!operatorStack.isEmpty()) && operatorStack.peek().priority() != -1) {  
            Operator resultOpr = operatorStack.pop();
            Operand op2 = operandStack.pop();
            Operand op1 = operandStack.pop();
            operandStack.push(resultOpr.execute(op1, op2));
        }

        return operandStack.pop().getValue();

    }
}
