import java.io.*;
import java.util.*;

public class App {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);

        
        System.out.println("Labeling Program");
        System.out.print("Enter the text file path of data: ");
        File inputFile = new File(input.next());
        input.nextLine();

        while (!inputFile.exists()) {
            System.out.print("File cannot be found, please try again");
            inputFile = new File(input.next());
            input.nextLine();

        }

        System.out.println("Found file \"" + inputFile + "\"");
        System.out.println("Enter end file name: ");
        File outputFile = new File(input.next());
        input.nextLine();

        boolean override = false;
        while (outputFile.exists() && !override) {
            System.out.println("This file exists, would you like to override it? (Y/N): ");
            char response = input.next().trim().toUpperCase().charAt(0);

            override = response == 'Y';

            if (!override) {
                System.out.println("Enter new end file name: ");
                outputFile = new File(input.next().trim());
            }
        }

        ProcessInput(inputFile, outputFile);

    }

    /** For Peter
     * 
     * @throws FileNotFoundException
     */
    public static void ProcessInput (File inputFile, File outputFile) throws FileNotFoundException {

        Scanner fileScnr = new Scanner(inputFile);
        PrintStream excelOutput = new PrintStream(outputFile);

        int indivNum = 0;

        while (fileScnr.hasNext()) {
            String input1 = scnr.nextLine();
            excelOutput.println(indivNum + " - " + input1);
            indivNum +=1;
        }

        fileScnr.close();
        excelOutput.close();

    }

    

}
