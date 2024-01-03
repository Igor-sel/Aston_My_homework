public class Circle extends Shape implements IShape {

    private float r;

    public Circle(float r, String lineColor, String fillColor) {
        super(lineColor, fillColor);
        this.r = r;
    }

    public float getArea() {
        return (float) (Math.PI * r * r);
    }

    public float getPerimeter() {
        return (float) (2 * Math.PI * r);
    }

    public String toString() {

        String info = "Circle";
        info += " Area: " + getArea();
        info += " Perimeter: " + getPerimeter();
        info += " Line color: " + lineColor;
        info += " Fill color: " + fillColor;
        info += "\n";
        return info;
    }
}