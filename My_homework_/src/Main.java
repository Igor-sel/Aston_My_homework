import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Задание 2. Сканнер для переменных сторон прямоугольника
        Scanner in = new Scanner(System.in);

        System.out.println("Введите длину прямоугольника: ");
        float a = in.nextFloat();
        System.out.println("Введите ширину прямоугольника: ");
        float b = in.nextFloat();

        Rectangle rec1 = new Rectangle(a, b, "Blue", "Green");

        System.out.println(rec1.toString());

        // Переменные по другим фигурам прописываю сразу в методе
        Triangle rec2 = new Triangle(3, 4, 5, "Black", "White");
        System.out.println(rec2.toString());

        Circle rec3 = new Circle (3, "Red", "Pink" );
        System.out.println(rec3.toString());

        // Пошло задание 1. Коты и собаки
        Scanner scanner = new Scanner(System.in);

        double runLimit = 200;
        double swimLimit = 0;
        Cat cat = new Cat("Барсик", runLimit, swimLimit );

        runLimit = 500;
        swimLimit = 10;
        Animal dog = new Dog("Шарик", runLimit, swimLimit);


        System.out.println("Кошка может пробежать: " + cat.getRunLimit() +
                " м. \nСобака может пробежать: " + dog.getRunLimit() + " м.");

        System.out.println("Введите дистанцию для бега:");
        double distance = scanner.nextDouble();

        System.out.println("Кошка пытается пробежать (" + distance + "). Результат: " + cat.canRun(distance));
        System.out.println("Собака пытается пробежать (" + distance + "). Результат: " + dog.canRun(distance));
        System.out.println("\n****************\n");

        System.out.println("Кошка может проплыть: " + cat.getSwimLimit() +
                " м. \nСобака может проплыть: " + dog.getSwimLimit() + " м.");

        System.out.println("Введите дистанцию для плавания:");
        distance = scanner.nextDouble();

        System.out.println("Кошка пытается проплыть (" + distance + "). Результат: " + cat.canSwim(distance));
        System.out.println("Собака пытается проплыть (" + distance + "). Результат: " + dog.canSwim(distance));

    }
}