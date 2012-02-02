package expressions;

import java.util.ArrayList;

import model.RGBColor;
import model.util.ColorCombinations;

public class NegateParenExpression extends ParenthesesExpression {
	
	private ArrayList<Expression> myOperands = new ArrayList<Expression>();
	
	public NegateParenExpression(ArrayList<Expression> operands) { 
	    myOperands = operands;
	}
	
	public NegateParenExpression() { }
	
	public Expression returnExpression(ArrayList<Expression> operands) {
        return new NegateParenExpression(operands);
    }
	
	public RGBColor evaluate() {
		return ColorCombinations.negate(myOperands.get(0).evaluate());
	}

}
