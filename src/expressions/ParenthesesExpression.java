package expressions;

import java.util.ArrayList;

public abstract class ParenthesesExpression extends Expression {
	
    public abstract Expression returnExpression(ArrayList<Expression> operands);
}
