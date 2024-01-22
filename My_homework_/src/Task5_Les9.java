import java.util.stream.*;
import java.util.*;
import java.util.function.*;

public class Task5_Les9 {

    public static void InputShowLogins() {
        Scanner scanner = new Scanner(System.in);
        String s;
        ArrayList<String> ALL = new ArrayList<String>();
        System.out.println("Input login: ");
        while (true) {
            System.out.print("Login = ");
            s = scanner.nextLine();
            if (s.isEmpty())
                break;
            ALL.add(s);
        }
        System.out.println();
        System.out.println("Login List = " + ALL); // Выводим весь массив введенных логинов
        Predicate<String> fn;
        fn = (str) -> {
            return str.charAt(0) == 'f';
        }; // Определяем, что нам нужны логины, начинающиеся на 'f'
        Stream<String> stream = ALL.stream(); // Конвертируем массив в поток строк
        List<String> resStream = stream.filter(fn).collect(Collectors.toList()); // Получаем список, отфильтрованный по предикату
        for (String string : resStream) {
            System.out.println("The logins starting with \"f\"  = " + string); // Выводим все логины на "f"
        }
    }
}