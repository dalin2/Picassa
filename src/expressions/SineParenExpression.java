package expressions;

import java.util.ArrayList;

import model.RGBColor;
import model.util.ColorCombinations;

public class SineParenExpression extends ParenthesesExpression {

    private ArrayList<Expression> myOperands = new ArrayList<Expression>();
    
    public SineParenExpression(ArrayList<Expression> operands) { 
        myOperands = operands;
    }
    
    public SineParenExpression() { }
    
    public Expression returnExpression(ArrayList<Expression> operands) {
        return new SineParenExpression(operands);
    }
    
    public RGBColor evaluate() {
        return ColorCombinations.sine(myOperands.get(0).evaluate());
    }
    
}
