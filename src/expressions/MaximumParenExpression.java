package expressions;

import java.util.ArrayList;

import model.RGBColor;
import model.util.ColorCombinations;

public class MaximumParenExpression extends ParenthesesExpression {
    
    private ArrayList<Expression> myOperands = new ArrayList<Expression>();

    public MaximumParenExpression(ArrayList<Expression> operands) { 
        myOperands = operands;
    }
    
    public MaximumParenExpression() { }
    
    public Expression returnExpression(ArrayList<Expression> operands) {
        return new MaximumParenExpression(operands);
    }
    
    public RGBColor evaluate() {
        ArrayList<RGBColor> evaluatedColors = new ArrayList<RGBColor>();
        for (Expression operand: myOperands) {
            evaluatedColors.add(operand.evaluate());
        }
        return ColorCombinations.maximum(evaluatedColors);
    }
}
