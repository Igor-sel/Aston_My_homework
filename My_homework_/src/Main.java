import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Сканнер для переменных сторон прямоугольника
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
    }
}