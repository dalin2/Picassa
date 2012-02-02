package expressions;

import java.util.ArrayList;

import model.RGBColor;
import model.util.ColorCombinations;

public class CosineParenExpression extends ParenthesesExpression {

    private ArrayList<Expression> myOperands = new ArrayList<Expression>();
    
    public CosineParenExpression(ArrayList<Expression> operands) { 
        myOperands = operands;
    }
    
    public CosineParenExpression() { }
    
    public Expression returnExpression(ArrayList<Expression> operands) {
        return new CosineParenExpression(operands);
    }
    
    public RGBColor evaluate() {
        return ColorCombinations.cosine(myOperands.get(0).evaluate());
    }
}
