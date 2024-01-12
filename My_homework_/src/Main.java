public class Main {

    public static void main(String[] args) {
        String fileName = "src/MyData.csv";
        String[] header = new String[]{"value1", "value2", "value3"};

        AppData data = CsvUtils.Load(fileName);

        data.setHeader(header);

        CsvUtils.save(data, fileName);
    }
}