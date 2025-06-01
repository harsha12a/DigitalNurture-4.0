import java.util.Scanner;

class SumAndAvg {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        
        if (n <= 0) {
            System.out.println("Please enter a positive integer.");
            sc.close();
            return;
        }
        int[] ar = new int[n];
        System.out.println("You will enter " + n + " numbers.");
        for (int i = 0; i < n; i++) {
            System.out.print("Enter number " + (i+1) + ": ");
            ar[i] = sc.nextInt();
        }
        
        int sum = 0;
        for(int num : ar) {
            sum += num;
        }
        
        double avg = (double) sum / n;
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + avg);
        
        sc.close();
    }
}
