import java.util.Scanner;
import java.io.FileWriter;

class WriteFile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text to write to file: ");
        String text = sc.nextLine();
        
        try {
            FileWriter writer = new FileWriter("output.txt");
            writer.write(text);
            writer.close();
            System.out.println("Text written to file successfully.");
        } catch (Exception e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
