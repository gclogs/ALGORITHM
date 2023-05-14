import java.util.Scanner;

//  4로 나누어 떨어지면 우선 윤년으로 판단하고, 그 중 400이 아닌 100으로만 나누어 떨어지는 경우를 평년으로 판단한다.
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int num = sc.nextInt();
    sc.close();

    if (num % 4 == 0) {
      if (num % 400 != 0 && num % 100 == 0) {
        System.out.print("asdf" + 0);
      } else {
        System.out.print(1);
      }
    } else {
      System.out.print("asdf" + 0);
    }

  }
}
