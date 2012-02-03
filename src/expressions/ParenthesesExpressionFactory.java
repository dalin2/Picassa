package expressions;

import java.util.ArrayList;


import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.Parser;
import model.ParserException;

public class ParenthesesExpressionFactory extends ExpressionFactory {
	
    private static final Map<String, ParenthesesExpression> commandToExpression 
                                      = new HashMap<String, ParenthesesExpression>();
    static {
        commandToExpression.put("color", new ColorParenExpression());
        commandToExpression.put("div", new DivideParenExpression());
        commandToExpression.put("/", new DivideParenExpression());
        commandToExpression.put("exp", new ExponentParenExpression());
        commandToExpression.put("^", new ExponentParenExpression());
        commandToExpression.put("minus", new MinusParenExpression());
        commandToExpression.put("-", new MinusParenExpression());
        commandToExpression.put("mod", new ModulusParenExpression());
        commandToExpression.put("%", new ModulusParenExpression());
        commandToExpression.put("mul", new MultiplyParenExpression());
        commandToExpression.put("*", new MultiplyParenExpression());
        commandToExpression.put("product", new ProductParenExpression());
        commandToExpression.put("neg", new NegateParenExpression());
        commandToExpression.put("!", new NegateParenExpression());
        commandToExpression.put("plus", new PlusParenExpression());
        commandToExpression.put("+", new PlusParenExpression());
        commandToExpression.put("sum", new SumParenExpression());
        commandToExpression.put("random", new RandomParenExpression());
        commandToExpression.put("floor", new FloorParenExpression());
        commandToExpression.put("ceil", new CeilingParenExpression());
        commandToExpression.put("abs", new AbsoluteValueParenExpression());
        commandToExpression.put("clamp", new ClampParenExpression());
        commandToExpression.put("wrap", new WrapParenExpression());
        commandToExpression.put("sin", new SineParenExpression());
        commandToExpression.put("cos", new CosineParenExpression());
        commandToExpression.put("tan", new TangentParenExpression());
        commandToExpression.put("atan", new ArcTangentParenExpression());
        commandToExpression.put("log", new LogarithmParenExpression());
        commandToExpression.put("rgbToYCrCb", new RGBToLuminanceParenExpression());
        commandToExpression.put("yCrCbtoRGB", new LuminanceToRGBParenExpression());
        commandToExpression.put("perlinColor", new PerlinColorParenExpression());
        commandToExpression.put("perlinBW", new PerlinBlackWhiteParenExpression());
        commandToExpression.put("let", new LetExpression());
        commandToExpression.put("average", new AverageParenExpression());
        commandToExpression.put("if", new ConditionalParenExpression());
        commandToExpression.put("min", new MinimumParenExpression());
        commandToExpression.put("max", new MaximumParenExpression());
    }
    
    // expression begins with a left paren followed by the command name, 
    // which is a sequence of alphabetic characters
    private static final Pattern EXPRESSION_BEGIN_REGEX =
        Pattern.compile("\\(([a-zA-Z\\+\\-\\/\\*\\^\\%\\!]+)");
                    
    public boolean isThisKindOfExpression(String input, int position) {
    	Matcher expMatcher = EXPRESSION_BEGIN_REGEX.matcher(input.substring(position));
    	return expMatcher.lookingAt();
    }
    
    public Expression parseExpression(Parser parser) {
        String commandName = getCommandNameAndSetPosition(parser);
        ArrayList<Expression> operands = getOperandExpressions(parser);
        if (parser.currentCharacter() == ')'){
            parser.setCurrentPosition(parser.getCurrentPosition() + 1);
            ParenthesesExpression expressionType = chooseExpressionType(commandName);
            return expressionType.returnExpression(operands);
        }
        else {
            throw new ParserException("Expected close paren, instead found " +
                                      parser.getInput().substring(parser.getCurrentPosition()));
        }

    }
    
    private String getCommandNameAndSetPosition(Parser parser) {
        Matcher expMatcher = EXPRESSION_BEGIN_REGEX.matcher(parser.getInput());
        expMatcher.find(parser.getCurrentPosition());
        String commandName = expMatcher.group(1);
        parser.setCurrentPosition(expMatcher.end());
        parser.skipWhiteSpace();
        return commandName;
    }
    
    private ArrayList<Expression> getOperandExpressions(Parser parser) {
        ArrayList<Expression> operands = new ArrayList<Expression>();
        while (parser.currentCharacter() != ')' && parser.notAtEndOfString()) {
            operands.add(parser.parseExpression());
            parser.skipWhiteSpace();
        }
        return operands;
    }
    
    private ParenthesesExpression chooseExpressionType(String commandName) {
    	if (commandToExpression.containsKey(commandName))
    		return commandToExpression.get(commandName);
    	throw new ParserException("Unexpected operator " + commandName, ParserException.Type.UNKNOWN_COMMAND);
    }
    
}
