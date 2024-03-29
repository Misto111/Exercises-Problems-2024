import java.util.Scanner;

public class HalfSumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());


        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 1; i <= n; i++) {

            int num = Integer.parseInt(scanner.nextLine());

            sum += num;

            if (num > max) {
                max = num;
            }


        }
        int sum2 = sum - max;

        if (sum2 == max) {
            System.out.println("Yes");
            System.out.printf("Sum = %d", sum2);
        } else {
            int diff = Math.abs(max - sum2);
            System.out.println("No");
            System.out.printf("Diff = %d%n", diff);

        }
    }
}
