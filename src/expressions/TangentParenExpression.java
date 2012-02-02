package expressions;

import java.util.ArrayList;

import model.RGBColor;
import model.util.ColorCombinations;

public class TangentParenExpression extends ParenthesesExpression {

    private ArrayList<Expression> myOperands = new ArrayList<Expression>();
    
    public TangentParenExpression(ArrayList<Expression> operands) { 
        myOperands = operands;
    }
    
    public TangentParenExpression() { }
    
    public Expression returnExpression(ArrayList<Expression> operands) {
        return new TangentParenExpression(operands);
    }
    
    public RGBColor evaluate() {
        return ColorCombinations.tangent(myOperands.get(0).evaluate());
    }
    
}
