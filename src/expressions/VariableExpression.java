package expressions;

import java.util.HashMap;
import java.util.Map;

import model.ParserException;
import model.RGBColor;

public class VariableExpression extends Expression {
    
    private String myVariableName;
    
    private static Map<String, RGBColor> variableToValue = new HashMap<String, RGBColor>();

    
    public VariableExpression(String variableName) {
        myVariableName = variableName;
    }
    
    public String getVariableName() {
        return myVariableName;
    }
    
    public static void addToVariableMap(String variableName, RGBColor variableValue) {
        variableToValue.put(variableName, variableValue);
    }
    
    public static void removeFromVariableMap(String variableName) {
        variableToValue.remove(variableName);
    }
    
    public RGBColor evaluate() {
        if (variableToValue.get(myVariableName) != null)
            return variableToValue.get(myVariableName);
        throw new ParserException("Unexpected variable " + myVariableName, ParserException.Type.UNKN0WN_VARIABLE);
    }
    
}
