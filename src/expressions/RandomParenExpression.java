package expressions;

import java.util.ArrayList;

import model.RGBColor;
import model.util.ColorCombinations;

public class RandomParenExpression extends ParenthesesExpression {
    
    public RandomParenExpression() { }
    
    public Expression returnExpression(ArrayList<Expression> operands) {
        return new RandomParenExpression();
    }
    
    public RGBColor evaluate() {
        return ColorCombinations.randomColor();
    }
}
