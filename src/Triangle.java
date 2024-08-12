public class Triangle implements Figure {

    private double sideA;
    private double sideB;
    private double angleDegrees;
    private String outerColor;
    private String innerColor;

    public Triangle(double sideA, double sideB, double angleDegrees, String outerColor, String innerColor) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.angleDegrees = angleDegrees;
        this.outerColor = outerColor;
        this.innerColor = innerColor;
    }

    public Triangle(double sideA, double sideB, double angleDegrees) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.angleDegrees = angleDegrees;
    }

    @Override
    public double perimeter() {
        return sideA + sideB + Math.sqrt(Math.pow(sideA, 2) + Math.pow(sideB, 2) - 2 * sideA * sideB * Math.cos(Math.toRadians(angleDegrees)));
    }

    @Override
    public double area() {
        return sideA * sideB * Math.sin(Math.toRadians(angleDegrees)) / 2;
    }

    @Override
    public String toString() {
        if (outerColor == null)
            outerColor = "не задан";
        if (innerColor == null)
            innerColor = "не задан";
        return "Периметр произвольного треугольника - " + String.format("%.3f", perimeter()) + "\nЕго площадь - " + String.format("%.3f", area()) + "\nЦвет границ - " + outerColor + "\nЦвет заливки - " + innerColor;
    }

    public double getSideA() {
        return sideA;
    }

    public void setSideA(double sideA) {
        this.sideA = sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public void setSideB(double sideB) {
        this.sideB = sideB;
    }

    public double getAngleDegrees() {
        return angleDegrees;
    }

    public void setAngleDegrees(double angleDegrees) {
        this.angleDegrees = angleDegrees;
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
