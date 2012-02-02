package expressions;

import java.util.ArrayList;

import model.RGBColor;
import model.util.ColorCombinations;


public class FloorParenExpression extends ParenthesesExpression {
    
    private ArrayList<Expression> myOperands = new ArrayList<Expression>();
    
    public FloorParenExpression(ArrayList<Expression> operands) { 
        myOperands = operands;
    }
    
    public FloorParenExpression() { }
    
    public Expression returnExpression(ArrayList<Expression> operands) {
        return new FloorParenExpression(operands);
    }
    
    public RGBColor evaluate() {
        return ColorCombinations.floor(myOperands.get(0).evaluate());
    }
}
