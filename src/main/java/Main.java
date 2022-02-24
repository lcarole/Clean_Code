import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HashMap<String,Integer> converter = new HashMap<>();

        converter.put(" _ | ||_|",0);
        converter.put("    |  | ",1);
        converter.put(" _  _||_ ",2);
        converter.put(" _  _| _|",3);
        converter.put("   |_|  |",4);
        converter.put(" _ |_  _|",5);
        converter.put(" _ |_ |_|",6);
        converter.put(" _   |  |",7);
        converter.put(" _ |_||_|",8);
        converter.put(" _ |_| _|",9);

        ArrayList<String> fileContent = new ArrayList<>();
        File file = new File("src\\main\\resources\\fichier_test.txt");
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

//        for (ArrayList<String> strings : splitNumber) {
//            System.out.println(strings);
//        }

        for (ArrayList<String> strings : splitContent) {
            for (int j = 0; j < strings.size(); j = j + 4) {
                String premiereLigne = strings.get(j);
                String secondeLigne = strings.get(j + 1);
                String troisiemeLigne = strings.get(j + 2);

                String element = premiereLigne + secondeLigne + troisiemeLigne;
                System.out.println(converter.get(element));
            }
        }
    }
}
