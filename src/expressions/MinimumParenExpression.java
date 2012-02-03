package expressions;

import java.util.ArrayList;

import model.RGBColor;
import model.util.ColorCombinations;

public class MinimumParenExpression extends ParenthesesExpression {
    
    private ArrayList<Expression> myOperands = new ArrayList<Expression>();

    public MinimumParenExpression(ArrayList<Expression> operands) { 
        myOperands = operands;
    }
    
    public MinimumParenExpression() { }
    
    public Expression returnExpression(ArrayList<Expression> operands) {
        return new MinimumParenExpression(operands);
    }
    
    public RGBColor evaluate() {
        ArrayList<RGBColor> evaluatedColors = new ArrayList<RGBColor>();
        for (Expression operand: myOperands) {
            evaluatedColors.add(operand.evaluate());
        }
        return ColorCombinations.minimum(evaluatedColors);
    }
}
