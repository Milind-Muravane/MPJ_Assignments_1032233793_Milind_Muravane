import java.io.*;
import java.util.Scanner;

public class Assignment4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int c;
        String filename = "file.txt";

        do {
            System.out.println("\nFile Operations");
            System.out.println("1.To write in a file");
            System.out.println("2.To read in a file");
            System.out.println("3.To append in a file");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            c = scanner.nextInt();
            scanner.nextLine(); 

            switch (c) {

                case 1:
                    try {
                        FileWriter fw = new FileWriter(filename);
                        System.out.print("Enter your text to write in a file: ");
                        String data = scanner.nextLine();
                        fw.write(data);
                        fw.close();
                        System.out.println("Data written!");
                    } catch (IOException error_w) {
                        System.out.println("Error in writing the file: " + error_w.getMessage());
                    } finally {
                        System.out.println("Writing completed");
                    }
                    break;

                case 2:
                    try {
                        FileReader fr = new FileReader(filename);
                        BufferedReader br = new BufferedReader(fr);

                        String line;
                        System.out.println("\nFile Content is:");
                        while ((line = br.readLine()) != null) {
                            System.out.println(line);
                        }

                        br.close();
                    } catch (FileNotFoundException e) {
                        System.out.println("File not found!");
                    } catch (IOException error_r) {
                        System.out.println("Error in reading the file: " + error_r.getMessage());
                    } finally {
                        System.out.println("Reading completed!");
                    }
                    break;

                case 3:
                    try {
                        FileWriter fw = new FileWriter(filename, true); // append mode
                        System.out.print("Enter your text to append: ");
                        String data = scanner.nextLine();
                        fw.write("\n" + data);
                        fw.close();
                        System.out.println("Appedning successful!");
                    } catch (IOException error_a) {
                        System.out.println("Error appending file: " + error_a.getMessage());
                    } finally {
                        System.out.println("Appending completed!");
                    }
                    break;

                case 4:
                    System.out.println("Exiting the code...");
                    break;

                default:
                    System.out.println("Invalid!");
            }

        } while (c != 4);

        scanner.close();
    }
}