import java.util.ArrayList;

public class Parser {
    public static ArrayList<ArrayList<String>> dataParser(ArrayList<String> fileContent) {
        ArrayList<ArrayList<String>> splitContent = new ArrayList<>();
        int count = 0;

        for (int i = 0; i < fileContent.size(); i = i + 4) {
            ArrayList<String> element = new ArrayList<>();
            System.out.println(i);
            for (int j = i; j < i + 3; j++) {
                element.add(fileContent.get(j));
            }
            splitContent.add(count, element);
            count++;
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
}
