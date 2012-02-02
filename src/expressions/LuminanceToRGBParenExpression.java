package expressions;

import java.util.ArrayList;

import model.RGBColor;
import model.util.ColorModel;

public class LuminanceToRGBParenExpression extends ParenthesesExpression {

    private ArrayList<Expression> myOperands = new ArrayList<Expression>();
    
    public LuminanceToRGBParenExpression(ArrayList<Expression> operands) { 
        myOperands = operands;
    }
    
    public LuminanceToRGBParenExpression() { }
    
    public Expression returnExpression(ArrayList<Expression> operands) {
        return new LuminanceToRGBParenExpression(operands);
    }
    
    public RGBColor evaluate() {
        return ColorModel.ycrcb2rgb(myOperands.get(0).evaluate());
    }
    
}
