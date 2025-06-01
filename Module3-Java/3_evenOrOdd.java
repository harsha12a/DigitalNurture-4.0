import java.util.Scanner;
class evenOrOdd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num;
        try {
            num = sc.nextInt();
        }
        catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid integer.");
            sc.close();
            return;
        }
        if (num % 2 == 0) {
            System.out.println(num + " is even.");
        } else {
            System.out.println(num + " is odd.");
        }
        
        sc.close();
    }
}
