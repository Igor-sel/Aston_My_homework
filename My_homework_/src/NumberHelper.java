public class NumberHelper { //Для работы с числами создаем новый класс, размещаем здесь соответствующие методы

    // Task 1
    public boolean checkSum(int a, int b) {
        int c = a + b;
        return ((c >= 10) && (c <= 20)) ? true : false; // используем тернарный метод, сокращаем количество строк кода

        /*  // ниже вариант для конструкции if - else, без использования тернарного оператора

        if ((c >= 10) && (c <= 20)) { // вариант для конструкции if - else, без использования тернарного оператора
            return true;
        } else {
            return false;
        }
        */
    }

    // Task 2
    public void checkNumberSign(int a) { // далее используем тернарный метод
        String result = (a >= 0) ? "Число \"" + a + "\" положительное" : "Число \"" + a + "\" отрицательное";
        System.out.println(result);

        /* // ниже вариант для конструкции if - else, без использования тернарного оператора

        if (a >= 0) {
            System.out.println("Число \"" + a + "\" положительное");
        } else {
            System.out.println("Число \"" + a + "\" отрицательное");
        }
        */
    }

    // Task 3
    public boolean checkPosNegBool(int a) {
        return (a < 0) ? true : false;
    }
}
