import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Employee[] employees = new Employee[5];

        employees[0] = new Employee("Иван Кныш", "Директор", "sloucheddog@gmail.com", "+375337852323", 2300, 30);
        employees[1] = new Employee("Николай Золин", "Принеси-подай", "kolyapopel@gmail.com", "+375337451325", 320, 21);
        employees[2] = new Employee("Влад Гук", "ИТ менеджер", "vladgukov@gmail.com", "+375298966558", 2100, 35);
        employees[3] = new Employee("Сергей Ермак", "Уборщик", "sergeiermak@gmail.com", "+375448520203", 800, 32);
        employees[4] = new Employee("Лариса Иванова", "Бухгалтер", "larisaivan@gmail.com", "+375447534589", 1500, 55);

        System.out.println("*** 1 ***");
        for (Employee employee : employees) {
            System.out.println(employee);
        }

        List<Park.Attraction> attractions = new ArrayList<>();
        attractions.add(new Park().new Attraction("Американские горки", 50, "10:30", "20:30"));
        attractions.add(new Park().new Attraction("Карусель", 20, "11:15", "19:45"));
        attractions.add(new Park().new Attraction("Тир", 15, "12:25", "21:55"));

        System.out.println("*** 2 ***");
        for (var attraction : attractions) {
            System.out.println(attraction);
        }
    }
}