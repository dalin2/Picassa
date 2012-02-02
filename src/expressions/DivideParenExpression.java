package expressions;

import java.util.ArrayList;

import model.RGBColor;
import model.util.ColorCombinations;

public class DivideParenExpression extends ParenthesesExpression {
	
	private ArrayList<Expression> myOperands = new ArrayList<Expression>();
	
	public DivideParenExpression(ArrayList<Expression> operands) { 
	    myOperands = operands;
	}
	
	public DivideParenExpression() { }
	
	public Expression returnExpression(ArrayList<Expression> operands) {
        return new DivideParenExpression(operands);
    }
	
	public RGBColor evaluate() {
		return ColorCombinations.divide(myOperands.get(0).evaluate(), myOperands.get(1).evaluate());
	}
	
}
