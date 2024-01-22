import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.*;

public class Task3_Les9 {

    public static void checkArray() {

        List<String> list = Arrays.asList("f10", "f15", "f2", "f4", "f4");

        list
                .stream()
                .sorted(
                        (e1, e2) -> {
                            String s1 = e1.substring(1);
                            String s2 = e2.substring(1);

                            return Integer.valueOf(s1).compareTo(Integer.valueOf(s2));
                        }
                ).forEach(System.out::println);
    }
}