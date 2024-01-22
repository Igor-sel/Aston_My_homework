public class Main {

    public static void main(String[] args) {

        System.out.println("\nTask_1****************"); // Task_1. Even numbers.
        Task1_Les9.SearchEvenNumbers();

        System.out.println("\nTask_2****************"); // Task_2. Collection "High ....".
        long a = Task2_Les9.countHigh();
        System.out.println("The object \"High\" is found in the collection \"" + a + "\" times");
        String first = Task2_Les9.outputFirstElement();
        System.out.println("First Element of collection is \"" + first + "\"");
        String last = Task2_Les9.outputLastElement();
        System.out.println("Last Element of collection is \"" + last + "\"");
        String any = Task2_Les9.outputAnyElement();
        System.out.println("This particular Element of collection is \"" + any + "\"");

        System.out.println("\nTask_3****************"); // Task_3. Collection "F4, F10 ....".
        Task3_Les9.checkArray();

        System.out.println("\nTask_4****************"); // Task_4. StudentCollection ....".
        double number = Task4_Les9.averageMenAge();
        System.out.printf("The average men age is \"%.1f\" years\n", number);
        String who = Task4_Les9.goToArmy();
        System.out.println("Who go to army!? - " + who);

        System.out.println("\nTask_5****************"); // Task_5. Login List ....".
        Task5_Les9.InputShowLogins();
    }
}