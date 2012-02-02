package expressions;

import java.util.ArrayList;

import model.RGBColor;
import model.util.ColorCombinations;

public class CeilingParenExpression extends ParenthesesExpression {

    private ArrayList<Expression> myOperands = new ArrayList<Expression>();
    
    public CeilingParenExpression(ArrayList<Expression> operands) { 
        myOperands = operands;
    }
    
    public CeilingParenExpression() { }
    
    public Expression returnExpression(ArrayList<Expression> operands) {
        return new CeilingParenExpression(operands);
    }
    
    public RGBColor evaluate() {
        return ColorCombinations.ceiling(myOperands.get(0).evaluate());
    }
    
}
