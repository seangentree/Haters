import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws FileNotFoundException {

        // This establishes the general scanner for the user input

        Scanner input = new Scanner(System.in);

        // This prompts the user for the text file path of the patient profiles
        
        System.out.println("Labeling Program\n");
        System.out.print("Enter the text file path of input data: ");
        File inputFile = new File(input.nextLine().replace("\"", " ").trim());

        // This reprompts the user for a file path if the input file is not found

        while (!inputFile.exists()) {
            System.out.print("File cannot be found, please try again: ");
            inputFile = new File(input.nextLine().replace("\"", " ").trim());
        }

        // This prompts the user for the output file with the patient numbers

        System.out.println("Found file \"" + inputFile + "\"");
        System.out.print("Enter end file name: ");
        File outputFile = new File(input.nextLine().replace("\"", " ").trim());

        // Check if the user would like to override an already existing file

        boolean override = false;
        while (outputFile.exists() && !override) {
            System.out.print("This file exists, would you like to override it? (Y/N): ");
            char response = input.nextLine().trim().toUpperCase().charAt(0);

            override = response == 'Y';

            if (!override) {
                System.out.print("Enter new end file name: ");
                outputFile = new File(input.nextLine().replace("\"", " ").trim());
            }

        }

        ProcessInput(inputFile, outputFile, input);

        input.close();

    }

    /**
     *  This method processes input file of patients names and assigns them ID values
     * @param inputFile is the file with the patient profiles
     * @param outputFile is the file with the new patient IDs/numbers
     * @throws FileNotFoundException
     */

    public static void ProcessInput (File inputFile, File outputFile, Scanner input) throws FileNotFoundException {

        Scanner fileScnr = new Scanner(inputFile);
        PrintStream excelOutput = new PrintStream(outputFile);

        // This number is just a random arbitrary patient number

        int indivNum = 6000000;

        // This scanner goes through the inputFile and outputs the ID wth the patient profile

        while (fileScnr.hasNext()) {
            String input1 = fileScnr.nextLine();
            excelOutput.println(indivNum + " - " + input1);
            indivNum +=1;
        }

        fileScnr.close();
        excelOutput.close();

        // This calls the next printResult method

        printResult(outputFile, input);

    }

    /**
     * This method assigns the patient numbers with the correct drug prescription
     * @param idList is the list of patient numbers with patient profile
     * @param consoleInput is the Scanner for userInput
     * @throws FileNotFoundException
     */


    public static void printResult(File idList, Scanner consoleInput) throws FileNotFoundException {

        // This scanner goes through the list with the patient ID numbers and profiles

        Scanner idListScnr = new Scanner(idList);

        // This prompts the user for the prescription drugs file and goes through the
        // file to read it with the Scanner.

        System.out.print("Enter absolute path of prescription drugs file: ");

        File drugsPrescription = new File(consoleInput.nextLine().replace("\"", " ").trim());

        Scanner drugsScnr = new Scanner(drugsPrescription);

        // This is the PrintStream for the output file that prints to the output file

        System.out.print("Enter the absolute path of the output file: ");

        File outFile = new File(consoleInput.nextLine().replace("\"", " ").trim());

        PrintStream numOutFile = new PrintStream(outFile);

        // This while loop goes through the scanners and outputs the ID number with the
        // drug info for the patient.

        while (idListScnr.hasNextLine()) {
            int id = idListScnr.nextInt();
            idListScnr.nextLine();
            String drugInfo = drugsScnr.nextLine();
            
            numOutFile.println(id + " --- " + drugInfo);

        }

        idListScnr.close();
        consoleInput.close();
        numOutFile.close();

    }

}
