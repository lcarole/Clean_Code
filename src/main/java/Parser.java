import java.util.ArrayList;

public class Parser {
    public static ArrayList<ArrayList<String>> dataParser(ArrayList<String> fileContent) {
        ArrayList<ArrayList<String>> splitContent = new ArrayList<>();
        int compteur = 0;
        int cnt = 0;
        for (int i = 0; i < fileContent.size(); i = i + 4) {
            ArrayList<String> element = new ArrayList<>();

            for (int j = i; j < i + 3; j++) {
                System.out.println(cnt);
                cnt++;
                element.add(fileContent.get(j));
                splitContent.add(compteur, element);
            }
            compteur++;
        }
        return splitContent;
    }

    public static ArrayList<ArrayList<String>> numberParser(ArrayList<String> parameter) {
        int compteur = 0;
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        for (String strings : parameter) {
            for (int j = 0; j < strings.length(); j = j + 3) {
                ArrayList<String> element = new ArrayList<>();
                StringBuilder tmp = new StringBuilder();
                for (int k = j; k < j + 3; k++) {
                    tmp.append(strings.charAt(k));
                }
                element.add(tmp.toString());
                result.add(compteur, element);
                compteur++;
            }
        }
        return result;
    }
}
