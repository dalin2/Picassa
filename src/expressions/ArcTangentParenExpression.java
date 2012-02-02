package expressions;

import java.util.ArrayList;

import model.RGBColor;
import model.util.ColorCombinations;

public class ArcTangentParenExpression extends ParenthesesExpression {

    private ArrayList<Expression> myOperands = new ArrayList<Expression>();
    
    public ArcTangentParenExpression(ArrayList<Expression> operands) { 
        myOperands = operands;
    }
    
    public ArcTangentParenExpression() { }
    
    public Expression returnExpression(ArrayList<Expression> operands) {
        return new ArcTangentParenExpression(operands);
    }
    
    public RGBColor evaluate() {
        return ColorCombinations.arcTangent(myOperands.get(0).evaluate());
    }
    
}
