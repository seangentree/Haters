import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Labeling Program");
        ProcessInput();
    }

    public static void ProcessInput () throws FileNotFoundException {

        String vandyText = "C:\\Users\\peter\\Downloads\\VandyHacks\\src\\DATA for VANDYHACKS_ActualFile.txt";
        File inputFile = new File(vandyText);
        Scanner scnr = new Scanner(inputFile);

        String fileOutput = "C:\\Users\\peter\\Downloads\\VandyHacks\\src\\Empty Sheet.txt";
        File outputFile = new File(fileOutput);
        PrintStream excelOutput = new PrintStream(outputFile);

        int indivNum = 0;

        while (scnr.hasNext()) {
            String input1 = scnr.nextLine();
            excelOutput.println(indivNum + " - " + input1);
            indivNum +=1;
        }

        scnr.close();
        excelOutput.close();

    }

}
