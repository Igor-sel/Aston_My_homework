class Cat extends Animal implements IAnimal {
    private static int count;

    Cat(String name, double runLimit, double swimLimit) {
        super(name, runLimit, swimLimit);
        count++;
    }
    public static int getCount() {
        return count;
    }
}