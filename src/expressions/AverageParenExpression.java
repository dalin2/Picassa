package expressions;
import java.util.ArrayList;

import model.RGBColor;
import model.util.ColorCombinations;


public class AverageParenExpression extends ParenthesesExpression {
    
    private ArrayList<Expression> myOperands = new ArrayList<Expression>();

    public AverageParenExpression(ArrayList<Expression> operands) { 
        myOperands = operands;
    }
    
    public AverageParenExpression() { }
    
    public Expression returnExpression(ArrayList<Expression> operands) {
        return new AverageParenExpression(operands);
    }
    
    public RGBColor evaluate() {
        ArrayList<RGBColor> evaluatedColors = new ArrayList<RGBColor>();
        for (Expression operand: myOperands) {
            evaluatedColors.add(operand.evaluate());
        }
        return ColorCombinations.average(evaluatedColors);
    }
}
