package expressions;

import model.Parser;

public abstract class ExpressionFactory {
	
	public abstract boolean isThisKindOfExpression(String input, int position);
		
	public abstract Expression parseExpression(Parser parser);
	
}
