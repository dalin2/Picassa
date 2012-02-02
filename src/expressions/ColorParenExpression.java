package expressions;

import java.util.ArrayList;

import model.RGBColor;
import model.util.ColorCombinations;

public class ColorParenExpression extends ParenthesesExpression {

	private ArrayList<Expression> myOperands = new ArrayList<Expression>();
	
	public ColorParenExpression(ArrayList<Expression> operands) { 
	    myOperands = operands;
	}
	
	public ColorParenExpression() { }
	
	public Expression returnExpression(ArrayList<Expression> operands) {
        return new ColorParenExpression(operands);
    }
	
	public RGBColor evaluate() {
		return ColorCombinations.color(myOperands.get(0).evaluate(), myOperands.get(1).evaluate(), myOperands.get(2).evaluate());
	}
	
}
