import java.util.stream.*;
import java.util.*;
import java.util.function.*;

public class Task1_Les9 {

    public static void SearchEvenNumbers() {

        // 1. Создаем массив данных из случайных чисел
        ArrayList<Integer> AL = new ArrayList<Integer>();
        int number;
        Random rnd = new Random();

        for (int i=0; i<20; i++) {
            number = rnd.nextInt() % 1000;
            AL.add(number);
        }

        System.out.println("Array AL:");
        System.out.println(AL);

        // 2. Определить количество четных чисел. Способ 1 - стандартный функциональный метод.
        // 2.1. Создать поток из массива AL - метод stream()
        Stream<Integer> st = AL.stream();

        // 2.2. Объявить ссылку на стандартный
        //      функциональный интерфейс Predicate<Integer>
        Predicate<Integer> fn; // эта ссылка будет передана в метод filter()

        // 2.3. Присвоить ссылке лямбда-выражение, которое определяет является ли число четным
        fn = (n) -> (n%2) == 0;

        // 2.4. Вызвать метод filter, который выберет только четные числа из потока st
        Stream<Integer> resStream = st.filter(fn);

        // 2.5. Вывести количество четных чисел
        System.out.println("\nКоличество четных чисел в массиве (метод 1) = " + resStream.count());

        // 3. Определить количество четных чисел. Способ 2 - используя Stream API
        int n2 = (int)(AL.stream().filter((n)->(n%2)==0)).count();
        System.out.println("Количество четных чисел в массиве (метод 2) = " + n2);
    }
}