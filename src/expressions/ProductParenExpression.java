package expressions;
import java.util.ArrayList;

import model.RGBColor;
import model.util.ColorCombinations;


public class ProductParenExpression extends ParenthesesExpression {
    
    private ArrayList<Expression> myOperands = new ArrayList<Expression>();

    public ProductParenExpression(ArrayList<Expression> operands) { 
        myOperands = operands;
    }
    
    public ProductParenExpression() { }
    
    public Expression returnExpression(ArrayList<Expression> operands) {
        return new ProductParenExpression(operands);
    }
    
    public RGBColor evaluate() {
        ArrayList<RGBColor> evaluatedColors = new ArrayList<RGBColor>();
        for (Expression operand: myOperands) {
            evaluatedColors.add(operand.evaluate());
        }
        return ColorCombinations.product(evaluatedColors);
    }
}
