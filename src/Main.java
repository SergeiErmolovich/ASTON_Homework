import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        System.out.println("Объявляем массив и иниализируем его дубликатами:");
        String[] constellations = {"Овен", "Телец", "Близнецы", "Рак",
                "Дева", "Скорпион", "Стрелец", "Водолей", "Рыбы",
                "Водолей", "Лев", "Скорпион", "Телец", "Стрелец",
                "Весы", "Лев", "Водолей", "Водолей", "Рыбы", "Овен"};
        for (int i = 0; i < constellations.length; i++) {
            System.out.print(constellations[i] + " ");
        }
        System.out.println();

        System.out.println("\nФильтруем массив с помощью HashSet:");
        HashSet<String> constellationsFiltered = new HashSet<>(Arrays.asList(constellations));
        System.out.println(constellationsFiltered);

        System.out.println("\nПодсчитываем, сколько раз повторяется каждый элемент массива с помощью HashMap:");
        Map<String, Integer> constellationsFrequency = new HashMap<>();
        for (String constellation : constellations) {
            if (constellationsFrequency.containsKey(constellation)) {
                constellationsFrequency.put(constellation, constellationsFrequency.get(constellation) + 1);
            } else {
                constellationsFrequency.put(constellation, 1);
            }
        }
        for (Map.Entry<String, Integer> entry : constellationsFrequency.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        System.out.println("\nДобавляем в справочник номера и ищем номера по фамилии:");
        TelephoneBook.add("+375295622325", "Смирнов");
        TelephoneBook.add("+375335894525", "Быков");
        TelephoneBook.add("+375254563125", "Климов");
        TelephoneBook.add("+375251472536", "Рогов");
        TelephoneBook.add("+375297831896", "Дукалис");
        TelephoneBook.add("+375338961280", "Плахов");
        TelephoneBook.add("+375258912573", "Климов");
        TelephoneBook.add("+375258935614", "Дукалис");
        TelephoneBook.add("+375254562874", "Быков");
        TelephoneBook.add("+375331257315", "Дукалис");

        TelephoneBook.get("Дукалис");
    }
}
