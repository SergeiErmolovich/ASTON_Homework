public class Main {

    public static int arrayElementsSum(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length != 4)
            throw new MyArraySizeException("Размер массива не 4x4");
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4)
                throw new MyArraySizeException("Размер массива не 4x4");
        }
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (!array[i][j].matches("\\d+"))
                    throw new MyArrayDataException("Элемент с индексом [" + i + "][" + j + "] содержит не только целочисленные значения");
                sum += Integer.parseInt(array[i][j]);
            }
        }
        return sum;
    }

    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {
        String[][] correctArray = {
                {"27", "87", "43", "21"},
                {"32", "12", "14", "52"},
                {"78", "67", "23", "50"},
                {"45", "45", "92", "74"}
        };

        String[][] wrongSizeArray = {
                {"27", "87", "43", "21"},
                {"32", "12", "14", "52"},
                {"78", "67", "23", "50"},
                {"45", "45", "74"}
        };

        String[][] wrongDataArray = {
                {"27", "87", "43", "21"},
                {"32", "12", "14", "52"},
                {"78", "67", "23", "50"},
                {"45", "45", "92", "семьдесят четыре"}
        };

        System.out.println(arrayElementsSum(correctArray));
    }
}
