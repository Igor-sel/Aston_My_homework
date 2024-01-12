public class Animal implements IAnimal {
    private String name;
    private final double runlimit, swimlimit;
    private static int count;

    Animal(String name, double runlimit, double swimlimit) {
        this.name = name;
        this.runlimit = runlimit;
        this.swimlimit = swimlimit;
        count++;
    }

    public String getName() { return name; }
    public static int getCount() {
        return count;
    }

    public boolean canRun(double value) {
        return runlimit > value;
    }

    public boolean canSwim(double value) {
        return swimlimit > value;
    }

    public double getRunLimit() {
        return runlimit;
    }

    public double getSwimLimit() {
        return swimlimit;
    }
}