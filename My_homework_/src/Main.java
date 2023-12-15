public class Main {

    // Task 1
    public static void printThreeWords() {
        System.out.println("Orange\nBanana\nApple");
    }

    // Task 2
    public static void checkSumSign() {
        int a = 1, b = -3;

        if (a + b >= 0) {
            System.out.println("\"Сумма положительная\"");
        }
        else {
            System.out.println("\"Сумма отрицательная\"");
        }
    }

    // Task 3
    public static void printColor() {
        int value = 1;

        if (value <= 0) {
            System.out.println("Красный");
        }
        else if (value <= 100) {
            System.out.println("Жёлтый");
        }
        else if (value > 100) {
            System.out.println("Зелёный");
        }
    }

    // Task 4
    public static void compareNumbers() {
        int a =3, b = 2;

        if (a >= b) {
            System.out.println("\"a >= b\"");
        }
        else {
            System.out.println("\"a < b\"");
        }
    }

    public static void main(String[] args) {
        System.out.println("\n\tTask 1");
        printThreeWords();

        System.out.println("\n\tTask 2");
        checkSumSign();

        System.out.println("\n\tTask 3");
        printColor();

        System.out.println("\n\tTask 4");
        compareNumbers();
    }
}