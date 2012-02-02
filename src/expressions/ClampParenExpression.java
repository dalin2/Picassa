package expressions;

import java.util.ArrayList;

import model.RGBColor;

public class ClampParenExpression extends ParenthesesExpression {

    private ArrayList<Expression> myOperands = new ArrayList<Expression>();
    
    public ClampParenExpression(ArrayList<Expression> operands) { 
        myOperands = operands;
    }
    
    public ClampParenExpression() { }
    
    public Expression returnExpression(ArrayList<Expression> operands) {
        return new ClampParenExpression(operands);
    }
    
    public RGBColor evaluate() {
        RGBColor color = new RGBColor(myOperands.get(0).evaluate());
        color.clamp();
        return color;
    }
}
