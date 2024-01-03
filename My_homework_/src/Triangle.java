public class Triangle extends Shape implements IShape {

    private float a, b, c;

    public Triangle(float a, float b, float c, String lineColor, String fillColor) {
        super(lineColor, fillColor);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    //Формула для нахождения площади треугольника
    public float getArea() {
        float p = getPerimeter() / 2;
        return (float) Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    //Формула для нахождения периметра треугольника
    public float getPerimeter() {
        return a + b + c;
    }

    public String toString() {

        String info = "Triangle";
        info += " Area: " + getArea();
        info += " Perimeter: " + getPerimeter();
        info += " Line color: " + lineColor;
        info += " Fill color: " + fillColor;
        info += "\n";
        return info;
    }
}