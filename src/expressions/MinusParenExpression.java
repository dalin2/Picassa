package expressions;

import java.util.ArrayList;

import model.RGBColor;
import model.util.ColorCombinations;

public class MinusParenExpression extends ParenthesesExpression {

	private ArrayList<Expression> myOperands = new ArrayList<Expression>();
	
	public MinusParenExpression(ArrayList<Expression> operands) { 
	    myOperands = operands;
	}
	
	public MinusParenExpression() { }
	
	public Expression returnExpression(ArrayList<Expression> operands) {
        return new MinusParenExpression(operands);
    }
	
	public RGBColor evaluate() {
		return ColorCombinations.subtract(myOperands.get(0).evaluate(), myOperands.get(1).evaluate());
	}
	
}
