import java.util.HashMap;
import java.util.Map;

public class TelephoneBook {
    public static Map<String, String> book = new HashMap<>();

    public static void add(String phone, String surname) {
        book.put(phone, surname);
    }

    public static void get(String surname) {
        boolean containsValue = false;
        for (String value : book.values()) {
            if (value.equalsIgnoreCase(surname)) {
                containsValue = true;
                break;
            }
        }
        if (containsValue) {
            System.out.println("Список телефонов по фамилии " + surname + ":");
            for (Map.Entry<String, String> entry : book.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (value.equalsIgnoreCase(surname)) {
                    System.out.println(key);
                }
            }
        } else System.out.println("Обонент с фамилией " + surname + " не найден.");
    }
}
