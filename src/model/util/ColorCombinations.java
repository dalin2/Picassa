package model.util;

import java.util.ArrayList;

import model.RGBColor;


/**
 * Combine two colors by combining their components.
 * 
 * This is a separate class from color since it is just one set of
 * ways to combine colors, many may exist and we do not want to keep
 * modifying the RGBColor class.
 * 
 * @author Robert C. Duvall
 */
public class ColorCombinations
{
    /**
     * Combine two colors by adding their components.
     */
    public static RGBColor add (RGBColor left, RGBColor right) {
        return new RGBColor(left.getRed() + right.getRed(), 
                            left.getGreen() + right.getGreen(),
                            left.getBlue() + right.getBlue());
    }
    
    public static RGBColor sum (ArrayList<RGBColor> colors) {
        double red = 0;
        double green = 0;
        double blue = 0;
        for (RGBColor color: colors) {
            red += color.getRed();
            green += color.getGreen();
            blue += color.getBlue();
        }
        return new RGBColor(red, green, blue);
    }

    /**
     * Combine two colors by subtracting their components.
     */
    public static RGBColor subtract (RGBColor left, RGBColor right) {
        return new RGBColor(left.getRed() - right.getRed(), 
                            left.getGreen() - right.getGreen(),
                            left.getBlue() - right.getBlue());
    }

    /**
     * Combine two colors by multiplying their components.
     */
    public static RGBColor multiply (RGBColor left, RGBColor right) {
        return new RGBColor(left.getRed() * right.getRed(), 
                            left.getGreen() * right.getGreen(),
                            left.getBlue() * right.getBlue());
    }
    
    public static RGBColor product (ArrayList<RGBColor> colors) {
        double red = 1;
        double green = 1;
        double blue = 1;
        for (RGBColor color: colors) {
            red *= color.getRed();
            green *= color.getGreen();
            blue *= color.getBlue();
        }
        return new RGBColor(red, green, blue);
    }

    /**
     * Combine two colors by dividing their components.
     */
    public static RGBColor divide (RGBColor left, RGBColor right) {
        return new RGBColor(left.getRed() / right.getRed(), 
                            left.getGreen() / right.getGreen(),
                            left.getBlue() / right.getBlue());
    }
    
    public static RGBColor modulus (RGBColor left, RGBColor right) {
    	return new RGBColor(left.getRed() % right.getRed(), 
                left.getGreen() % right.getGreen(),
                left.getBlue() % right.getBlue());
    }
    
    public static RGBColor exponent (RGBColor left, RGBColor right) {
    	return new RGBColor(Math.pow(left.getRed(), right.getRed()), 
                Math.pow(left.getGreen(), right.getGreen()),
                Math.pow(left.getBlue(), right.getBlue()));
    }
    
    public static RGBColor negate (RGBColor left) {
    	return new RGBColor(-left.getRed(),
    			            -left.getGreen(),
    			            -left.getBlue());
    }
    
    public static RGBColor color(RGBColor left, RGBColor right, RGBColor moreRight) {
    	return new RGBColor(left.getRed(),
    			            right.getGreen(),
    			            moreRight.getBlue());
    }
    
    public static RGBColor randomColor() {
        return new RGBColor(Math.random() - Math.random(), 
                Math.random() - Math.random(), 
                Math.random() - Math.random());
    }
    
    public static RGBColor floor(RGBColor left) {
        return new RGBColor(Math.floor(left.getRed()),
                Math.floor(left.getGreen()),
                Math.floor(left.getBlue()));
    }
    
    public static RGBColor ceiling(RGBColor left) {
        return new RGBColor(Math.ceil(left.getRed()),
                Math.ceil(left.getGreen()),
                Math.ceil(left.getBlue()));
    }
    
    public static RGBColor absoluteValue(RGBColor left) {
        return new RGBColor(Math.abs(left.getRed()),
                Math.abs(left.getGreen()),
                Math.abs(left.getBlue()));
    }
    
    public static RGBColor sine(RGBColor left) {
        return new RGBColor(Math.sin(left.getRed()),
                Math.sin(left.getGreen()),
                Math.sin(left.getBlue()));
    }
    
    public static RGBColor cosine(RGBColor left) {
        return new RGBColor(Math.cos(left.getRed()),
                Math.cos(left.getGreen()),
                Math.cos(left.getBlue()));
    }
    
    public static RGBColor tangent(RGBColor left) {
        return new RGBColor(Math.tan(left.getRed()),
                Math.tan(left.getGreen()),
                Math.tan(left.getBlue()));
    }
    
    public static RGBColor arcTangent(RGBColor left) {
        return new RGBColor(Math.atan(left.getRed()),
                Math.atan(left.getGreen()),
                Math.atan(left.getBlue()));
    }
    
    public static RGBColor logarithm(RGBColor left) {
        return new RGBColor(Math.log(left.getRed()),
                Math.log(left.getGreen()),
                Math.log(left.getBlue()));
    }
    
    public static RGBColor average(ArrayList<RGBColor> colors) {
        int length = colors.size();
        double red = 0;
        double green = 0;
        double blue = 0;
        for (RGBColor color: colors) {
            red += color.getRed();
            green += color.getGreen();
            blue += color.getBlue();
        }
        return new RGBColor(red/length, green/length, blue/length);
    }
    
    public static RGBColor minimum(ArrayList<RGBColor> colors) {
        RGBColor firstColor = colors.get(0);
        double minValue = firstColor.getRed() + firstColor.getGreen() + firstColor.getBlue();
        RGBColor minColor = firstColor;
        for (RGBColor color: colors) {
            double colorValue = color.getRed() + color.getGreen() + color.getBlue();
            if (colorValue < minValue) {
                minValue = colorValue;
                minColor = color;
            }
        }
        return minColor;
    }
    
    
    public static RGBColor maximum(ArrayList<RGBColor> colors) {
        RGBColor firstColor = colors.get(0);
        double maxValue = firstColor.getRed() + firstColor.getGreen() + firstColor.getBlue();
        RGBColor maxColor = firstColor;
        for (RGBColor color: colors) {
            double colorValue = color.getRed() + color.getGreen() + color.getBlue();
            if (colorValue > maxValue) {
                maxValue = colorValue;
                maxColor = color;
            }
        }
        return maxColor;
    }

}
