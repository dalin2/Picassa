package expressions;

import java.util.ArrayList;

import model.RGBColor;
import model.util.PerlinNoise;

public class PerlinBlackWhiteParenExpression extends ParenthesesExpression {

    private ArrayList<Expression> myOperands = new ArrayList<Expression>();
    
    public PerlinBlackWhiteParenExpression(ArrayList<Expression> operands) { 
        myOperands = operands;
    }
    
    public PerlinBlackWhiteParenExpression() { }
    
    public Expression returnExpression(ArrayList<Expression> operands) {
        return new PerlinBlackWhiteParenExpression(operands);
    }
    
    public RGBColor evaluate() {
        return PerlinNoise.greyNoise(myOperands.get(0).evaluate(), myOperands.get(1).evaluate());
    }
    
}
