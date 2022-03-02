import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;

public class UserStories {
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

    public static int[] getNumbersValue(ArrayList<ArrayList<String>> splitNumber) {
        int[] code = new int[9];

        for (int i = 0; i < 9; i++) {
            StringBuilder content = new StringBuilder();
            for (ArrayList<String> colonne : splitNumber) {
                content.append(colonne.get(i));
            }
            if (converter.get(content.toString()) != null)
                code[i] = converter.get(content.toString());
            else
                code[i] = -1;
        }

        return code;
    }

    public static boolean checksum(int[] listNumber) {
        int result = 0;

        for (int i = 0; i < listNumber.length; i++) {
            if (listNumber[i] > 0) {
                result += listNumber[i] * (listNumber.length - i);
            }
        }

        return result % 11 == 0;
    }

    public static void WriteResult(ArrayList<ArrayList<String>> dataParsed,String inputFileName){
        try {
            PrintWriter output = new PrintWriter("src\\main\\resources\\"+inputFileName+"_result", StandardCharsets.UTF_8);

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

    public static void secondBehaviour(ArrayList<ArrayList<String>> dataParsed,String inputFileName){
        try {
            PrintWriter outputAuthorized = new PrintWriter("src\\main\\resources\\Authorized", StandardCharsets.UTF_8);
            PrintWriter outputErrored = new PrintWriter("src\\main\\resources\\Errored", StandardCharsets.UTF_8);
            PrintWriter outputUnknown = new PrintWriter("src\\main\\resources\\Unknown", StandardCharsets.UTF_8);
            for (ArrayList<String> content : dataParsed) {
                boolean isReadable = true;
                ArrayList<ArrayList<String>> numbersParsed = UserStories.numberParser(content);
                int[] numbersValue = UserStories.getNumbersValue(numbersParsed);
                StringBuilder result = new StringBuilder();
                for (int i : numbersValue) {
                    if (i > -1)
                        result.append(i);
                    else {
                        result.append("?");
                        isReadable = false;
                    }
                }

                if (!isReadable) {
                    outputUnknown.println(result +" ILL");
                }
                else if (UserStories.checksum(numbersValue)) {
                    outputErrored.println(result +" ERR");
                }
                else {
                    outputAuthorized.println(result);
                }
            }

            outputUnknown.flush();
            outputUnknown.close();
            outputErrored.flush();
            outputErrored.close();
            outputAuthorized.flush();
            outputAuthorized.close();
        }
        catch (IOException e) {
            System.out.println("\nErreur : " + e.getMessage());
        }
    }
}
