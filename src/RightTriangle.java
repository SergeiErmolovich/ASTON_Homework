public class RightTriangle implements Figure {

    private double sideA;
    private double sideB;
    private String outerColor;
    private String innerColor;

    public RightTriangle(double sideA, double sideB, String outerColor, String innerColor) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.outerColor = outerColor;
        this.innerColor = innerColor;
    }

    public RightTriangle(double sideA, double sideB) {
        this.sideA = sideA;
        this.sideB = sideB;
    }

    @Override
    public double perimeter() {
        return sideA + sideB + Math.sqrt(Math.pow(sideA, 2) + Math.pow(sideB, 2));
    }

    @Override
    public double area() {
        return sideA * sideB / 2;
    }

    @Override
    public String toString() {
        if (outerColor == null)
            outerColor = "не задан";
        if (innerColor == null)
            innerColor = "не задан";
        return "Периметр прямоугольного треугольника - " + String.format("%.3f", perimeter()) + "\nЕго площадь - " + String.format("%.3f", area()) + "\nЦвет границ - " + outerColor + "\nЦвет заливки - " + innerColor;
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
