import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
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
        PrintWriter output;

        try {
            output = new PrintWriter("src\\main\\resources\\sortie_resultat.txt", StandardCharsets.UTF_8);

            for (ArrayList<String> content : dataParsed) {
                boolean isReadable = true;
                ArrayList<ArrayList<String>> numbersParsed = UserStories.numberParser(content);
                int[] numbersValue = UserStories.getNumbersValue(numbersParsed);

                for (int i : numbersValue) {
                    if (i > -1)
                        output.print(i);
                    else {
                        output.print("?");
                        isReadable = false;
                    }
                }

                if (!isReadable)
                    output.println(" ILL");
                else if (UserStories.checksum(numbersValue))
                    output.println(" ERR");
                else
                    output.println();
            }

            output.flush();
            output.close();

        } catch (IOException e) {
            System.out.println("\nErreur : " + e.getMessage());
        }
    }
}
