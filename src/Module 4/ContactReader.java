
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ContactReader {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the conact file: ");
        String fileName = scanner.nextLine();

        int conatctCount = 0;

        try {
            BufferedReader bufferReader = new BufferedReader(new FileReader(fileName));
            String line;

            System.out.println("\n===== CONTACT LIST =====");

            while ((line = bufferReader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    String[] parts = line.split(":");

                    if (parts.length == 2) {
                        String name = parts[0].trim();
                        String number = parts[1].trim();

                        System.err.println("name: " +name+ " number: " + number);
                        conatctCount++;
                    }else{
                        System.out.println("The line format does not matched in line: " + line);
                    }

                }

            }

            bufferReader.close();

            System.out.println("total contacts read: " + conatctCount);

        } catch (FileNotFoundException e) {
            System.out.println("File not founded " + e.getMessage());
        }catch (IOException e){
            System.out.println("Invalid input " + e.getMessage());
        }finally{
            scanner.close();
        }
    }

}
