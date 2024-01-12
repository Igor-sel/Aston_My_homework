class Cat extends Animal implements IAnimal {
    private int appetite;
    private boolean fullness;
    private static int count;

    Cat(String name, double runLimit, double swimLimit, int appetite, boolean fullness) {
        super(name, runLimit, swimLimit);
        this.appetite = appetite;
        this.fullness = fullness;
        count++;
    }
    public void eat() {
        fullness = true;
    }

    public static int getCount() {
        return count;
    }
    public int getAppetite() { return appetite; }
    public boolean getFullness() {return fullness;}
}