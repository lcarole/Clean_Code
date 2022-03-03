import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainTest {

    private ArrayList<String> fileContent;
    private File file;
    private Scanner scanner;

    @Before
    public void init() {
        this.fileContent = new ArrayList<>();
        this.file = new File("src\\main\\resources\\fichier_test.txt");
        this.scanner = null;

        try {
            this.scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (scanner.hasNextLine()) {
            fileContent.add(scanner.nextLine());
        }
    }

    //User Story 1 test
    @Test
    public void isFileSuccessfullyParsed() {
        ArrayList<ArrayList<String>> dataParsed = UserStories.dataParser(fileContent);
        Assert.assertEquals(dataParsed.size(), 4); //Changer taille attendue en fonction du nombre de données dans le fichier test
    }

    //User Story 2 test
    @Test
    public void isChecksumValid() {
        ArrayList<ArrayList<String>> dataParsed = UserStories.dataParser(fileContent);
        int[] numbersValue;
        ArrayList<ArrayList<String>> numbersParsed = UserStories.numberParser(dataParsed.get(0));
        numbersValue = UserStories.getNumbersValue(numbersParsed);
        Assert.assertTrue(UserStories.checksum(numbersValue));
    }

    //User Story 3 test
    @Test
    public void isResultFileValidForInvalidCode() throws IOException {
        ArrayList<String> fileContent = new ArrayList<>();
        File file = new File("src\\test\\resources\\user_story_3\\user_story_3_test_file.txt");
        try {
            this.scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (scanner.hasNextLine()) {
            fileContent.add(scanner.nextLine());
        }

        ArrayList<ArrayList<String>> dataParsed = UserStories.dataParser(fileContent);
        UserStories.writeResult(dataParsed, "fichier_test");

        String resultFile = "src\\main\\resources\\fichier_test_result";
        String expectedFile = "src\\test\\resources\\user_story_3\\user_story_3_expected_test_result";

        Assert.assertEquals(Files.readAllLines(Paths.get(resultFile), StandardCharsets.UTF_8),
                Files.readAllLines(Paths.get(expectedFile), StandardCharsets.UTF_8));
    }

    //User Story 4 test
    @Test
    public void isResultFileValidForUnreadableCode() throws IOException {
        ArrayList<String> fileContent = new ArrayList<>();
        File file = new File("src\\test\\resources\\user_story_4\\user_story_4_test_file.txt");
        try {
            this.scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (scanner.hasNextLine()) {
            fileContent.add(scanner.nextLine());
        }

        ArrayList<ArrayList<String>> dataParsed = UserStories.dataParser(fileContent);
        UserStories.writeResult(dataParsed, "fichier_test");

        String resultFile = "src\\main\\resources\\fichier_test_result";
        String expectedFile = "src\\test\\resources\\user_story_4\\user_story_4_expected_test_result";

        Assert.assertEquals(Files.readAllLines(Paths.get(resultFile), StandardCharsets.UTF_8),
                Files.readAllLines(Paths.get(expectedFile), StandardCharsets.UTF_8));
    }

    //User Story 5 test
    @Test
    public void isTheClassificationCorrect() throws IOException {
        ArrayList<ArrayList<String>> dataParsed = UserStories.dataParser(fileContent);
        UserStories.secondBehaviour(dataParsed, "fichier_test");

        String authorizedFile = "src\\main\\resources\\Authorized";
        String expectedAuthorizedFile = "src\\test\\resources\\user_story_5\\expected_Authorized_file";
        String erroredFile = "src\\main\\resources\\Errored";
        String expectedErroredFile = "src\\test\\resources\\user_story_5\\expected_Errored_file";
        String unknownFile = "src\\main\\resources\\Unknown";
        String expectedUnknownFile = "src\\test\\resources\\user_story_5\\expected_Unknown_file";

        Assert.assertEquals(Files.readAllLines(Paths.get(authorizedFile), StandardCharsets.UTF_8),
                Files.readAllLines(Paths.get(expectedAuthorizedFile)));
        Assert.assertEquals(Files.readAllLines(Paths.get(erroredFile), StandardCharsets.UTF_8),
                Files.readAllLines(Paths.get(expectedErroredFile), StandardCharsets.UTF_8));
        Assert.assertEquals(Files.readAllLines(Paths.get(unknownFile), StandardCharsets.UTF_8),
                Files.readAllLines(Paths.get(expectedUnknownFile), StandardCharsets.UTF_8));
    }
}
