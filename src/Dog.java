public class Dog extends Animal {

    private static final int MAX_RUN_DISTANCE = 500;
    private static final int MAX_SWIM_DISTANCE = 10;
    public static int count;
    private String totalDistance;
    private String residualDistance;

    public Dog(String name) {
        super(name);
        count++;
    }

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
        if ((Math.abs(distance) - MAX_SWIM_DISTANCE) % 10 == 1)
            residualDistance = " метр.";
        else if ((Math.abs(distance) - MAX_SWIM_DISTANCE) % 10 >= 2 && (Math.abs(distance) - MAX_SWIM_DISTANCE) % 10 <= 4)
            residualDistance = " метра.";
        else residualDistance = " метров.";

        if (Math.abs(distance) % 10 == 1)
            totalDistance = " метр.";
        else if (Math.abs(distance) % 10 >= 2 && Math.abs(distance) % 10 <= 4)
            totalDistance = " метра.";
        else totalDistance = " метров.";

        if (Math.abs(distance) > MAX_SWIM_DISTANCE)
            System.out.println(getName() + " устал и не доплыл " + (Math.abs(distance) - MAX_SWIM_DISTANCE) + totalDistance);
        else System.out.println(getName() + " проплыл " + Math.abs(distance) + totalDistance);
    }

}
