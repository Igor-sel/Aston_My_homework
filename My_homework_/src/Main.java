import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Animal[] animals = new Animal[7];
        animals[0] = new Cat("Барсик", 200, 0, 10, false);
        animals[1] = new Cat("Мурзик", 200, 0, 15, false);
        animals[2] = new Cat("Мурка", 200, 0, 10, false);
        animals[3] = new Cat("Майка", 200, 0, 15, false);
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
        int appetite = 10;
        boolean fullness = false;
        Cat cat = new Cat("Барсик", runLimit, swimLimit, appetite, fullness );

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
        System.out.println("\n****************\n");

        // Добавляем модуль кормление котов
        System.out.println("Приступаем к кормлению котиков");

        Cat[] cats = new Cat[4];
        cats[0] = new Cat("Барсик", 200, 0, 10, false);
        cats[1] = new Cat("Мурзик", 200, 0, 15, false);
        cats[2] = new Cat("Мурка", 200, 0, 10, false);
        cats[3] = new Cat("Майка", 200, 0, 15, false);

        Bowl bowl = new Bowl(40);
        bowl.info_1();
        for (int i = 0; i < cats.length; i++) {
            if (!cats[i].getFullness() && cats[i].getAppetite() <= bowl.food){
                cats[i].eat();
                bowl.decreaseFood(cats[i].getAppetite());
                System.out.println("Котик " + cats[i].getName() + " покушал!");
            } else {
                System.out.println("Котик " + cats[i].getName() + " остался голоден!");
            }
        }
        System.out.println("\n****************\n");

        bowl.info_2();
        System.out.println("Сколько граммов корма ещё добавить в миску?\n");
        int increaseFood = scanner.nextInt();
        bowl.increaseFood(increaseFood);
        bowl.info_3();

        System.out.println("\n****************\n");
    }
}