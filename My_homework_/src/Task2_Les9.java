import java.util.Arrays;
import java.util.*;

public class Task2_Les9 {

    static List<String> list = Arrays.asList("Highload", "High", "Load", "Highload");

    // Cчитаем, сколько раз объект "High" встречается в коллекции:
    public static long countHigh() { return list.stream().filter("High"::equals).count(); }

    // Ищем первый элемент коллекции
    public static String outputFirstElement() {
        return list.stream().findFirst().orElse("0");
    }

    // Ищем последний элемент коллекции
    public static String outputLastElement() {
        return list.stream().skip(list.size() - 1).findFirst().orElse("0");
    }

    // Additional tasks.
    // С помощью метода skip. Ищем элементы по порядку. Например, пропускаем первых два и выводим третий:
    public static String outputAnyElement() { return list.stream().skip(2).findFirst().get(); }

    /*
    // Используем методы skip и limit. Указываем сколько элементов нужно пропустить, а сколько — вернуть.
    // Полученные значения собераем в массив:
    public static String makeArrayElements() { return list.stream().skip(1).limit(2).toArray(); }
        */
}