package expressions;

import java.util.ArrayList;

import model.RGBColor;
import model.util.ColorCombinations;

public class PlusParenExpression extends ParenthesesExpression {
	
	private ArrayList<Expression> myOperands = new ArrayList<Expression>();

	public PlusParenExpression(ArrayList<Expression> operands) { 
	    myOperands = operands;
	}
	
	public PlusParenExpression() { }
	
	public Expression returnExpression(ArrayList<Expression> operands) {
        return new PlusParenExpression(operands);
    }
	
	public RGBColor evaluate() {
		return ColorCombinations.add(myOperands.get(0).evaluate(), myOperands.get(1).evaluate());
	}

}
