import java.util.HashMap;
import java.util.Scanner;

class StudentMap {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter key val pairs (type 'exit' to stop): ");
        while (true) {
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            String[] parts = input.split(" ");
            if (parts.length == 2) {
                try {
                    int key = Integer.parseInt(parts[0]);
                    String value = parts[1];
                    map.put(key, value);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid key format. Please enter an integer key.");
                }
            } else {
                System.out.println("Please enter a key and a value separated by a space.");
            }
        }

        System.out.println("Enter a key to search for its value: ");
        try {
            int searchId = Integer.parseInt(sc.nextLine());
            if (map.containsKey(searchId)) {
                System.out.println("Student name: " + map.get(searchId));
            } else {
                System.out.println("No student found with ID " + searchId);
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID entered.");
        }
        sc.close();
    }
}
