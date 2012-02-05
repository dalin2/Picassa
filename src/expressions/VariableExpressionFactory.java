package expressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.Parser;


public class VariableExpressionFactory extends ExpressionFactory {

	private static final Pattern  VARIABLE_REGEX =
		    	Pattern.compile("([a-z])+");
	
	public boolean isThisKindOfExpression(String input, int position) {
		Matcher coordinateMatcher = VARIABLE_REGEX.matcher(input.substring(position));
	    return coordinateMatcher.lookingAt();
	}
	
	public Expression parseExpression(Parser parser) {
		Matcher coordinateMatcher = VARIABLE_REGEX.matcher(parser.getInput());
        coordinateMatcher.find(parser.getCurrentPosition());
        String variableMatch =
            parser.getInput().substring(coordinateMatcher.start(), coordinateMatcher.end());
        parser.setCurrentPosition(coordinateMatcher.end());
        if (variableMatch.equals("x") || variableMatch.equals("y")) {
            return new CoordinateExpression(variableMatch);
        }
        else if (variableMatch.equals("t"))
            return new AnimationExpression();
        return new VariableExpression(variableMatch);
	}

}
