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
            this.residualDistance = " метр.";
        else if ((Math.abs(distance) - MAX_RUN_DISTANCE) % 10 >= 2 && (Math.abs(distance) - MAX_RUN_DISTANCE) % 10 <= 4)
            this.residualDistance = " метра.";
        else this.residualDistance = " метров.";

        if (Math.abs(distance) % 10 == 1)
            this.totalDistance = " метр.";
        else if (Math.abs(distance) % 10 >= 2 && Math.abs(distance) % 10 <= 4)
            this.totalDistance = " метра.";
        else this.totalDistance = " метров.";

        if (Math.abs(distance) > MAX_RUN_DISTANCE)
            System.out.println(this.getName() + " устал и не добежал " + (Math.abs(distance) - MAX_RUN_DISTANCE) + this.residualDistance);
        else System.out.println(this.getName() + " пробежал " + Math.abs(distance) + this.totalDistance);
    }

    @Override
    public void swim(int distance) {
        if ((Math.abs(distance) - MAX_SWIM_DISTANCE) % 10 == 1)
            this.residualDistance = " метр.";
        else if ((Math.abs(distance) - MAX_SWIM_DISTANCE) % 10 >= 2 && (Math.abs(distance) - MAX_SWIM_DISTANCE) % 10 <= 4)
            this.residualDistance = " метра.";
        else this.residualDistance = " метров.";

        if (Math.abs(distance) % 10 == 1)
            this.totalDistance = " метр.";
        else if (Math.abs(distance) % 10 >= 2 && Math.abs(distance) % 10 <= 4)
            this.totalDistance = " метра.";
        else this.totalDistance = " метров.";

        if (Math.abs(distance) > MAX_SWIM_DISTANCE)
            System.out.println(this.getName() + " устал и не доплыл " + (Math.abs(distance) - MAX_SWIM_DISTANCE) + this.totalDistance);
        else System.out.println(this.getName() + " проплыл " + Math.abs(distance) + this.totalDistance);
    }

}
