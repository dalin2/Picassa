package model;

import java.util.ArrayList;



import expressions.VariableExpressionFactory;
import expressions.Expression;
import expressions.ExpressionFactory;
import expressions.NumberExpressionFactory;
import expressions.ParenthesesExpressionFactory;

/**
 * Parses a string into an expression tree based on rules for arithmetic.
 * 
 * Due to the nature of the language being parsed, a recursive descent parser 
 * is used 
 *   http://en.wikipedia.org/wiki/Recursive_descent_parser
 *   
 * @author former student solution
 * @author Robert C. Duvall (added comments, exceptions, some functions)
 */
public class Parser
{
    // state of the parser
    private int myCurrentPosition;
    private String myInput;
    
    public int getCurrentPosition() {
    	return myCurrentPosition;
    }
    
    public void setCurrentPosition(int position) {
    	myCurrentPosition = position;
    }
    
    public String getInput() {
    	return myInput;
    }
    	
    
    /**
     * Converts given string into expression tree.
     * 
     * @param input expression given in the language to be parsed
     * @return expression tree representing the given formula
     */
    public Expression makeExpression(String input)
    {
        myInput = input;
        myCurrentPosition = 0; //NEW LINE
        Expression result = parseExpression();
        skipWhiteSpace();
        if (notAtEndOfString())
        {
            throw new ParserException("Unexpected characters at end of the string: " +
                                      myInput.substring(myCurrentPosition),
                                      ParserException.Type.EXTRA_CHARACTERS);
        }
        return result;
    }

    public Expression parseExpression()
    {
       ArrayList<ExpressionFactory> kindsOfExpressions = new ArrayList<ExpressionFactory>();
       kindsOfExpressions.add(new ParenthesesExpressionFactory());
       kindsOfExpressions.add(new NumberExpressionFactory());
       kindsOfExpressions.add(new VariableExpressionFactory());
       skipWhiteSpace();
       
       for (ExpressionFactory expressionKind: kindsOfExpressions) {
    	   if (expressionKind.isThisKindOfExpression(myInput, myCurrentPosition)) {
    		   return expressionKind.parseExpression(this);
    	   }
       }
       throw new ParserException("Unexpected Character " + currentCharacter());
       
    }
 
    public void skipWhiteSpace ()
    {
        while (notAtEndOfString() && Character.isWhitespace(currentCharacter()))
        {
            myCurrentPosition++;
        }
    }

    public char currentCharacter ()
    {
        return myInput.charAt(myCurrentPosition);
    }

    public boolean notAtEndOfString ()
    {
        return myCurrentPosition < myInput.length();
    }
}
