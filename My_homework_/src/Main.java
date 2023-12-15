public class Main {

    // Task 1
    public static void printThreeWords() {
        System.out.println("Orange\nBanana\nApple");
    }

    //Task 2
    public static void checkSumSign() {
        int a = 1, b = -3;

        if (a + b >= 0) {
            System.out.println("Сумма положительная");

        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void main(String[] args) {
        printThreeWords();
        System.out.println();

        checkSumSign();
        System.out.println();
    }
}