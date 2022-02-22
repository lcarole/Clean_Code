import java.util.ArrayList;

public class Parser {
    public static ArrayList<ArrayList<String>> dataParser(ArrayList<String> fileContent) {
        ArrayList<ArrayList<String>> splitContent = new ArrayList<>();
        int compteur = 0;
        for (int i = 0; i < fileContent.size(); i = i + 4) {

            ArrayList<String> element = new ArrayList<>();

            for (int j = i; j < i + 3; j++) {
                element.add(fileContent.get(j));
                splitContent.add(compteur, element);
            }
            compteur++;
        }
        return splitContent;
    }

    public static ArrayList<ArrayList<String>> numberParser(ArrayList<String> parameter){
        int compteur = 0;
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        for (String strings : parameter) {
            ArrayList<String> element = new ArrayList<>();
            for (int j = 0; j < strings.length(); j = j + 3) {
                for (int k = 0; k < j + 3; k++) {
                    char c = strings.charAt(j);
                    element.add(String.valueOf(strings.charAt(j)));
                    result.add(compteur, element);
                }
                compteur++;
            }
        }
        return result;
    }
}
