package expressions;

import java.util.ArrayList;

import model.RGBColor;
import model.util.ColorCombinations;

public class ModulusParenExpression extends ParenthesesExpression {

	private ArrayList<Expression> myOperands = new ArrayList<Expression>();
	
	public ModulusParenExpression(ArrayList<Expression> operands) { 
	    myOperands = operands;
	}
	
	public ModulusParenExpression() { }
	
	public Expression returnExpression(ArrayList<Expression> operands) {
        return new ModulusParenExpression(operands);
    }
	
	public RGBColor evaluate() {
		return ColorCombinations.modulus(myOperands.get(0).evaluate(), myOperands.get(1).evaluate());
	}

}
