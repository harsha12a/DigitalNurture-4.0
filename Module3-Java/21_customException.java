import java.util.Scanner;

class MyException extends Exception {
    public MyException(String message) {
        super(message);
    }
}

class CustomException {
    public static void isPositive(int number) throws MyException {
        if (number < 0) {
            throw new MyException("Number is negative");
        }
        else {
            System.out.println("Number is positive: " + number);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        try {
            isPositive(num);
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
        sc.close();
    }
}
