import java.util.Scanner;

class StringRev {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string to reverse: ");
        String str = sc.nextLine();
        // String reversed = "";
        // for (int i = str.length() - 1; i >= 0; i--) {
        //     reversed += str.charAt(i);
        // }
        String reversed = new StringBuilder(str).reverse().toString();
        System.out.println("Reversed string: " + reversed);
        sc.close();
    }
}
