package expressions;

import model.RGBColor;

public class NumberExpression extends Expression {

	private RGBColor myValue;
	
	public NumberExpression(RGBColor value) {
		myValue = value;
	}
	
	public RGBColor evaluate() {
		return myValue;
	}
	
}
