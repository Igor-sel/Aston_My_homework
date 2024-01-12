public class Bowl {
    public int food;
    public Bowl(int food) {
        this.food = food;
    }
    public void decreaseFood(int n) {
        food -= n;
    }

    public void increaseFood(int x) {
        food += x;
    }
    public void info_1() {
        System.out.println("На начало кормления в миске " + food + " граммов корма.\n");
    }
    public void info_2() {
        System.out.println("По завершению кормления в миске осталось " + food + " граммов корма.");
    }
    public void info_3() {
        System.out.println("После нового наполнения миски в ней стало " + food + " граммов корма.");
    }
}