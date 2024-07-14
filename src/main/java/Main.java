import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Record {
    String name;
    int age;
    String occupation;

    Record(String name, int age, String occupation) {
        this.name = name;
        this.age = age;
        this.occupation = occupation;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Occupation: " + occupation;
    }
}

public class Main {

    public static List<Record> readExcel(String filePath) {
        List<Record> records = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isFirstLine = true;

            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                String[] values = line.split(";");

                if (values.length == 3) {
                    String name = values[0];
                    int age = Integer.parseInt(values[1]);
                    String occupation = values[2];
                    records.add(new Record(name, age, occupation));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return records;
    }

    public static void main(String[] args) {
        String filePath = "src\\main\\java\\data.csv";
        List<Record> records = readExcel(filePath);

        for (Record record : records) {
            System.out.println(record);
        }
    }
}
