import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            String pathName = "";
            File file = new File(pathName);

            // Scans the contents of file.
            Scanner scanner = new Scanner(file);

            // Stores the number of times the text "Bangalore" is repeated.
            int count = 0;

            // Stores resulting String.
            StringBuilder stringBuilder = new StringBuilder();

            // Reads file line by line.
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();

                // Splits the line into an array on the basis of text "Bangalore".
                String[] lineWithoutBangaloreArray = line.split("Bangalore");

                // Total number of times "Bangalore" repeated is the length of array lineWithoutBangaloreArray.
                count += (lineWithoutBangaloreArray.length - 1);

                // Replaces the text "Bangalore" with "Bangalore\n".
                line = line.replaceAll("Bangalore", "Bangalore\n");

                // Updating StringBuilder.
                stringBuilder.append(line);
            }

            // Prints the number of times "Bangalore" was repeated.
            System.out.println("Number of times the text \"Bangalore\" was repeated = " + count);

            // Closes the scanner.
            scanner.close();

            // Stores the updated description.
            String updated = stringBuilder.toString();

            // Writes contents of String updated to a new file.
            String fileName = "";
            FileWriter writer = new FileWriter(fileName);

            // Writes updated to file.
            writer.write(updated);

            // Closes the writer.
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found. " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Cannot access file. " + e.getMessage());
        }
    }
}