import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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
    }

    @Test
    public void isFileSuccessfullyParsed() {
        try {
            this.scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (scanner.hasNextLine()) {
            fileContent.add(scanner.nextLine());
        }

        ArrayList<ArrayList<String>> dataParsed = UserStories.dataParser(fileContent);
        Assert.assertEquals(dataParsed.size(), 4); //Changer taille attendue en fonction du nombre de données dans le fichier test
    }
}
