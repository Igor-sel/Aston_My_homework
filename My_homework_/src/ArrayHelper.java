public class ArrayHelper { // Для работы с массивами создаем новый класс, размещаем здесь соответствующие методы

    // Task 6
    public void changeArrayData() {
        int[] arr = new int[]{1, 1, 0, 0, 1, 1, 0, 0, 0, 1};

        System.out.print("BEFORE: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
            if (arr[i] == 0) arr[i] = 1;
            else arr[i] = 0;
        }

        System.out.print("\nAFTER:  ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
    // Task 7
    public void fillArray() {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }

        System.out.print("Result: ");
        for (int i : array) {
            System.out.print(i + " "); // Данный оператор выводит данные в консоль в строку
            // System.out.println(array[i]); // Этот же всё сделает в столбик)
        }
    }
    // Task 8
    public void fillArray2() {
        int[] arr = new int[] { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        System.out.print("BEFORE: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.print("\nAFTER:  ");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) arr[i] *= 2;
            System.out.print(arr[i] + " ");
        }

    }

    // Task 9
    public void createArray(int length) {

        int[][] arr = new int[length][length];
        for (int i = 0; i < length; i++) { // данная конструкция подходит для массива, где количество строк
            arr[i][i] = 1;                 // и количество столбцов равны
            arr[i][length - 1 - i] = 1;

            /* for (int j = 0; j < length; j++) {          // если в массиве количество строк и стобцов различные,
                if ((i == j) || (i == length - 1 - j)) {   // необходимо использовать данную конструкцию
                    arr[i][j] = 1;
                }
            } */
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Task 10
    public int[] retLenArr (int len, int initialValue){
        int arr[] = new int[len];
        for (int i = 0; i < arr.length; i++){
            arr[i] = initialValue;
        }
        return arr;
    }
    public void printArrayInConsole(int[] inputArray) {
        for (int i = 0; i < inputArray.length; i++) {
            System.out.print(inputArray[i] + " ");
        }
        System.out.println();
    }
}