package expressions;

import java.util.ArrayList;

import model.RGBColor;
import model.util.ColorCombinations;

public class AbsoluteValueParenExpression extends ParenthesesExpression {

    private ArrayList<Expression> myOperands = new ArrayList<Expression>();
    
    public AbsoluteValueParenExpression(ArrayList<Expression> operands) { 
        myOperands = operands;
    }
    
    public AbsoluteValueParenExpression() { }
    
    public Expression returnExpression(ArrayList<Expression> operands) {
        return new AbsoluteValueParenExpression(operands);
    }
    
    public RGBColor evaluate() {
        return ColorCombinations.absoluteValue(myOperands.get(0).evaluate());
    }
    
}
