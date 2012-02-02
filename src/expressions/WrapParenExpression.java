package expressions;

import java.util.ArrayList;

import model.RGBColor;

public class WrapParenExpression extends ParenthesesExpression {
    
    private ArrayList<Expression> myOperands = new ArrayList<Expression>();
    
    public WrapParenExpression(ArrayList<Expression> operands) { 
        myOperands = operands;
    }
    
    public WrapParenExpression() { }
    
    public Expression returnExpression(ArrayList<Expression> operands) {
        return new WrapParenExpression(operands);
    }
    
    public RGBColor evaluate() {
        RGBColor color = new RGBColor(myOperands.get(0).evaluate());
        color.wrap();
        return color;
    }
    
}
