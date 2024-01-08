public class Main {

    public static void main(String[] args) {
        String fileName = "D:\\MyData.csv";

        AppData data = CsvUtils.Load(fileName);

        CsvUtils.save(data, "D:\\MyData_new.csv");
    }
}