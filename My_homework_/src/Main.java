public class Main {
    public static void main(String[] args) {

        NumberHelper numberHelper = new NumberHelper();

        System.out.println("\n\tTask 1");
        System.out.println(numberHelper.checkSum(5, 10));

        System.out.println("\n\tTask 2");
        numberHelper.checkNumberSign(5);

        System.out.println("\n\tTask 3");
        System.out.println(numberHelper.checkPosNegBool(3));

        System.out.println("\n\tTask 4");
        printStr("Всем привет!!! У меня получилось)))", 10);

        System.out.println("\n\tTask 5_1");
        System.out.println(leapYearBool(2024));

        System.out.println("\n\tTask 5_2");
        leapYear(2024);

        ArrayHelper arrayHelper = new ArrayHelper();

        System.out.println("\n\tTask 6");
        arrayHelper.changeArrayData();

        System.out.println("\n\n\tTask 7");
        arrayHelper.fillArray();

        System.out.println("\n\n\tTask 8");
        arrayHelper.fillArray2();

        System.out.println("\n\tTask 9");
        arrayHelper.createArray(10);

        System.out.println("\n\n\tTask 10");
        arrayHelper.printArrayInConsole(arrayHelper.retLenArr(10, 50));

    }

    // Task 4
    public static void printStr(String str, int a) {
        for (int i = 0; i < a; i++) {
            System.out.println(str);
        }
    }

    // Task 5_1. // Используем boolean, как в задании
    public static boolean leapYearBool(int year) {
        if (!(year % 4 == 0) || ((year % 100 == 0) && !(year % 400 == 0))) {
            return false;
        } else {
            return true;
        }
    }

    // Task 5_2. // Выводим в консоль строку без использования boolean
    public static void leapYear(int year) {
        if (!(year % 4 == 0) || ((year % 100 == 0) && !(year % 400 == 0))) {
            System.out.println(year + " г. не високосный");}
        else {
            System.out.println(year + " г. високосный");
        }
    }
}