import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    int num1 = sc.nextInt();
    String num2 = sc.next();

    sc.close();

    String[] arr = num2.split("", num2.length());
    for(int i=arr.length-1; i>=0; i--) {
      System.out.println(num1 * Integer.parseInt(arr[i]));
    }
    System.out.println(num1 * Integer.parseInt(num2));
  }
}

