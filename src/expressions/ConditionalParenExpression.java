package expressions;

import java.util.ArrayList;


import model.RGBColor;

public class ConditionalParenExpression extends ParenthesesExpression {
    
    private ArrayList<Expression> myOperands = new ArrayList<Expression>();

    public ConditionalParenExpression(ArrayList<Expression> operands) { 
        myOperands = operands;
    }
    
    public ConditionalParenExpression() { }
    
    public Expression returnExpression(ArrayList<Expression> operands) {
        return new ConditionalParenExpression(operands);
    }
    
    public RGBColor evaluate() {
        RGBColor condition = myOperands.get(0).evaluate();
        double average = condition.getRed() + condition.getGreen() + condition.getBlue();
        return average > 0 ? myOperands.get(1).evaluate() : myOperands.get(2).evaluate();
    }
}
