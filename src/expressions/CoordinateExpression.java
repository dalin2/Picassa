package expressions;

import model.Model;

import model.RGBColor;

public class CoordinateExpression extends Expression {

	private String myCoordinate;
	
	public CoordinateExpression(String coordinate) {
		myCoordinate = coordinate;
	}
	
	public RGBColor evaluate() {
		if (myCoordinate.equals("x"))
        	return new RGBColor(Model.getEvalX());
        return new RGBColor(Model.getEvalY());
	}
	
}
