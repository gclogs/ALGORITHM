import java.util.Scanner;
import java.io.IOException;

public class SolveforScanner {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);

    int num1 = sc.nextInt();
    int num2 = sc.nextInt();

    sc.close();
    
    System.out.println(num1 + num2);
    System.out.println(num1 - num2);
    System.out.println(num1 * num2);
    System.out.println(num1 / num2);
    System.out.println(num1 % num2);

  }
}
