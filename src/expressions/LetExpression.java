package expressions;

import java.util.ArrayList;

import model.RGBColor;

public class LetExpression extends ParenthesesExpression {
    
    private VariableExpression myVariable;
    private Expression myVariableValue;
    private Expression myOperation;
    
    public LetExpression(ArrayList<Expression> operands) {
        myVariable = (VariableExpression) operands.get(0);
        myVariableValue = operands.get(1);
        myOperation = operands.get(2);
    }
    
    public LetExpression() { }
    
    public Expression returnExpression(ArrayList<Expression> operands) {
        return new LetExpression(operands);
    }

    public RGBColor evaluate() {
        VariableExpression.addToVariableMap(myVariable.getVariableName(), myVariableValue.evaluate());
        RGBColor evaluation = myOperation.evaluate();
        VariableExpression.removeFromVariableMap(myVariable.getVariableName());
        return evaluation;
    }
}
