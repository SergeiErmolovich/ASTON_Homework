public class Circle implements Figure {

    private double radius;
    private String outerColor;
    private String innerColor;

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public String toString() {
        if (outerColor == null)
            outerColor = "не задан";
        if (innerColor == null)
            innerColor = "не задан";
        return "Длина окружности - " + String.format("%.3f", perimeter()) + "\nЕго площадь - " + String.format("%.3f", area()) + "\nЦвет границ - " + outerColor + "\nЦвет заливки - " + innerColor;
    }

    public Circle(double radius, String outerColor, String innerColor) {
        this.radius = radius;
        this.outerColor = outerColor;
        this.innerColor = innerColor;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getOuterColor() {
        return outerColor;
    }

    public void setOuterColor(String outerColor) {
        this.outerColor = outerColor;
    }

    public String getInnerColor() {
        return innerColor;
    }

    public void setInnerColor(String innerColor) {
        this.innerColor = innerColor;
    }
}
