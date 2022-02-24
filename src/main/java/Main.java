import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> fileContent = new ArrayList<>();
        File file = new File("src\\main\\resources\\fichier_test.txt");
        //System.out.println(file.getAbsolutePath());
        Scanner scanner = null;

        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (scanner.hasNext()) {
            fileContent.add(scanner.nextLine());
        }

        ArrayList<ArrayList<String>> splitContent = Parser.dataParser(fileContent);
        ArrayList<ArrayList<String>> splitNumber = Parser.numberParser(splitContent.get(0));

        for (ArrayList<String> strings : splitNumber) {
            System.out.println(strings);
        }
    }
}
