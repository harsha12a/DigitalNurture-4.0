import java.util.Scanner;
class LeapYear {
    public static boolean isLeapYear(int n) {
        if(n % 400 == 0) return true;
        else if(n % 100 == 0) return false;
        else if(n % 4 == 0) return true;
        else return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a year: ");
        int year;
        try {
            year = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid integer.");
            sc.close();
            return;
        }
        
        if (isLeapYear(year)) {
            System.out.println(year + " is a leap year.");
        } else {
            System.out.println(year + " is not a leap year.");
        }
        
        sc.close();
    }
}
