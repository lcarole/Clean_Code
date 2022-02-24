import java.util.ArrayList;
import java.util.HashMap;

public class Parser {

    public HashMap<String,Integer> converter = new HashMap<>();

    public void initMap(){
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
    }
    public static ArrayList<ArrayList<String>> dataParser(ArrayList<String> fileContent) {
        ArrayList<ArrayList<String>> splitContent = new ArrayList<>();
        int count = 0;

        for (int i = 0; i < fileContent.size(); i = i + 4) {
            ArrayList<String> element = new ArrayList<>();
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
