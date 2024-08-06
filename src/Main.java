public class Main {
    public static void main(String[] args) {

        System.out.println("*** Создаем два прямоугольника и выводим информацию о них ***");
        Rectangle rectangle1 = new Rectangle(25.3, 26.785, "Красный", "Желтый");
        Rectangle rectangle2 = new Rectangle(87.145, 89.365);
        System.out.println(rectangle1);
        System.out.println();
        System.out.println(rectangle2);

        System.out.println("\n*** Создаем два круга и выводим информацию о них ***");
        Circle circle1 = new Circle(32.489, "Зеленый", "Черный");
        Circle circle2 = new Circle(52.677);
        System.out.println(circle1);
        System.out.println();
        System.out.println(circle2);

        System.out.println("\n*** Создаем два прямоугольных треугольника и выводим информацию о них ***");
        RightTriangle rightTriangle1 = new RightTriangle(32.2, 45.8);
        RightTriangle rightTriangle2 = new RightTriangle(85.523, 23.99, "Розовый", "Серый");
        System.out.println(rightTriangle1);
        System.out.println();
        System.out.println(rightTriangle2);

        System.out.println("\n*** Создаем два произвольных треугольника и выводим информацию о них ***");
        Triangle triangle1 = new Triangle(753.12, 561.456, 25.25);
        Triangle triangle2 = new Triangle(87.3, 52.4, 175.8, "Фиолетовый", "Голубой");
        System.out.println(triangle1);
        System.out.println();
        System.out.println(triangle2);
    }
}
