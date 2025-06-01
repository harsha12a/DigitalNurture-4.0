import java.util.Scanner;
class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public double divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Division by zero is not allowed.");
        }
        return (double) a / b;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter two numbers: ");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        Calculator calculator = new Calculator();
        System.out.println("Choose an operation:");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.println(num1 + " + " + num2 + " = " + calculator.add(num1, num2));
                break;
            case 2:
                System.out.println(num1 + " - " + num2 + " = " + calculator.subtract(num1, num2));
                break;
            case 3:
                System.out.println(num1 + " * " + num2 + " = " + calculator.multiply(num1, num2));
                break;
            case 4:
                try {
                    System.out.println(num1 + " / " + num2 + " = " + calculator.divide(num1, num2));
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
                break;
            default:
                System.out.println("Invalid choice");
        }
        sc.close();
    }
}
