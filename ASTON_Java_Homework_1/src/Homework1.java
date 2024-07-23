import java.util.Arrays;

public class Homework1 {
    public static void main(String[] args) {
        System.out.println("*** 1 ***");
        printThreeWords();

        System.out.println("*** 2 ***");
        checkSumSign();

        System.out.println("*** 3 ***");
        printColor();

        System.out.println("*** 4 ***");
        compareNumbers();

        System.out.println("*** 5 ***");
        if (rangeCheck(15, 9))
            System.out.println("Сумма лежит в пределах от 10 до 20");
        else System.out.println("Сумма не лежит в пределах от 10 до 20");

        System.out.println("*** 6 ***");
        positiveNumberCheck(-3);

        System.out.println("*** 7 ***");
        if (positiveNumberCheck2(-9))
            System.out.println("Число отрицательное");
        else System.out.println("Число положительное");

        System.out.println("*** 8 ***");
        printLine("Test Line", 4);

        System.out.println("*** 9 ***");
        if (yearCheck(800))
            System.out.println("Год високосный");
        else System.out.println("Год не високосный");

        System.out.println("*** 10 ***");
        int[] arrayZeroOne = {0, 1, 0, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1};
        System.out.println("Исходный массив\n" + Arrays.toString(arrayZeroOne));
        for (int i = 0; i < arrayZeroOne.length; i++) {
            if (arrayZeroOne[i] == 0)
                arrayZeroOne[i] = 1;
            else arrayZeroOne[i] = 0;
        }
        System.out.println("Массив после изменений\n" + Arrays.toString(arrayZeroOne));

        System.out.println("*** 11 ***");
        int[] arrayHundred = new int[100];
        for (int i = 0; i < arrayHundred.length; i++) {
            arrayHundred[i] = i + 1;
        }
        System.out.println(Arrays.toString(arrayHundred));

        System.out.println("*** 12 ***");
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Исходный массив\n" + Arrays.toString(array));
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6)
                array[i] *= 2;
        }
        System.out.println("Массив после изменений\n" + Arrays.toString(array));

        System.out.println("*** 13 ***");
        int[][] squareArray = new int[6][6];
        for (int i = 0; i < squareArray.length; i++) {
            for (int j = 0; j < squareArray.length; j++) {
                if (i == j) {
                    squareArray[i][j] = 1;
                    squareArray[i][squareArray.length - 1 - i] = 1;
                }
            }
        }
        for (int[] row : squareArray) {
            System.out.println(Arrays.toString(row));
        }

        System.out.println("*** 14 ***");
        System.out.println(Arrays.toString(createArray(7, 4)));
    }

    // 1
    public static void printThreeWords() {
        System.out.println("Orange\nBanana\nApple");
    }

    // 2
    public static void checkSumSign() {
        int a = 5;
        int b = -8;
        if ((a + b) >= 0)
            System.out.println("Сумма положительная");
        else System.out.println("Сумма отрицательная");
    }

    // 3
    public static void printColor() {
        int value = 255;
        if (value <= 0)
            System.out.println("Красный");
        else if (value > 0 && value <= 100)
            System.out.println("Желтый");
        else System.out.println("Зеленый");
    }

    // 4
    public static void compareNumbers() {
        int a = 8;
        int b = 3;
        if (a >= b)
            System.out.println("a >= b");
        else System.out.println("a < b");
    }

    // 5
    public static boolean rangeCheck(int a, int b) {
        if ((a + b) >= 10 && (a + b) <= 20)
            return true;
        else return false;

    }

    // 6
    public static void positiveNumberCheck(int a) {
        if (a >= 0)
            System.out.println("Число положительное");
        else System.out.println("Число отрицательное");
    }

    // 7
    public static boolean positiveNumberCheck2(int a) {
        if (a < 0)
            return true;
        else return false;
    }

    // 8
    public static void printLine(String line, int count) {
        for (int i = 0; i < Math.abs(count); i++) {
            System.out.println(line);
        }
    }

    // 9
    public static boolean yearCheck(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
            return true;
        else return false;
    }

    // 14
    public static int[] createArray(int len, int initialValue) {
        int[] array = new int[len];
        for (int i = 0; i < array.length; i++) {
            array[i] = initialValue;
        }
        return array;
    }
}
