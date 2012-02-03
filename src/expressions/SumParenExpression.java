package expressions;

import java.util.ArrayList;

import model.RGBColor;
import model.util.ColorCombinations;

public class SumParenExpression extends ParenthesesExpression {
    
    private ArrayList<Expression> myOperands = new ArrayList<Expression>();

    public SumParenExpression(ArrayList<Expression> operands) { 
        myOperands = operands;
    }
    
    public SumParenExpression() { }
    
    public Expression returnExpression(ArrayList<Expression> operands) {
        return new SumParenExpression(operands);
    }
    
    public RGBColor evaluate() {
        ArrayList<RGBColor> evaluatedColors = new ArrayList<RGBColor>();
        for (Expression operand: myOperands) {
            evaluatedColors.add(operand.evaluate());
        }
        return ColorCombinations.sum(evaluatedColors);
    }
}
