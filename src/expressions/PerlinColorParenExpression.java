package expressions;

import java.util.ArrayList;

import model.RGBColor;
import model.util.PerlinNoise;

public class PerlinColorParenExpression extends ParenthesesExpression {
    
    private ArrayList<Expression> myOperands = new ArrayList<Expression>();
    
    public PerlinColorParenExpression(ArrayList<Expression> operands) { 
        myOperands = operands;
    }
    
    public PerlinColorParenExpression() { }
    
    public Expression returnExpression(ArrayList<Expression> operands) {
        return new PerlinColorParenExpression(operands);
    }
    
    public RGBColor evaluate() {
        return PerlinNoise.colorNoise(myOperands.get(0).evaluate(), myOperands.get(1).evaluate());
    }
    
}
