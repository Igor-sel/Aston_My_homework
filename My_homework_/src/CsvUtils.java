import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class CsvUtils {
    public static void save(AppData data, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {

            // Записываем заголовок
            writer.write(String.join(";", data.getHeader()));
            writer.write("\n");

            // Записываем данные
            for (int[] row : data.getData()) {
                for (int value : row) {
                    writer.write(Integer.toString(value));
                    writer.write(";");
                }
                writer.write("\n");
            }
            writer.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static AppData Load(String filePath) {
        AppData data = new AppData();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            // Читаем заголовок
            String headerLine = reader.readLine();
            String[] header = headerLine.split(";");
            data.setHeader(header);

            List<int[]> lines = new ArrayList<int[]>();

            // Читаем данные
            String line;

            while ((line = reader.readLine()) != null) {
                String[] values = line.split(";");
                int[] row = new int[values.length];
                for (int i = 0; i < values.length; i++) {
                    row[i] = Integer.parseInt(values[i]);
                }
                lines.add(row);
            }
            int[][] dataArr = new int[lines.size()][header.length];
            lines.toArray(dataArr);

            data.setData(dataArr);

        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}