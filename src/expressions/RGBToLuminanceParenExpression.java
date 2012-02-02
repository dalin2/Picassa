package expressions;

import java.util.ArrayList;

import model.RGBColor;
import model.util.ColorModel;

public class RGBToLuminanceParenExpression extends ParenthesesExpression {
    
    private ArrayList<Expression> myOperands = new ArrayList<Expression>();
    
    public RGBToLuminanceParenExpression(ArrayList<Expression> operands) { 
        myOperands = operands;
    }
    
    public RGBToLuminanceParenExpression() { }
    
    public Expression returnExpression(ArrayList<Expression> operands) {
        return new RGBToLuminanceParenExpression(operands);
    }
    
    public RGBColor evaluate() {
        return ColorModel.rgb2ycrcb(myOperands.get(0).evaluate());
    }
    
}
