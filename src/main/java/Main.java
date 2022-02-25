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
        while (scanner.hasNextLine()) {
            fileContent.add(scanner.nextLine());
        }

        ArrayList<ArrayList<String>> splitContent = Parser.dataParser(fileContent);
        /*ArrayList<ArrayList<String>> splitNumber = Parser.numberParser(splitContent.get(0));
        int[] numberValues = Parser.getNumberValues(splitNumber);*/

        PrintWriter sortie = null;
        try {
            sortie = new PrintWriter("src\\main\\resources\\sortie_resultat.txt", "UTF-8");
            for (ArrayList<String> content: splitContent) {
                ArrayList<ArrayList<String>> splitNumber = Parser.numberParser(content);
                int[] numberValues = Parser.getNumberValues(splitNumber);
                for (int i: numberValues) {
                    sortie.print(i);
                    System.out.print(i);
                }
                if(Parser.checksum(numberValues)){
                    sortie.print(" ERR");
                }
                sortie.println();
            }
            sortie.flush();
            sortie.close();
        } catch (IOException e) {
            System.out.println("\nErreur : "+e.getMessage());
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
