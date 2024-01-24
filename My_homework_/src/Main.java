import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();
        Apple apple4 = new Apple();
        Apple apple5 = new Apple();
        Apple apple6 = new Apple();

        Orange orange1 = new Orange();
        Orange orange2 = new Orange();
        Orange orange3 = new Orange();
        Orange orange4 = new Orange();

        Box<Apple> box1 = new Box<Apple>(apple1, apple2, apple3, apple4, apple5, apple6);
        Box<Orange> box2 = new Box<Orange>(orange1, orange2, orange3, orange4);

        System.out.printf("\nВес коробки с яблоками составляет \"%.1ff\"", box1.getWeight());
        System.out.printf("\nВес коробки с апельсинами составляет \"%.1ff\"\n", box2.getWeight());

        System.out.println("Вес коробок с яблоками и апельсинами равен: " + box1.compare(box2));

        Box<Orange> box3 = new Box<Orange>();
        box2.transfer(box3);

        System.out.printf("\nПосле последней манипуляции, вес коробки 2 (из которой пересыпали апельсины)" +
                " составляет \"%.1ff\"," + "\n" + "а коробки 3 (в которую их пересыпали) - \"%.1ff\"\n",
                box2.getWeight(), box3.getWeight());
    }
}