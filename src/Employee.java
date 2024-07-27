public class Employee {
    private String name;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;
    private String years;

    public Employee(String name, String position, String email, String phone, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    @Override
    public String toString() {
        if ((age % 10 == 0) || (age % 10 >= 5 && age % 10 <= 9))
            years = "лет";
        else if (age % 10 == 1)
            years = "год";
        else years = "года";
        return name + ", должность: " + position + ", почта: " + email + ", телефон: " + phone + ", зарплата: " + salary + " рублей, возраст: " + age + " " + years;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}