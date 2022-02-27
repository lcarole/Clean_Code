import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> fileContent = new ArrayList<>();
        File file = new File("src\\main\\resources\\fichier_test.txt");
        Scanner scanner = null;

        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (scanner != null) {
            while (scanner.hasNextLine()) {
                fileContent.add(scanner.nextLine());
            }
        }

        ArrayList<ArrayList<String>> dataParsed = UserStories.dataParser(fileContent);
        UserStories.WriteResult(dataParsed);

    }
}
