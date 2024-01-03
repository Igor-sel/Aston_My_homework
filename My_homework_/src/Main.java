import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Animal[] animals = new Animal[7];
        animals[0] = new Cat("Барсик", 200, 0);
        animals[1] = new Cat("Мурзик", 200, 0);
        animals[2] = new Cat("Мурка", 200, 0);
        animals[3] = new Cat("Майка", 200, 0);
        animals[4] = new Dog("Тузик", 500, 10);
        animals[5] = new Dog("Шарик", 500, 10);
        animals[6] = new Dog("Мухтар", 500, 10);

        //Вывод общих результатов из данных класса;
        System.out.println("\nВсего котов: " + Cat.getCount());
        System.out.println("Всего собак: " + Dog.getCount());
        System.out.println("Всего животных: " + Animal.getCount() + "\n");

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