import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> fileContent = new ArrayList<>();
        ArrayList<File> listFiles = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        File file;
        String saisie;

        do {
            System.out.println("Veuillez entrer le chemin vers le fichier en entrée (Laissez la ligne vide si vous avez terminée votre saisie) :");
            saisie = scanner.nextLine();
            if(!saisie.isBlank()) {
                file = new File(saisie);
                if (file.exists())
                    listFiles.add(file);
                else
                    System.out.println("Erreur Le fichier saisie n'existe pas.");
            }
            else
                break;
        }while (!saisie.isBlank());

        //File file = new File("src\\main\\resources\\fichier_test.txt");
        System.out.println("Voulez-vous :");
        System.out.println("Taper 1 pour créer un fichier sortie pour chaque fichier entrée");
        System.out.println("Taper 2 pour regrouper les codes similaires");
        saisie = scanner.nextLine();

        if(saisie.equals("1")){
            for (File f: listFiles) {
                try {
                    scanner = new Scanner(f);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                while (scanner.hasNextLine()) {
                    fileContent.add(scanner.nextLine());
                }

                ArrayList<ArrayList<String>> dataParsed = UserStories.dataParser(fileContent);
                UserStories.WriteResult(dataParsed,f.getName().split("\\.")[0]);
            }
        }
        else if(saisie.equals("2")){

        }

    }
}
