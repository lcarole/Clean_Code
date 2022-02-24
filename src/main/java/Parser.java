import java.util.ArrayList;
import java.util.HashMap;

public class Parser {
    private static final HashMap<String, Integer> converter = createMap();

    private static HashMap<String, Integer> createMap() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put(
                " _ " +
                "| |" +
                "|_|", 0);
        map.put(
                "   " +
                "  |" +
                "  |", 1);
        map.put(
                " _ " +
                " _|" +
                "|_ ", 2);
        map.put(
                " _ " +
                " _|" +
                " _|", 3);
        map.put(
                "   " +
                "|_|" +
                "  |", 4);
        map.put(
                " _ " +
                "|_ " +
                " _|", 5);
        map.put(
                " _ " +
                "|_ " +
                "|_|", 6);
        map.put(
                " _ " +
                "  |" +
                "  |", 7);
        map.put(
                " _ " +
                "|_|" +
                "|_|", 8);
        map.put(
                " _ " +
                "|_|" +
                " _|", 9);
        return map;
    }

    public static ArrayList<ArrayList<String>> dataParser(ArrayList<String> fileContent) {
        ArrayList<ArrayList<String>> splitContent = new ArrayList<>();
        for (int i = 0; i < fileContent.size(); i = i + 4) {
            ArrayList<String> element = new ArrayList<>();
            for (int j = i; j < i + 3; j++) {
                element.add(fileContent.get(j));
            }
            splitContent.add(element);
        }
        return splitContent;
    }

    public static ArrayList<ArrayList<String>> numberParser(ArrayList<String> parameter) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        int count = 0;

        for (String strings : parameter) {
            ArrayList<String> element = new ArrayList<>();
            for (int j = 0; j < strings.length(); j = j + 3) {
                StringBuilder tmp = new StringBuilder();
                for (int k = j; k < j + 3; k++) {
                    tmp.append(strings.charAt(k));
                }
                element.add(tmp.toString());
            }
            result.add(count, element);
            count++;
        }

        return result;
    }

    public static int[] getNumberValues(ArrayList<ArrayList<String>> splitNumber) {
        int[] code = new int[9];
        for (int i = 0; i < 9; i++) {
            StringBuilder content = new StringBuilder();
            for (ArrayList<String> colonne: splitNumber) {
                content.append(colonne.get(i));
            }
            if(converter.get(content.toString()) != null)
                code[i] = converter.get(content.toString());
            else
                code[i] = -1;
        }
        return code;
    }
}
