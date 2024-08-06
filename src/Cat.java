public class Cat extends Animal {

    private static final int MAX_RUN_DISTANCE = 200;
    private static final int MEAL = 15;
    public static int count;
    public static int bowl;
    private boolean fed;
    private String totalDistance;
    private String residualDistance;

    @Override
    public void run(int distance) {
        if ((Math.abs(distance) - MAX_RUN_DISTANCE) % 10 == 1)
            residualDistance = " метр.";
        else if ((Math.abs(distance) - MAX_RUN_DISTANCE) % 10 >= 2 && (Math.abs(distance) - MAX_RUN_DISTANCE) % 10 <= 4)
            residualDistance = " метра.";
        else residualDistance = " метров.";

        if (Math.abs(distance) % 10 == 1)
            totalDistance = " метр.";
        else if (Math.abs(distance) % 10 >= 2 && Math.abs(distance) % 10 <= 4)
            totalDistance = " метра.";
        else totalDistance = " метров.";

        if (Math.abs(distance) > MAX_RUN_DISTANCE)
            System.out.println(getName() + " устал и не добежал " + (Math.abs(distance) - MAX_RUN_DISTANCE) + residualDistance);
        else System.out.println(getName() + " пробежал " + Math.abs(distance) + totalDistance);
    }

    @Override
    public void swim(int distance) {
        System.out.println(getName() + " не умеет плавать.");
    }

    public static void addFood(int amountOfFood) {
        bowl += amountOfFood;
    }

    public void eat() {
        if (!fed && bowl >= MEAL) {
            fed = true;
            bowl -= MEAL;
        }
    }

    public Cat(String name) {
        super(name);
        count++;
    }

    public boolean isFed() {
        return fed;
    }

    public void setFed(boolean fed) {
        this.fed = fed;
    }
}
