package expressions;

import java.util.ArrayList;

import model.RGBColor;
import model.util.ColorCombinations;

public class LogarithmParenExpression extends ParenthesesExpression {

    private ArrayList<Expression> myOperands = new ArrayList<Expression>();
    
    public LogarithmParenExpression(ArrayList<Expression> operands) { 
        myOperands = operands;
    }
    
    public LogarithmParenExpression() { }
    
    public Expression returnExpression(ArrayList<Expression> operands) {
        return new LogarithmParenExpression(operands);
    }
    
    public RGBColor evaluate() {
        return ColorCombinations.logarithm(myOperands.get(0).evaluate());
    }
}
