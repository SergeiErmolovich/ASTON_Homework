public class Main {

    public static void main(String[] args) {

        System.out.println("*** Создаем массив котов, накладываем еды в миску и начинаем кормить ***");
        Cat[] cats = {new Cat("Барсик"), new Cat("Иннокентий"), new Cat("Рыжик"), new Cat("Мурзик"), new Cat("Феликс")};
        Cat.addFood(36);
        feedCats(cats);

        System.out.println("\n*** Докладываем еды и продолжаем кормить ***");
        Cat.addFood(57);
        feedCats(cats);

        System.out.println("\n*** Коты, проголодавшись, доедают то, что осталось в миске ***");
        starveCats(cats);
        feedCats(cats);

        System.out.println("\n*** Пускай наши коты теперь побегают и поплавают ***");
        for (int i = 0, j = 50; i < cats.length; i++, j += 53) {
            cats[i].run(j);
        }
        System.out.println();
        for (int i = 0, j = 5; i < cats.length; i++, j += 3) {
            cats[i].swim(j);
        }

        System.out.println("\n*** Создадим три собаки и выведем их на прогулку ***");
        Dog dog1 = new Dog("Бобик");
        Dog dog2 = new Dog("Шабик");
        Dog dog3 = new Dog("Мухтар");

        dog1.run(501);
        dog2.run(203);
        dog3.run(156);
        System.out.println();
        dog1.swim(12);
        dog2.swim(5);
        dog3.swim(7);

        System.out.println("\n*** Посчитаем сколько животных мы создали ***");
        animalCount();
    }

    public static void feedCats(Cat[] cats) {
        for (int i = 0; i < cats.length; i++) {
            cats[i].eat();
            if (cats[i].isFed()) {
                System.out.println(cats[i].getName() + " сыт.");
            } else System.out.println(cats[i].getName() + " остался голодным.");
        }
        System.out.println("В миске осталось " + Cat.bowl + " еды.");
    }

    public static void starveCats(Cat[] cats) {
        for (int i = 0; i < cats.length; i++) {
            cats[i].setFed(false);
        }
    }

    public static void animalCount() {
        System.out.println("Было создано " + Animal.count + " животных, из них:\nсобак - " + Dog.count + "\nкотов - " + Cat.count);
    }
}
