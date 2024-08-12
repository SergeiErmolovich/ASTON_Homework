public abstract class Animal {

    private String name;

    public static int count;

    public Animal(String name) {
        this.name = name;
        count++;
    }

    public abstract void run(int distance);

    public abstract void swim(int distance);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

