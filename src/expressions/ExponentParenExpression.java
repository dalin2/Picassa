package expressions;

import java.util.ArrayList;

import model.RGBColor;
import model.util.ColorCombinations;

public class ExponentParenExpression extends ParenthesesExpression {

	private ArrayList<Expression> myOperands = new ArrayList<Expression>();
	
	public ExponentParenExpression(ArrayList<Expression> operands) { 
	    myOperands = operands;
	}
	
	public ExponentParenExpression() { }
	
	public Expression returnExpression(ArrayList<Expression> operands) {
        return new ExponentParenExpression(operands);
    }
	
	public RGBColor evaluate() {
		return ColorCombinations.exponent(myOperands.get(0).evaluate(), myOperands.get(1).evaluate());
	}
	
}
