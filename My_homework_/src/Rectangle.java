public class Rectangle extends Shape implements IShape {

    private float a, b;

    public Rectangle(float a, float b, String lineColor, String fillColor ) {
        super(lineColor, fillColor);
        this.a = a;
        this.b = b;
    }
    //Формула для нахождения площади прямоугольника
    @Override
    public float getArea() {
        return a * b;
    }

    @Override
    public float getPerimeter() {
        return (a + b) * 2;
    }
    public String toString() {

        String info = "Rectangle";
        info += " Area: " + getArea();
        info += " Perimeter: " + getPerimeter();
        info += " Line color: " + lineColor;
        info += " Fill color: " + fillColor;
        info += "\n";
        return info;
    }
}