package expressions;

import java.util.ArrayList;

import model.RGBColor;
import model.util.ColorCombinations;

public class MultiplyParenExpression extends ParenthesesExpression {

	private ArrayList<Expression> myOperands = new ArrayList<Expression>();
	
	public MultiplyParenExpression(ArrayList<Expression> operands) { 
	    myOperands = operands;
	}
	
	public MultiplyParenExpression() { }
	
	public Expression returnExpression(ArrayList<Expression> operands) {
        return new MultiplyParenExpression(operands);
    }
	
	public RGBColor evaluate() {
		return ColorCombinations.multiply(myOperands.get(0).evaluate(), myOperands.get(1).evaluate());
	}
	
}
