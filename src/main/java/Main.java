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
        while (scanner.hasNextLine()) {
            fileContent.add(scanner.nextLine());
        }

        ArrayList<ArrayList<String>> splitContent = Parser.dataParser(fileContent);
        ArrayList<ArrayList<String>> splitNumber = Parser.numberParser(splitContent.get(0));
        int[] numberValues = Parser.getNumberValues(splitNumber);

        for (ArrayList<String> content: splitContent) {
            System.out.println(content);
        }

        for (ArrayList<String> strings : splitNumber) {
            System.out.println(strings);
        }

        for (int value: numberValues) {
            System.out.print(value+"; ");
        }

//        for (ArrayList<String> strings : splitContent) {
//            for (int j = 0; j < strings.size(); j = j + 4) {
//                String firstLine = strings.get(j);
//                String secondLine = strings.get(j + 1);
//                String thirdLine = strings.get(j + 2);
//
//                String element = firstLine + secondLine + thirdLine;
//                System.out.println(converter.get(element));
//            }
//        }
    }
}
