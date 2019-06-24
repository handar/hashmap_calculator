/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operators;

import java.lang.Math;
import Evaluator.Operand;

/**
 *
 * @author handa
 */
public class PowerOperator extends Operator {

    @Override
    public int priority() {
        return 4;
    }

    @Override
    public Operand execute(Operand op1, Operand op2) {
        int result = 1;
        for (int i = 1; i <= op2.getValue(); i++) {
            result *= op1.getValue();
        }
        Operand newOp = new Operand(result);
        return newOp;
    }
}
