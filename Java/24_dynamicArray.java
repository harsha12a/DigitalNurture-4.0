import java.util.Scanner;
import java.util.ArrayList;

class DynamicArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> arr = new ArrayList<>();

        System.out.println("Enter elements for the dynamic array (type 'exit' to stop):");
        while (true) {
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            arr.add(input);
        }

        System.out.println("Elements in the dynamic array:");
        for (String element : arr) {
            System.out.print(element + ", ");
        }
        sc.close();
    }
}
