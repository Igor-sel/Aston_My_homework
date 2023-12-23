public class Main {
    public static void main(String[] args) {
        System.out.println("\n\tTask 1");
        System.out.println(checkSumSign(5, 10));

        System.out.println("\n\tTask 2");
        checkPositiveNegative(-5);

        System.out.println("\n\tTask 3");
        System.out.println(checkPosNegBool(3));

        System.out.println("\n\tTask 4");
        printStr("Всем привет!!! У меня получилось)))", 10);

        System.out.println("\n\tTask 5");
        leapYear(2024);

        System.out.println("\n\tTask 6");
        int[] nums = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

    }

    // Task 1
    public static boolean checkSumSign(int a, int b) {
        int c;
        c = a + b;
        if ((c >= 10) && (c <= 20)) {
            return true;
        } else {
            return false;
        }
    }

    // Task 2
    public static void checkPositiveNegative(int a) {
        if (a >= 0) {
            System.out.println("Число \"" + a + "\" положительное");
        } else {
            System.out.println("Число \"" + a + "\" отрицательное");
        }
    }

    // Task 3
    public static boolean checkPosNegBool(int a) {
        if (a < 0) {
            return true;
        } else {
            return false;
        }
    }

    // Task 4
    public static void printStr(String str, int a) {
        for (int i = 0; i < a; i++) {
            System.out.println(str);
        }
    }

    // Task 5
    public static void leapYear(int year) {
        if (!(year % 4 == 0) || ((year % 100 == 0) && !(year % 400 == 0))) {
            System.out.println(year + " г. не високосный");}
        else {
            System.out.println(year + " г. високосный");
        }
    }
}