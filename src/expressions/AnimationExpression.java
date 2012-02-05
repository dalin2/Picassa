package expressions;

import model.Model;
import model.RGBColor;

public class AnimationExpression extends Expression {
    
    public AnimationExpression() { }
   
    public RGBColor evaluate() {
        return new RGBColor(Model.getEvalT());
    }
}
