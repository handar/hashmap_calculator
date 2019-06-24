/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operators;

import Evaluator.Operand;

/**
 *
 * @author handa
 */
public class SubtractionOperator extends Operator {

    @Override
    public int priority() {
        return 2;
    }

    @Override
    public Operand execute(Operand op1, Operand op2) {
        Operand difference = new Operand(op1.getValue() - op2.getValue());
        return difference;
    }

}
