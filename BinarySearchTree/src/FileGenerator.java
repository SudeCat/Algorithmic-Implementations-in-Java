import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class FileGenerator {
    public static void main(String[] args) {
        generateFile("./src/Source.txt", 10000);
        generateFile("./src/Search.txt", 10000);
    }

    private static void generateFile(String fileName, int numberOfValues) {
        try (FileWriter writer = new FileWriter(fileName)) {
            Random random = new Random();
            for (int i = 0; i < numberOfValues; i++) {
                int value = random.nextInt(100);
                writer.write(value + ",");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
